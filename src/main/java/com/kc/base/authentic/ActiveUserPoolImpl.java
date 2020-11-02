package com.kc.base.authentic;

import com.kc.project.entity.SysUser;

import java.util.*;

/**
 * @Author: Ma
 * @Date:2020-10-14 13:58
 */
public class ActiveUserPoolImpl implements  ActiveUserPool {

    HashMap<String,ActiveSysUser> hstable = new HashMap<String,ActiveSysUser>();
    HashMap<String, Date> limitUser = new HashMap<String,java.util.Date>();
    HashMap<String, List<Date>> userVisit = new HashMap<String, List<Date>>();

    private ActiveUserPoolImpl (){

    }

    private static ActiveUserPoolImpl aupimpl = new ActiveUserPoolImpl();

    public static ActiveUserPoolImpl getInstance()
    {
        return aupimpl;
    }

    /**
     * 将 user 转换为ActiveMdmUser实例  在map中加入
     */
    public void addUser(String token,SysUser user) {
        //state();
        ActiveSysUser auBean = new ActiveSysUser(token,user);
        auBean.setToken(token);
        auBean.setUser(user);
        auBean.setTs(new Date());
        hstable.put(token, auBean);
    }
    /**
     * 清空 map
     */
    public void clean() {
        hstable.clear();
    }
    /**
     * 遍历用户池，用当前时间减去实例中得时间戳时间，时间差大于activeTime，则将实例移出
     */
    public void cleanUnactiveUser() {
        if(hstable.size()>0){
            Collection<ActiveSysUser> collection = hstable.values();
            Iterator<ActiveSysUser> itMdmUser=collection.iterator();
            while(itMdmUser.hasNext())
            {
                ActiveSysUser bean=itMdmUser.next();
                String token=bean.getToken();
                long start = bean.getTs().getTime();
                long end = System.currentTimeMillis();
                if(end-start>activeTime)
                {
                    itMdmUser.remove();
                    hstable.remove(token);
                }
            }
        }
        if(limitUser.size()>0){
            Iterator<Map.Entry<String, Date>> it = limitUser.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<String, Date> entry = it.next();
                long startLimit = entry.getValue().getTime();//开始被禁用时间
                long endLimit = System.currentTimeMillis();
                if(endLimit-startLimit>limitTime) {
                    it.remove();
                }
            }
        }
        if(userVisit.size() > 0) {
            for (List<Date> list : userVisit.values()) {
                Iterator<Date> itd = list.iterator();
                while(itd.hasNext()){
                    long s = itd.next().getTime();//访问时间。只存一分钟之内的数据
                    long e = System.currentTimeMillis();
                    if(( e - s) > (60 * 1000)) {
                        itd.remove();
                    }
                }
            }
        }
    }
    /**
     *  获取池中实例数目
     */
    public int getCount() {
        return hstable.size();
    }
    /**
     * 通过用户ID在池中查找用户实例集合
     */
    @SuppressWarnings("unchecked")
    public List<SysUser> getUserByCode(String code) {
        if(hstable.size()==0){
            return null;
        }
        else{
            Collection<ActiveSysUser> collection = hstable.values();
            for(ActiveSysUser bean:collection)
            {
                String scode = bean.getUser().getCode();
                if(code.equals(scode))
                {
                    return (List<SysUser>) bean.getUser();
                }
            }
        }
        return null;
    }
    /**
     * 通过令牌获取用户实例
     * 当调用该函数时，需要改变池中activeUser中的时间戳。
     * activeUser 中的时间戳标识用户最后活动时间。
     * 用户定时清理程序根据该时间戳清理池中的用户。如果不改变，清理程序将在activetime后将实例清除。
     */
    public SysUser getUserByToken(String token) {
        Date d1 = new Date();

        SysUser bean = null;
        if(hstable != null){
            ActiveSysUser activeBean=hstable.get(token);
            if(activeBean==null){
                return null;
            }else{
//				writeLog("改变前用户ts:"+DateUtils.dateToStrLong(activeBean.getTs()));
                activeBean.setTs(new Date());
                bean = activeBean.getUser();
                String pwd = bean.getPassword();
//				pwd=new Encode().decode(pwd);
                bean.setPassword(pwd);
            }
           /* writeLog("用户ts:"+DateUtils.dateToStrLong(activeBean.getTs()));*/
        }
      /*  writeLog("通过token从活动用户池中获取用户信息用时：" + (new Date().getTime() - d1.getTime()) + "毫秒");*/
        return bean;
    }

    boolean isInPool(String account){
        if(hstable.size()==0){
            return false;
        }
        else{
            Collection<ActiveSysUser> collection = hstable.values();
            for(ActiveSysUser bean:collection)
            {
                String saccount = bean.getUser().getCode();
                if(saccount.equals(account))
                {
                    return true;
                }
            }
        }
        return false;

    }
    /**
     * 移出用户实例
     * 以用户ID为标准
     */
    public void removeUser(SysUser user) {
        String sid = user.getId();
        if(hstable.size()==0)
            return;
        else{
            Collection<ActiveSysUser> collection = hstable.values();
            for(ActiveSysUser bean:collection){
                String id = bean.getUser().getId();
                if(id.equals(sid))
                {
                    hstable.remove(sid);
                }
            }
        }

    }
    /**
     * 服务启动后，在固定时间间隔中反复执行该函数
     * 	注意Map的多线程访问问题
     */
    public void run() {
        cleanUnactiveUser();
    }
    /**
     * 通过令牌移出用户
     * 可以使用下面两个函数实现
     * 	getUserByToken();
     * removeUser();
     */
    public void removeUserByToken(String token) throws Exception {
        hstable.remove(token);
    }
    /**
     * 返回活动用户集合
     */
    public List<SysUser> list() throws Exception {
        List<SysUser> list = null;
        if(hstable.size()==0)
            return null;
        else{
            Collection<ActiveSysUser> collection = hstable.values();
            for(ActiveSysUser bean:collection)
            {
                SysUser user = bean.getUser();
                list.add(user);
            }
        }
        return list;
    }
    public String getTokenByUserId(String id) {

        Set<String> keySet = hstable.keySet();

        for(String token : keySet){
            SysUser user = hstable.get(token).getUser();
            if(user.getId().equals(id))
                return token;
        }

        return "";
    }


    private void state(){
        //System.out.println("active user count " + hstable.size());

    }
    public boolean getLimitStstus(String userId) {
        return limitUser.get(userId) != null;
    }
    public void addLimitUser(String userId) {
        limitUser.put(userId, new Date());
    }

    public void addVisitUser(String userId) {
        if(userId == null) {
            return;
        }
        List<Date> list = userVisit.get(userId);
        if(list == null) {
            list = new ArrayList<Date>();
            list.add(new Date());
            userVisit.put(userId, list);
        }else {
            list.add(new Date());
        }

    }

    public int getVisitCount(String userId) {
        if(userId == null) {
            return 0;
        }
        List<Date> list = userVisit.get(userId);
        if(list == null) {
            return 0;
        }else {
            return list.size();
        }
    }
}



class ActiveSysUser {

        public ActiveSysUser(String token, SysUser mdmUser) {
            this.setTs(new Date());
            this.token = token;
            this.user = mdmUser;
        }

        /**
         *
         */
        SysUser user;
        /**
         *
         */
        String token;
        /**
         *
         */
        java.util.Date ts;

        public SysUser getUser() {
            return user;
        }

        public void setUser(SysUser user) {
            this.user = user;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public java.util.Date getTs() {
            return ts;
        }

        public void setTs(java.util.Date ts) {
            this.ts = ts;
        }
    }



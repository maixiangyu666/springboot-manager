package com.kc.base.authentic;

import com.kc.base.utils.DictUtil;
import com.kc.project.entity.SysUser;

import java.util.List;

/**
 * @Author: Ma
 * @Date:2020-10-14 10:28
 */
public interface ActiveUserPool extends Runnable {


    public static int activeTime = 1000 * Integer.parseInt(DictUtil.getDictValue("SYS_DICT", "TOKEN_TIME"));

    public static int limitTime = 1000 * Integer.parseInt(DictUtil.getDictValue("SYS_DICT", "LIMIT_TIME"));

    /**
     * 增加一个用户到池中
     * @param user
     */
    public void addUser(String token, SysUser user)throws Exception;
    /**
     * 移去一个用户
     * @param user
     */
    public void removeUser(SysUser user)throws Exception;
    /**
     * 根据用户身份令牌移出一个用户帐户实例
     * @param token
     * @throws Exception
     */
    public void removeUserByToken(String token)throws Exception;
    /**
     * 通过用户ID获取用户实例
     * @param
     */
    public List<SysUser> getUserByCode(String code)throws Exception;
    /**
     * 通过用户令牌获取用户类实例
     * @param token
     */
    public SysUser getUserByToken(String token)throws Exception;
    /**
     * 清除池中所有实例
     */
    public void clean()throws Exception;
    /**
     * 获取池中所有实例的数目
     */
    public int getCount()throws Exception;
    /**
     * 获取ActiveMdmUser iterator
     * @return
     */
    public List<SysUser> list()throws Exception;
    /**
     * 清理不活动的用户
     */
    public void cleanUnactiveUser();
    /**
     * 通过用户ID获取用户令牌，如果池中没有该用户，返回null
     * @return
     */
    public String getTokenByUserId(String id);

    /**
     * 通过用户ID获取用户是否被禁用状态
     * @param userId
     * @return
     */
    public boolean getLimitStstus(String userId);

    /**
     * 添加禁用用户
     * @param userId
     */
    public void addLimitUser(String userId);

    /**
     * 添加访问用户次数
     * @param userId
     */
    public void addVisitUser(String userId);

    /**
     * 获取访问次数
     * @param userId
     * @return
     */
    public int getVisitCount(String userId);

}

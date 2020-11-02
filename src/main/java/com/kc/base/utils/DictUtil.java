package com.kc.base.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kc.project.entity.SysDictDetailEntity;
import com.kc.project.entity.SysDictEntity;
import com.kc.project.service.SysDictDetailService;
import com.kc.project.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ma
 * @Date:2020-10-14 11:01
 */
public class DictUtil {

    public static Map<String, HashMap> DictMap = new HashMap<>();

    @Autowired
    private SysDictService sysDictServiceImpl;

    @Autowired
    private SysDictDetailService sysDictDetailServiceImpl;


    @PostConstruct
    public void init(){
        System.out.println("加载缓存Map...");
        List<SysDictEntity> SysDictEntitys = sysDictServiceImpl.list();
        QueryWrapper<SysDictDetailEntity> wrapper=new QueryWrapper();
        for(SysDictEntity dict : SysDictEntitys){
            wrapper.eq("dict_id",dict.getId());
            List<SysDictDetailEntity> SysDictDetailEntitys = sysDictDetailServiceImpl.list(wrapper);
            HashMap dictItem=new HashMap<>();
            for(SysDictDetailEntity  SysDictDetail : SysDictDetailEntitys){
                dictItem.put(SysDictDetail.getLabel(),SysDictDetail.getValue());
                DictMap.put(dict.getName(),dictItem);
            }
        }
    }

   public static HashMap<String, String> getDictItem(String dictcode){
       HashMap<String, String> hmpkey = null;
       if(DictMap.containsKey(dictcode))
       {
           hmpkey = (HashMap)DictMap.get(dictcode);
       }
       return hmpkey;
   }

   public static String getDictValue(String dictcode ,String dictkey){
       HashMap<String, String> dictItem = getDictItem(dictcode);
           if(dictItem.containsKey(dictkey)){
              String str = dictItem.get(dictkey);
              return  str;
           }
       return null;
   }



}

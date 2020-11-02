package com.kc.project.controller;

import com.kc.project.entity.ResourceTypeEntity;
import com.kc.project.service.ResourceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ma
 * @Date:2020-10-16 9:03
 */
@Controller
@RequestMapping("/weixin")
public class WeixinResourceTypeController {
    @Resource
    private ResourceTypeService  resourceTypeService;

    @RequestMapping("/index")
    public ModelAndView toIndex(){
        Map map = new HashMap<>();
        map.put("dr",1);
        List<ResourceTypeEntity> list = resourceTypeService.listByMap(map);
        ModelAndView mv =new ModelAndView();
        mv.addObject("types",list);
        mv.setViewName("weixin/index.html");
        return mv;
    }


    @RequestMapping("/list")
    public String toList(){
        return "weixin/list.html";
    }


    @RequestMapping("/detail")
    public String toDetail(){
        return "weixin/detail.html";
    }

}

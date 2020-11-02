package com.kc.project.controller.weixin;

import com.kc.project.entity.ResourceEntity;
import com.kc.project.service.PlatTypeService;
import com.kc.project.service.PlatformService;
import com.kc.project.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: Ma
 * @Date:2020-10-17 22:39
 */
@Controller
@RequestMapping("/weixin")
public class WeixinPlatformController {


    @Autowired
    private ResourceService resourceService;


    @RequestMapping("/toDetail")
    public ModelAndView toDetail(String resourceId){
        ModelAndView mv=new ModelAndView();
        ResourceEntity resourceEntities = resourceService.selResourceDetail(resourceId);
        mv.addObject("resources",resourceEntities);
        mv.addObject("resourceId",resourceId);
        mv.setViewName("weixin/detail.html");
        return  mv;

    }
}

package com.kc.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kc.project.common.utils.DataResult;
import com.kc.project.common.utils.DateUtils;
import com.kc.project.entity.ResourceEntity;
import com.kc.project.service.ResourceService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: Ma
 * @Date:2020-10-17 16:15
 */
@Controller
@RequestMapping("/weixin")
public class WeixinResourceController {


    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/toResource")
    public ModelAndView toResource(String resourceType){
      ModelAndView mv=new ModelAndView();
        List<ResourceEntity> resources = resourceService.selResourceByTypeId(resourceType);
        resources=resourceService.selPlatTypes(resources);
        mv.addObject("resources",resources);
        mv.setViewName("weixin/list.html");
        return mv;
  }


    @RequestMapping("/searchResource")
    public ModelAndView searchResource(String resourcename){
        ModelAndView mv=new ModelAndView();
        QueryWrapper<ResourceEntity> query =new QueryWrapper();
        query.like("name",resourcename);
        query.eq("dr",1);
        List<ResourceEntity> resources = resourceService.list(query);
        mv.addObject("resources",resources);
        mv.setViewName("weixin/list.html");
        return mv;
    }


    @GetMapping("/addCount")
    @ResponseBody
    public String update( ResourceEntity resource){
        resource.setLastupdatetime(DateUtils.getNowDate());
        resourceService.updateById(resource);
        return "ok";
    }

}

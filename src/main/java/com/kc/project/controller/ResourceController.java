package com.kc.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.kc.project.common.utils.DateUtils;
import com.kc.project.entity.PlatTypeEntity;
import com.kc.project.entity.ResourceTypeEntity;
import com.kc.project.service.PlatTypeService;
import com.kc.project.service.ResourceTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kc.project.common.utils.DataResult;

import com.kc.project.entity.ResourceEntity;
import com.kc.project.service.ResourceService;
import org.springframework.web.servlet.ModelAndView;


/**
 * 资源
 *
 * @author mxy
 * @email ${email}
 * @date 2020-10-17 16:17:41
 */
@Controller
@RequestMapping("/")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ResourceTypeService resourceTypeService;

    @Autowired
    private PlatTypeService platTypeService;




    /**
    * 跳转到页面
    */
    @GetMapping("/index/resource")
    public ModelAndView resource() {
        List<ResourceTypeEntity> list = resourceTypeService.list();

        ModelAndView mv=new ModelAndView();
        mv.setViewName("resource/list");
        mv.addObject("types",list);
        return mv;
    }

    @ApiOperation(value = "新增")
    @PostMapping("resource/add")
    @RequiresPermissions("resource:add")
    @ResponseBody
    public DataResult add(@RequestBody ResourceEntity resource){
        resource.setCreatetime(DateUtils.getNowDate());
        resource.setTypeName(selTypeName(resource).getResourceTypeName());
        resourceService.save(resource);
        return DataResult.success();
    }



    @ApiOperation(value = "跳转资源明细界面")
    @GetMapping(value="resource/param")
    public ModelAndView param( String resourceid){
        ModelAndView mv=new ModelAndView();
        List<PlatTypeEntity> list = platTypeService.list();
        mv.addObject("plattypes",list);
        mv.addObject("resourceid",resourceid);
        mv.setViewName("/platform/list");
        return  mv;
    }

    private ResourceTypeEntity selTypeName(ResourceEntity resource){
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("resource_type",resource.getTypeId());
        return resourceTypeService.getOne(queryWrapper);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("resource/delete")
    @RequiresPermissions("resource:delete")
    @ResponseBody
    public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids){
        resourceService.removeByIds(ids);
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("resource/update")
    @RequiresPermissions("resource:update")
    @ResponseBody
    public DataResult update(@RequestBody ResourceEntity resource){
        resource.setLastupdatetime(DateUtils.getNowDate());
        resource.setTypeName(selTypeName(resource).getResourceTypeName());
        resourceService.updateById(resource);
        return DataResult.success();
    }

    @ApiOperation(value = "查询分页数据")
    @PostMapping("resource/listByPage")
    @RequiresPermissions("resource:list")
    @ResponseBody
    public DataResult findListByPage(@RequestBody ResourceEntity resource){
        Page page = new Page(resource.getPage(), resource.getLimit());
        LambdaQueryWrapper<ResourceEntity> queryWrapper = Wrappers.lambdaQuery();
        //查询条件示例
        //queryWrapper.eq(ResourceEntity::getId, resource.getId());
        IPage<ResourceEntity> iPage = resourceService.page(page, queryWrapper);
        return DataResult.success(iPage);
    }

}

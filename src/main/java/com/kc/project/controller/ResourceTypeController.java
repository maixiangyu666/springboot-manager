package com.kc.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.kc.project.common.utils.DateUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import com.kc.project.common.utils.DataResult;

import com.kc.project.entity.ResourceTypeEntity;
import com.kc.project.service.ResourceTypeService;



/**
 * 资源类型
 *
 * @author mxy
 * @email ${email}
 * @date 2020-10-16 16:42:33
 */
@Controller
@RequestMapping("/")
public class ResourceTypeController {
    @Autowired
    private ResourceTypeService resourceTypeService;


    /**
    * 跳转到页面
    */
    @GetMapping("/index/resourceType")
    public String resourceType() {
        return "resourcetype/list";
        }

    @ApiOperation(value = "新增")
    @PostMapping("resourceType/add")
    @RequiresPermissions("resourceType:add")
    @ResponseBody
    public DataResult add(@RequestBody ResourceTypeEntity resourceType){
        resourceType.setCreatetime(DateUtils.getNowDate());
        resourceTypeService.save(resourceType);
        return DataResult.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("resourceType/delete")
    @RequiresPermissions("resourceType:delete")
    @ResponseBody
    public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids){
        resourceTypeService.removeByIds(ids);
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("resourceType/update")
    @RequiresPermissions("resourceType:update")
    @ResponseBody
    public DataResult update(@RequestBody ResourceTypeEntity resourceType){
        resourceType.setLastupdatetime(DateUtils.getNowDate());
        resourceTypeService.updateById(resourceType);
        return DataResult.success();
    }

    @ApiOperation(value = "查询分页数据")
    @PostMapping("resourceType/listByPage")
    @RequiresPermissions("resourceType:list")
    @ResponseBody
    public DataResult findListByPage(@RequestBody ResourceTypeEntity resourceType){
        Page page = new Page(resourceType.getPage(), resourceType.getLimit());
        LambdaQueryWrapper<ResourceTypeEntity> queryWrapper = Wrappers.lambdaQuery();
        //查询条件示例
        //queryWrapper.eq(ResourceTypeEntity::getId, resourceType.getId());
        IPage<ResourceTypeEntity> iPage = resourceTypeService.page(page, queryWrapper);
        return DataResult.success(iPage);
    }

}

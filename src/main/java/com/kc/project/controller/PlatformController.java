package com.kc.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.kc.project.entity.PlatTypeEntity;
import com.kc.project.entity.ResourceEntity;
import com.kc.project.entity.ResourceTypeEntity;
import com.kc.project.service.PlatTypeService;
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

import com.kc.project.entity.PlatformEntity;
import com.kc.project.service.PlatformService;



/**
 * 平台及其URL
 *
 * @author mxy
 * @email ${email}
 * @date 2020-10-17 17:50:09
 */
@Controller
@RequestMapping("/")
public class PlatformController {
    @Autowired
    private PlatformService platformService;

    @Autowired
    private PlatTypeService platTypeService;



    /**
    * 跳转到页面
    */
    @GetMapping("/index/platform")
    public String platform() {
        return "platform/list";
        }

    @ApiOperation(value = "新增")
    @PostMapping("platform/add")
    @ResponseBody
    public DataResult add(@RequestBody PlatformEntity platform){
        PlatTypeEntity platTypeEntity = selPlatTypeName(platform);
        platform.setPlattypename(platTypeEntity.getPlatTypeName());
        platformService.save(platform);
        return DataResult.success();
    }

    private PlatTypeEntity selPlatTypeName(PlatformEntity platform){
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",platform.getPlattype());
        return platTypeService.getOne(queryWrapper);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("platform/delete")
    @ResponseBody
    public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids){
        platformService.removeByIds(ids);
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("platform/update")
    @ResponseBody
    public DataResult update(@RequestBody PlatformEntity platform){
        PlatTypeEntity platTypeEntity = selPlatTypeName(platform);
        platform.setPlattypename(platTypeEntity.getPlatTypeName());
        platformService.updateById(platform);
        return DataResult.success();
    }

    @ApiOperation(value = "查询分页数据")
    @PostMapping("platform/listByPage")
    @ResponseBody
    public DataResult findListByPage(@RequestBody PlatformEntity platform,String resourceid){
        Page page = new Page(platform.getPage(), platform.getLimit());
        LambdaQueryWrapper<PlatformEntity> queryWrapper = Wrappers.lambdaQuery();
        //查询条件示例
        queryWrapper.eq(PlatformEntity::getResourceId, resourceid);
        IPage<PlatformEntity> iPage = platformService.page(page, queryWrapper);
        return DataResult.success(iPage);
    }

}

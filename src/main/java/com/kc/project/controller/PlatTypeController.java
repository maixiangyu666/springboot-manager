package com.kc.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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

import com.kc.project.entity.PlatTypeEntity;
import com.kc.project.service.PlatTypeService;



/**
 * 平台维护
 *
 * @author mxy
 * @email ${email}
 * @date 2020-10-17 18:38:26
 */
@Controller
@RequestMapping("/")
public class PlatTypeController {
    @Autowired
    private PlatTypeService platTypeService;


    /**
    * 跳转到页面
    */
    @GetMapping("/index/platType")
    public String platType() {
        return "plattype/list";
        }

    @ApiOperation(value = "新增")
    @PostMapping("platType/add")
    @RequiresPermissions("platType:add")
    @ResponseBody
    public DataResult add(@RequestBody PlatTypeEntity platType){
        platTypeService.save(platType);
        return DataResult.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("platType/delete")
    @RequiresPermissions("platType:delete")
    @ResponseBody
    public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids){
        platTypeService.removeByIds(ids);
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("platType/update")
    @RequiresPermissions("platType:update")
    @ResponseBody
    public DataResult update(@RequestBody PlatTypeEntity platType){
        platTypeService.updateById(platType);
        return DataResult.success();
    }

    @ApiOperation(value = "查询分页数据")
    @PostMapping("platType/listByPage")
    @RequiresPermissions("platType:list")
    @ResponseBody
    public DataResult findListByPage(@RequestBody PlatTypeEntity platType){
        Page page = new Page(platType.getPage(), platType.getLimit());
        LambdaQueryWrapper<PlatTypeEntity> queryWrapper = Wrappers.lambdaQuery();
        //查询条件示例
        //queryWrapper.eq(PlatTypeEntity::getId, platType.getId());
        IPage<PlatTypeEntity> iPage = platTypeService.page(page, queryWrapper);
        return DataResult.success(iPage);
    }

}

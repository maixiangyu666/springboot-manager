package com.kc.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.kc.project.common.utils.DateUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import com.kc.project.common.utils.DataResult;

import com.kc.project.entity.SysParamEntity;
import com.kc.project.service.SysParamService;


/**
 * 服务参数
 *
 * @author mxy
 * @email ${email}
 * @date 2020-10-02 16:11:13
 */
@Controller
@RequestMapping("/")
public class SysParamController {
    @Autowired
    private SysParamService sysParamService;


    /**
    * 跳转到页面
    */
    @GetMapping("/index/sysParam")
    public String sysParam() {
        return "sysparam/list";
        }

    @ApiOperation(value = "新增")
    @PostMapping("sysParam/add")
    @RequiresPermissions("sysParam:add")
    @ResponseBody
    public DataResult add(@RequestBody SysParamEntity sysParam){
        sysParam.setCreatetime(DateUtils.getNowDate());
        sysParamService.save(sysParam);
        return DataResult.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("sysParam/delete")
    @RequiresPermissions("sysParam:delete")
    @ResponseBody
    public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids){
        sysParamService.removeByIds(ids);
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("sysParam/update")
    @RequiresPermissions("sysParam:update")
    @ResponseBody
    public DataResult update(@RequestBody SysParamEntity sysParam){
        sysParam.setLastupdatetime(DateUtils.getNowDate());
        sysParamService.updateById(sysParam);
        return DataResult.success();
    }



    @ApiOperation(value = "查询分页数据")
    @PostMapping("sysParam/listByPage")
    @RequiresPermissions("sysParam:list")
    @ResponseBody
    public DataResult findListByPage(String serviceid,@RequestBody SysParamEntity sysParam){
        Page page = new Page(sysParam.getPage(), sysParam.getLimit());
        LambdaQueryWrapper<SysParamEntity> queryWrapper = Wrappers.lambdaQuery();
        //查询条件示例
        queryWrapper.eq(SysParamEntity::getServiceId, serviceid);
        IPage<SysParamEntity> iPage = sysParamService.page(page, queryWrapper);
        return DataResult.success(iPage);
    }

}

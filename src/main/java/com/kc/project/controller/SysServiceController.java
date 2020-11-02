package com.kc.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.kc.project.common.utils.DateUtils;
import com.kc.project.service.SysParamService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.Date;
import java.util.List;
import com.kc.project.common.utils.DataResult;

import com.kc.project.entity.SysServiceEntity;
import com.kc.project.service.SysServiceService;
import org.springframework.web.servlet.ModelAndView;


/**
 * 服务管理
 *
 * @author mxy
 * @email ${email}
 * @date 2020-07-21 15:04:56
 */
@Controller
@RequestMapping("/")
public class SysServiceController {
    @Autowired
    private SysServiceService sysServiceService;
    @Autowired
    private SysParamService sysParamService;

    /**
    * 跳转到页面
    */
    @GetMapping("/index/sysService")
    public String sysService() {
        return "sysservice/list";
        }


    @ApiOperation(value = "跳转参数界面")
    @GetMapping(value="sysService/param")
    public ModelAndView param( String serviceid){
        ModelAndView mv=new ModelAndView();
        mv.addObject("serviceid",serviceid);
        mv.setViewName("/sysparam/list");
        return  mv;
    }

    @ApiOperation(value = "新增")
    @PostMapping("sysService/add")
    @RequiresPermissions("sysService:add")
    @ResponseBody
    public DataResult add(@RequestBody SysServiceEntity sysService){
        sysService.setCreatetime(DateUtils.format(new Date(),DateUtils.DATE_TIME_PATTERN));
        sysServiceService.save(sysService);
        return DataResult.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("sysService/delete")
    @RequiresPermissions("sysService:delete")
    @ResponseBody
    public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids){
        sysServiceService.removeByIds(ids);
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("sysService/update")
    @RequiresPermissions("sysService:update")
    @ResponseBody
    public DataResult update(@RequestBody SysServiceEntity sysService){
        sysService.setLastupdatetime(DateUtils.format(new Date(),DateUtils.DATE_TIME_PATTERN));
        sysServiceService.updateById(sysService);
        return DataResult.success();
    }

    @ApiOperation(value = "查询分页数据")
    @PostMapping("sysService/listByPage")
    @RequiresPermissions("sysService:list")
    @ResponseBody
    public DataResult findListByPage(@RequestBody SysServiceEntity sysService){
        Page page = new Page(sysService.getPage(), sysService.getLimit());
        LambdaQueryWrapper<SysServiceEntity> queryWrapper = Wrappers.lambdaQuery();
        //查询条件示例
        //queryWrapper.eq(SysServiceEntity::getId, sysService.getId());
        IPage<SysServiceEntity> iPage = sysServiceService.page(page, queryWrapper);
        return DataResult.success(iPage);
    }

}

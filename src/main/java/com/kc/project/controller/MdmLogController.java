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

import com.kc.project.entity.MdmLog;
import com.kc.project.service.MdmLogService;



/**
 * 
 *
 * @author mxy
 * @email ${email}
 * @date 2020-10-19 09:13:40
 */
@Controller
@RequestMapping("/")
public class MdmLogController {
    @Autowired
    private MdmLogService mdmLogService;


    /**
    * 跳转到页面
    */
    @GetMapping("/index/mdmLog")
    public String mdmLog() {
        return "mdmlog/list";
        }

    @ApiOperation(value = "新增")
    @PostMapping("mdmLog/add")
    @RequiresPermissions("mdmLog:add")
    @ResponseBody
    public DataResult add(@RequestBody MdmLog mdmLog){
        mdmLogService.save(mdmLog);
        return DataResult.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("mdmLog/delete")
    @RequiresPermissions("mdmLog:delete")
    @ResponseBody
    public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids){
        mdmLogService.removeByIds(ids);
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("mdmLog/update")
    @RequiresPermissions("mdmLog:update")
    @ResponseBody
    public DataResult update(@RequestBody MdmLog mdmLog){
        mdmLogService.updateById(mdmLog);
        return DataResult.success();
    }

    @ApiOperation(value = "查询分页数据")
    @PostMapping("mdmLog/listByPage")
    @RequiresPermissions("mdmLog:list")
    @ResponseBody
    public DataResult findListByPage(@RequestBody MdmLog mdmLog){
        Page page = new Page(mdmLog.getPage(), mdmLog.getLimit());
        LambdaQueryWrapper<MdmLog> queryWrapper = Wrappers.lambdaQuery();
        //查询条件示例
        //queryWrapper.eq(MdmLogEntity::getId, mdmLog.getId());
        IPage<MdmLog> iPage = mdmLogService.page(page, queryWrapper);
        return DataResult.success(iPage);
    }

}

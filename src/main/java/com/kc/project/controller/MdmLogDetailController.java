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

import com.kc.project.entity.MdmLogDetail;
import com.kc.project.service.MdmLogDetailService;



/**
 * 日志详情
 *
 * @author mxy
 * @email ${email}
 * @date 2020-10-19 09:28:13
 */
@Controller
@RequestMapping("/")
public class MdmLogDetailController {
    @Autowired
    private MdmLogDetailService mdmLogDetailService;


    /**
    * 跳转到页面
    */
    @GetMapping("/index/mdmLogDetail")
    public String mdmLogDetail() {
        return "mdmlogdetail/list";
        }

    @ApiOperation(value = "新增")
    @PostMapping("mdmLogDetail/add")
    @RequiresPermissions("mdmLogDetail:add")
    @ResponseBody
    public DataResult add(@RequestBody MdmLogDetail mdmLogDetail){
        mdmLogDetailService.save(mdmLogDetail);
        return DataResult.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("mdmLogDetail/delete")
    @RequiresPermissions("mdmLogDetail:delete")
    @ResponseBody
    public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids){
        mdmLogDetailService.removeByIds(ids);
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("mdmLogDetail/update")
    @RequiresPermissions("mdmLogDetail:update")
    @ResponseBody
    public DataResult update(@RequestBody MdmLogDetail mdmLogDetail){
        mdmLogDetailService.updateById(mdmLogDetail);
        return DataResult.success();
    }

    @ApiOperation(value = "查询分页数据")
    @PostMapping("mdmLogDetail/listByPage")
    @RequiresPermissions("mdmLogDetail:list")
    @ResponseBody
    public DataResult findListByPage(@RequestBody MdmLogDetail mdmLogDetail){
        Page page = new Page(mdmLogDetail.getPage(), mdmLogDetail.getLimit());
        LambdaQueryWrapper<MdmLogDetail> queryWrapper = Wrappers.lambdaQuery();
        //查询条件示例
        //queryWrapper.eq(MdmLogDetailEntity::getId, mdmLogDetail.getId());
        IPage<MdmLogDetail> iPage = mdmLogDetailService.page(page, queryWrapper);
        return DataResult.success(iPage);
    }

}

package com.kc.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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

import com.kc.project.entity.UserService;
import com.kc.project.service.UserServiceService;



/**
 * 服务用户
 *
 * @author mxy
 * @email ${email}
 * @date 2020-10-19 10:14:32
 */
@Controller
@RequestMapping("/")
public class UserServiceController {
    @Autowired
    private UserServiceService userServiceService;


    /**
    * 跳转到页面
    */
    @GetMapping("/index/userService")
    public String userService() {
        return "userservice/list";
        }

    @ApiOperation(value = "新增")
    @PostMapping("userService/add")
    @RequiresPermissions("userService:add")
    @ResponseBody
    public DataResult add(@RequestBody UserService userService){
        userServiceService.save(userService);
        return DataResult.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("userService/delete")
    @RequiresPermissions("userService:delete")
    @ResponseBody
    public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids){
        userServiceService.removeByIds(ids);
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("userService/update")
    @RequiresPermissions("userService:update")
    @ResponseBody
    public DataResult update(@RequestBody UserService userService){
        userServiceService.updateById(userService);
        return DataResult.success();
    }

    @ApiOperation(value = "查询分页数据")
    @PostMapping("userService/listByPage")
    @RequiresPermissions("userService:list")
    @ResponseBody
    public DataResult findListByPage(@RequestBody UserService userService){
        Page page = new Page(userService.getPage(), userService.getLimit());
        LambdaQueryWrapper<UserService> queryWrapper = Wrappers.lambdaQuery();
        //查询条件示例
        //queryWrapper.eq(UserServiceEntity::getId, userService.getId());
        IPage<UserService> iPage = userServiceService.page(page, queryWrapper);
        return DataResult.success(iPage);
    }

}

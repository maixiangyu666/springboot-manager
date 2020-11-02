package com.kc.project.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.kc.project.vo.req.PageReqVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户
 * @date 2020年3月18日
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUser extends PageReqVO implements Serializable {
    @TableId
    private String id;

    @NotBlank(message = "账号不能为空")
    private String username;

    private String salt;

    @NotBlank(message = "密码不能为空")
    private String password;

    private String phone;

    @NotBlank(message = "所属机构不能为空")
    private String deptId;

    @TableField(exist = false)
    private String deptName;

    private String code;

    @TableField(exist = false)
    private String deptNo;

    private String ipCode;

    private String realName;

    private String nickName;

    private String email;

    private Integer status;

    private Integer sex;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;

    private String createId;

    private String updateId;

    private Integer createWhere;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(exist = false)
    private String startTime;

    @TableField(exist = false)
    private String endTime;

    @TableField(exist = false)
    private List<String> roleIds;


    public SysUser(String code,@NotBlank(message = "账号不能为空") String username,  @NotBlank(message = "密码不能为空") String password) {
        this.code=code;
        this.username = username;
        this.password = password;
    }


    public SysUser() {
    }
}
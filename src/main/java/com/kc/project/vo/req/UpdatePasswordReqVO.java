package com.kc.project.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * UpdatePasswordReqVO
 *
 */
@Data
public class UpdatePasswordReqVO {
    @ApiModelProperty(value = "旧密码")
    private String oldPwd;
    @ApiModelProperty(value = "新密码")
    private String newPwd;
}

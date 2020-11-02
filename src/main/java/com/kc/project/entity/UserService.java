package com.kc.project.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.kc.project.vo.req.PageReqVO;


import java.io.Serializable;

import lombok.Data;

/**
 * 服务用户
 *
 * @author mxy
 * @email ${email}
 * @date 2020-10-19 10:14:32
 */
@Data
@TableName("user_service")
public class UserService extends PageReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId("id")
	private String id;

	/**
	 * 创建时间
	 */
	@TableField("createtime")
	private String createtime;

	/**
	 * 最后更新时间
	 */
	@TableField("lastupdatetime")
	private String lastupdatetime;

	/**
	 * 用户id
	 */
	@TableField("userid")
	private String userid;

	/**
	 * 服务id
	 */
	@TableField("serviceid")
	private String serviceid;

	/**
	 * 状态
	 */
	@TableField("state")
	private String state;


}

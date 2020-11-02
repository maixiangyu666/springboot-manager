package com.kc.project.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.kc.project.vo.req.PageReqVO;


import java.io.Serializable;

import lombok.Data;

/**
 * 平台及其URL
 *
 * @author mxy
 * @email ${email}
 * @date 2020-10-17 17:50:09
 */
@Data
@TableName("platform")
public class PlatformEntity extends PageReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId("id")
	private String id;

	/**
	 * 资源id
	 */
	@TableField("resource_id")
	private String resourceId;

	/**
	 * 平台类型
	 */
	@TableField("plattype")
	private String plattype;

	/**
	 * 平台类型名
	 */
	@TableField("plattypename")
	private String plattypename;

	/**
	 * 平台链接
	 */
	@TableField("platurl")
	private String platurl;

	/**
	 * 是否有效
	 */
	@TableField("dr")
	private Integer dr;

/*	*//**
	 * 点赞次数
	 *//*
	@TableField("good")
	private Integer good;

	*//**
	 * 点踩次数
	 *//*
	@TableField("bad")
	private Integer bad;*/

	/**
	 * 创建时间
	 */
	@TableField("createtime")
	private String createtime;

	/**
	 * 上次修改时间
	 */
	@TableField("lastupdatetime")
	private String lastupdatetime;


}

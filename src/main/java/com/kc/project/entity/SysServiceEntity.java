package com.kc.project.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.kc.project.vo.req.PageReqVO;


import java.io.Serializable;

import lombok.Data;

/**
 * 服务管理
 *
 * @date 2020-07-21 15:04:56
 */
@Data
@TableName("sys_service")
public class SysServiceEntity extends PageReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId("id")
	private String id;

	/**
	 * 
	 */
	@TableField("createtime")
	private String createtime;

	/**
	 * 
	 */
	@TableField("lastupdatetime")
	private String lastupdatetime;

	/**
	 * 
	 */
	@TableField("service_code")
	private String serviceCode;

	/**
	 * 
	 */
	@TableField("service_name")
	private String serviceName;

	/**
	 * 
	 */
	@TableField("class_qualified_name")
	private String classQualifiedName;

	/**
	 * 
	 */
	@TableField("state")
	private String state;

	/**
	 * 
	 */
	@TableField("category")
	private String category;

	/**
	 * 
	 */
	@TableField("project")
	private String project;


}

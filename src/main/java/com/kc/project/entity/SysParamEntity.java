package com.kc.project.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.kc.project.vo.req.PageReqVO;


import java.io.Serializable;

import lombok.Data;

/**
 * 服务参数
 *
 * @author mxy
 * @email ${email}
 * @date 2020-10-02 16:11:13
 */
@Data
@TableName("sys_param")
public class SysParamEntity extends PageReqVO implements Serializable {
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
	 * 最后修改时间
	 */
	@TableField("lastupdatetime")
	private String lastupdatetime;

	/**
	 * 参数名
	 */
	@TableField("param_name")
	private String paramName;

	/**
	 * 服务ID
	 */
	@TableField("service_id")
	private String serviceId;

	/**
	 * 是否必填
	 */
	@TableField("required")
	private String required;

	/**
	 * 默认值
	 */
	@TableField("default_value")
	private String defaultValue;

	/**
	 * 参数类型
	 */
	@TableField("paramtype")
	private String paramtype;

	/**
	 * 参数表达式
	 */
	@TableField("regex")
	private String regex;

	/**
	 * 校验表达式
	 */
	@TableField("paramdesc")
	private String paramdesc;

	/**
	 * 校验提示
	 */
	@TableField("tips")
	private String tips;

	/**
	 * 描述
	 */
	@TableField("memo")
	private String memo;

	/**
	 * 备注
	 */
	@TableField("expression")
	private String expression;

	/**
	 * 序号
	 */
	@TableField("sort")
	private Integer sort;


}

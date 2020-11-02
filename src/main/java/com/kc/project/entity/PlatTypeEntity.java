package com.kc.project.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.kc.project.vo.req.PageReqVO;


import java.io.Serializable;

import lombok.Data;

/**
 * 平台维护
 *
 * @author mxy
 * @email ${email}
 * @date 2020-10-17 18:38:26
 */
@Data
@TableName("plat_type")
public class PlatTypeEntity extends PageReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId("id")
	private String id;

	/**
	 * 平台类型名
	 */
	@TableField("plat_type_name")
	private String platTypeName;

	/**
	 * 启用状态
	 */
	@TableField("dr")
	private String dr;


}

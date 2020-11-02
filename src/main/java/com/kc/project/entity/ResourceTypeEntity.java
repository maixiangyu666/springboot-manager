package com.kc.project.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.kc.project.vo.req.PageReqVO;


import java.io.Serializable;

import lombok.Data;

/**
 * 资源类型
 *
 * @author mxy
 * @email ${email}
 * @date 2020-10-16 16:42:33
 */
@Data
@TableName("resource_type")
public class ResourceTypeEntity extends PageReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId("type_id")
	private String typeId;

	/**
	 * 资源类型
	 */
	@TableField("resource_type")
	private String resourceType;

	/**
	 * 资源类型名
	 */
	@TableField("resource_type_name")
	private String resourceTypeName;

	/**
	 * 图片
	 */
	@TableField("image_url")
	private String imageUrl;

	/**
	 * 是否启用
	 */
	@TableField("dr")
	private Integer dr;

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

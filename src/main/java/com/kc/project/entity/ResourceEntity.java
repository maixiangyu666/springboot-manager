package com.kc.project.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.kc.project.vo.req.PageReqVO;


import java.io.Serializable;
import java.util.List;

import lombok.Data;
import org.springframework.data.annotation.Transient;

/**
 * 资源
 *
 * @author mxy
 * @email ${email}
 * @date 2020-10-17 16:17:41
 */
@Data
@TableName("resource")
public class ResourceEntity extends PageReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId("id")
	private String id;

	/**
	 * 资源名
	 */
	@TableField("name")
	private String name;


	/**
	 * 资源描述
	 */
	@TableField("description")
	private String description;

	/**
	 * 资源类型id
	 */
	@TableField("type_id")
	private String typeId;



	/**
	 * 资源类型id
	 */
	@TableField("type_name")
	private String typeName;


	/**
	 * 好评
	 */
	private Integer good;

	/**
	 * 差评
	 */
	private Integer bad;

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

    @TableField(exist = false)
	private String platTypes;


	@TableField(exist = false)
    private List<PlatformEntity> platformEntitys;


}

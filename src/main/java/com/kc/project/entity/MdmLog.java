package com.kc.project.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.kc.project.vo.req.PageReqVO;


import java.io.Serializable;

import lombok.Data;

/**
 * 
 *
 * @author mxy
 * @email ${email}
 * @date 2020-10-19 09:13:40
 */
@Data
@TableName("mdm_log")
public class MdmLog extends PageReqVO implements Serializable {
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
	@TableField("serviceid")
	private String serviceid;

	/**
	 * 
	 */
	@TableField("userid")
	private String userid;

	/**
	 * 
	 */
	@TableField("stime")
	private String stime;

	/**
	 * 
	 */
	@TableField("etime")
	private String etime;

	/**
	 * 
	 */
	@TableField("request")
	private String request;

	/**
	 * 
	 */
	@TableField("response")
	private String response;

	/**
	 * 
	 */
	@TableField("state")
	private String state;


}

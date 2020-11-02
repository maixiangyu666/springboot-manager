package com.kc.project.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.kc.project.vo.req.PageReqVO;


import java.io.Serializable;

import lombok.Data;

/**
 * 日志详情
 *
 * @author mxy
 * @email ${email}
 * @date 2020-10-19 09:28:13
 */
@Data
@TableName("mdm_log_detail")
public class MdmLogDetail extends PageReqVO implements Serializable {
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
	 * 上次更新时间
	 */
	@TableField("lastupdatetime")
	private String lastupdatetime;

	/**
	 * 父日志
	 */
	@TableField("pid")
	private String pid;

	/**
	 * 请求
	 */
	@TableField("request")
	private String request;

	/**
	 * 响应
	 */
	@TableField("response")
	private String response;

	/**
	 * 开始时间
	 */
	@TableField("stime")
	private String stime;

	/**
	 * 结束时间
	 */
	@TableField("etime")
	private String etime;

	/**
	 * 状态
	 */
	@TableField("state")
	private String state;

	/**
	 * 服务ID
	 */
	@TableField("serviceid")
	private String serviceid;


}

package com.kc.base.bean;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"sysid","state","code","msg"})
public class Response {
	//用户token
	private String sysid;
	//状态 0成功 -1失败
	private Integer state=0;
	//编码 0成功 其他为错误编码
	private String code="0";
	//提示信息
	private String msg="成功";
	
	
	public Response() {
		super();
	}
	/**
	 * 成功默认构造函数
	 * @param token
	 */
	public Response(String sysid) {
		super();
		this.sysid = sysid;
	}
	/**
	 * 默认成功构造函数
	 * @param token
	 * @param msg 成功提示
	 */
	public Response(String sysid, String msg) {
		super();
		this.sysid = sysid;
		this.msg = msg;
	}
	/**
	 * 默认失败构造函数
	 * @param token
	 * @param code 错误编码
	 * @param msg  错误提示
	 */
	public Response(String sysid, String code, String msg) {
		super();
		this.state=-1;
		this.sysid = sysid;
		this.code = code;
		this.msg = msg;
	}
	public Response(String sysid, Integer state, String code, String msg) {
		super();
		this.sysid = sysid;
		this.state = state;
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "Response [sysid=" + sysid + ", state=" + state + ", code="
				+ code + ", msg=" + msg + "]";
	}
	public String getSysid() {
		return sysid;
	}
	public void setSysid(String sysid) {
		this.sysid = sysid;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

	
}

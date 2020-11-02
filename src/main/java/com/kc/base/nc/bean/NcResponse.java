package com.kc.base.nc.bean;

/**
 * XML 返回解析对象
 * @author fyt
 *
 */
public class NcResponse {
	//返回编码
	private String code;
	//返回信息
	private String msg;
	//编码
	private String content;
	//pk
	private String bdocid;
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
		return "NcResponse [code=" + code + ", msg=" + msg + "]";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBdocid() {
		return bdocid;
	}
	public void setBdocid(String bdocid) {
		this.bdocid = bdocid;
	}
	
}

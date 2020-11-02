package com.kc.base.exception;

public class MdmException extends Exception{
	//异常对应的返回码 
	private String code="";
	//异常对应的描述信息  
	private String msg="";
	
	public MdmException() {
		super();
	}

	public MdmException(String message) {
		super(message);
		this.msg=message;
		this.code="000000";
	}

	public MdmException(Throwable cause) {
		super(cause);
	}

	public MdmException(String message, Throwable cause) {
		super(message, cause);
		this.msg=message;
		this.code="000000";
	}

	
	public MdmException(String code, String msg) {
		super();
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
}

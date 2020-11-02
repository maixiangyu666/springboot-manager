package com.kc.base.bean;

public class CommException {
	/*****************外部系统错误***********************/
	//参数值异常
	public final static String PARAM_VAL_CODE="P0001";
	public final static String  PARAM_VAL_MSG="参数值为空或者无效";
	//参数表达式异常
	public final static String PARAM_EXPRESSION_CODE="P0002";
	public final static String  PARAM_EXPRESSION_MSG="表达式不正确";
	
	//XML格式不正确
	public final static String PARAM_XML_CODE="P0003";
	public final static String  PARAM_XML_MSG="XML格式不正确";
	
	//XML解析失败
	public final static String PARAM_XML_PARSE_CODE="P0004";
	public final static String  PARAM_XML_PARSE_MSG="XML解析失败";
	
	
	//HTTP报文错误
	public final static String PARAM_HTTP_CONTENT_TYPE_CODE="P0005";
	public final static String  PARAM_HTTPCONTENT_TYPE_MSG="HTTP协议错误,请设置HTTP报文头中Content-Type为application/xml 或者application/json";
	
	//JSON解析失败
	public final static String PARAM_JSON_PARSE_CODE="P0006";
	public final static String  PARAM_JSON_PARSE_MSG="JSON解析失败";
	//JSON格式不正确
	public final static String PARAM_JSON_CODE="P0007";
	public final static String  PARAM_JSON_MSG="JSON格式不正确";
	//获取token失败
	public final static String PARAM_TOKEN_CODE="P0008";
	public final static String  PARAM_TOKEN_MSG="获取token失败";
	//获取token失败
		public final static String PARAM_NO_TOKEN_CODE="P0009";
		public final static String  PARAM_NO_TOKEN_MSG="token错误";
	/*****************中间平台系统错误***********************/
	//服务配置错误
	public final static String PARAM_MDM_CONF_CODE="MDM01";
	public final static String  PARAM_MDM_CONF_MSG="服务配置错误";
	//中间平台运行错误
	public final static String COMM_CODE="MDM02";
	public final static String  COMM_MSG="平台错误";
	//服务配置错误
	public final static String PARAM_MDM_CODE="MDM03";
	public final static String  PARAM_MDM_MSG="服务参数配置错误";
	/******************************NC错误******************************/
	//服务查询错误
	public final static String PARAM_NC_QUERY_CODE="NC001";
	public final static String  PARAM_NC_QUERY_MSG="ERP服务查询失败";
	//NC封装数据错误
	public final static String PARAM_NC_SET_CODE="NC002";
	public final static String  PARAM_NC_SET_MSG="ERP封装数据失败";
	//NC返回数据解析失败
	public final static String PARAM_NC_RESPONSE_CODE="NC003";
	public final static String  PARAM_NC_RESPONSE_MSG="ERP响应错误";
	//NC返回数据解析失败
	public final static String PARAM_NC_CODE="NC004";
	public final static String  PARAM_NC_MSG="ERP错误";
	//NC返回数据解析失败
	public final static String PARAM_SEND_NC_TIMEOUT_CODE="NC005";
	public final static String  PARAM_SEND_NC_TIMEOUT_MSG="ERP请求超时";
	
	/******************************用户认证服务错误******************************/
	//用户没有该服务的权限
	public final static String USER_NO_SERVICE_CODE="US001";
	public final static String  USER_NO_SERVICE_MSG="用户没有该服务的权限";
}

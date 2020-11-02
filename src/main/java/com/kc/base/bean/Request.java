package com.kc.base.bean;


import com.kc.base.nc.bean.NcRequest;
import com.kc.base.nc.vo.NcReturn;
import com.kc.project.entity.SysUser;

import java.util.List;
import java.util.Map;

public class Request {
	//报文公共
	private Map<String, String> query;
	//报文头
	private Map<String, String> head;
	//报文体
	private List<Map<String, String>> bodys;
	
	private List<Map<String, String>> headothers;
	//特殊情况，多层结构
	private List<Map<String, String>> others;
	//请求ip地址
	private String ip;
	//用户对象
	private SysUser mdmUser;
	//返回类型
	private String returnType ;
	//用户校验
	private String token;
	//主服务id
	private String serviceid;
	//主服务日志id
	private String logid;
	//当前执行子服务id；
	private String subid;
	//存储NC请求对象
	private NcRequest ncRequest;
	//存储上游单价返回值
	private List<NcReturn> nrvo;
	 

	public Map<String, String> getQuery() {
		return query;
	}
	public void setQuery(Map<String, String> query) {
		this.query = query;
	}
	public Map<String, String> getHead() {
		return head;
	}
	public void setHead(Map<String, String> head) {
		this.head = head;
	}
	
	public List<Map<String, String>> getBodys() {
		return bodys;
	}
	public void setBodys(List<Map<String, String>> bodys) {
		this.bodys = bodys;
	}
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getServiceid() {
		return serviceid;
	}
	public void setServiceid(String serviceid) {
		this.serviceid = serviceid;
	}
	public String getLogid() {
		return logid;
	}
	public void setLogid(String logid) {
		this.logid = logid;
	}
	public String getSubid() {
		return subid;
	}
	public void setSubid(String subid) {
		this.subid = subid;
	}
	public SysUser getMdmUser() {
		return mdmUser;
	}
	public void setMdmUser(SysUser mdmUser) {
		this.mdmUser = mdmUser;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public NcRequest getNcRequest() {
		return ncRequest;
	}
	public void setNcRequest(NcRequest ncRequest) {
		this.ncRequest = ncRequest;
	}
	public List<NcReturn> getNrvo() {
		return nrvo;
	}
	public void setNrvo(List<NcReturn> nrvo) {
		this.nrvo = nrvo;
	}
	public String getNrvoCode(String billtype){
		if(null!=nrvo){
			for (NcReturn nr : nrvo) {
				if(billtype.equals(nr.getBilltype())){
					return nr.getBillcode();
				}
			}
		}
		return null;
	}
	public List<Map<String, String>> getOthers() {
		return others;
	}
	public void setOthers(List<Map<String, String>> others) {
		this.others = others;
	}
	public List<Map<String, String>> getHeadothers() {
		return headothers;
	}
	public void setHeadothers(List<Map<String, String>> headothers) {
		this.headothers = headothers;
	}
}

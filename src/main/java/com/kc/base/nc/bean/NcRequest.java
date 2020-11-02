package com.kc.base.nc.bean;


import com.kc.base.utils.DictUtil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="ufinterface")
public class NcRequest {
	
	private String account;
	private String billtype;
	private String businessunitcode;
	private String filename;
	private String groupcode;
	private String isexchange;
	private String orgcode;
	private String receiver;
	private String replace;
	private String roottag;
	private String sender;
	private String hassyn;//是否已同步
	
	@XmlAttribute
	public String getAccount() {
		if(account==null){
			return DictUtil.getDictValue("SYS_DICT", "NC_REQUEST_ACCOUNT");
		}
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@XmlAttribute
	public String getBilltype() {
		if(billtype==null){
			return "";
		}
		return billtype;
	}
	public void setBilltype(String billtype) {
		this.billtype = billtype;
	}
	@XmlAttribute
	public String getBusinessunitcode() {
		if(businessunitcode==null){
			return "";
		}
		return businessunitcode;
	}
	public void setBusinessunitcode(String businessunitcode) {
		this.businessunitcode = businessunitcode;
	}
	@XmlAttribute
	public String getFilename() {
		if(filename==null){
			return "";
		}
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@XmlAttribute
	public String getGroupcode() {
		if(groupcode==null){
			return DictUtil.getDictValue("SYS_DICT", "NC_REQUEST_GROUP");
		}
		return groupcode;
	}
	public void setGroupcode(String groupcode) {
		this.groupcode = groupcode;
	}
	@XmlAttribute
	public String getIsexchange() {
		if(isexchange==null){
			return DictUtil.getDictValue("SYS_DICT", "NC_REQUEST_ISEXCHANGE");
		}
		return isexchange;
	}
	public void setIsexchange(String isexchange) {
		this.isexchange = isexchange;
	}
	@XmlAttribute
	public String getOrgcode() {
		if(orgcode==null){
			return "";
		}
		return orgcode;
	}
	
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	
	@XmlAttribute
	public String getReceiver() {
		if(receiver==null){
			return "";
		}
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	@XmlAttribute
	public String getReplace() {
		if(replace==null){
			return DictUtil.getDictValue("SYS_DICT", "NC_REQUEST_REPLACE");
		}
		return replace;
	}
	public void setReplace(String replace) {
		this.replace = replace;
	}
	@XmlAttribute
	public String getRoottag() {
		if(roottag==null){
			return "";
		}
		return roottag;
	}
	public void setRoottag(String roottag) {
		this.roottag = roottag;
	}
	@XmlAttribute
	public String getSender() {
		if(sender==null){
			return DictUtil.getDictValue("SYS_DICT", "NC_REQUEST_SENDER");
		}
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getHassyn() {
		return hassyn;
	}
	public void setHassyn(String hassyn) {
		this.hassyn = hassyn;
	}
	
	
}

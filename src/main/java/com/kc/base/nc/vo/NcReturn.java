package com.kc.base.nc.vo;


import org.apache.commons.lang.StringUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="item")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder={"billtype","billid","billcode"})
public class NcReturn extends BaseVo{
	private String billid;
	private String billcode;
	private String billtype;
	
	public String getBilltype() {
		if(StringUtils.isBlank(billtype)){
			return "";
		}
		return billtype;
	}


	public void setBilltype(String billtype) {
		this.billtype = billtype;
	}


	public NcReturn() {
		super();
	}


	public NcReturn(String billid) {
		super();
		this.billid = billid;
	}


	public String getBillid() {
		return billid;
	}


	public void setBillid(String billid) {
		this.billid = billid;
	}


	public String getBillcode() {
		if(StringUtils.isBlank(billcode)){
			return "";
		}
		return billcode;
	}


	public void setBillcode(String billcode) {
		this.billcode = billcode;
	}


	public NcReturn(String billid, String billcode, String billtype) {
		super();
		this.billid = billid;
		this.billcode = billcode;
		this.billtype = billtype;
	}


	public NcReturn(String billid, String billtype) {
		super();
		this.billid = billid;
		this.billtype = billtype;
	}


	@Override
	public String toString() {
		return "NcReturn [billid=" + billid + ", billcode=" + billcode
				+ ", billtype=" + billtype + "]";
	}

	
}

package com.kc.base.nc.bean;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Bill {
	@XmlAttribute
	private String id="";
	@XmlElementRef
	private BillHead billhead;
	
	public Bill() {
		super();
	}
	
	public Bill(BillHead billhead) {
		super();
		this.billhead = billhead;
	}
	
	public Bill(String id, BillHead billhead) {
		super();
		this.id = id;
		this.billhead = billhead;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BillHead getBillhead() {
		return billhead;
	}
	public void setBillhead(BillHead billhead) {
		this.billhead = billhead;
	}
	
	
}

package com.kc.base.nc.bean;

import com.kc.base.utils.DictUtil;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="billhead")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso(value={})
public abstract class BillHead{
	//所属集团,最大长度为20,类型为:String
	private String pk_group;
	//所属组织,最大长度为20,类型为:String
	private String pk_org;
	//采购库存组织
	private String pk_org_v;
	//单据日期
	private String dbilldate;
	//部门最新版本
	private String cdptid;
	//部门
	private String cdptvid;
	
	//用户存储单据类型
	private String billtype;
	
	
	public List<Body> body;
	
	public List<Body> getBody() {
		return body;
	}

	public void setBody(List<? extends Body> body) {
		this.body = (List<Body>) body;
	}
	@XmlElement
	public String getPk_group() {
		if(pk_group==null){
			return DictUtil.getDictValue("SYS_DICT", "NC_REQUEST_GROUP");
		}
		return pk_group;
	}

	public void setPk_group(String pk_group) {
		this.pk_group = pk_group;
	}
	@XmlElement
	public String getPk_org() {
		return pk_org;
	}

	public void setPk_org(String pk_org) {
		this.pk_org = pk_org;
	}

	public String getBilltype() {
		return billtype;
	}

	public void setBilltype(String billtype) {
		this.billtype = billtype;
	}
	@XmlElement
	public String getPk_org_v() {
		return pk_org_v;
	}

	public void setPk_org_v(String pk_org_v) {
		this.pk_org_v = pk_org_v;
	}
	@XmlElement
	public String getDbilldate() {
		return dbilldate;
	}

	public void setDbilldate(String dbilldate) {
		this.dbilldate = dbilldate;
	}
	@XmlElement
	public String getCdptid() {
		return cdptid;
	}

	public void setCdptid(String cdptid) {
		this.cdptid = cdptid;
	}
	@XmlElement
	public String getCdptvid() {
		return cdptvid;
	}

	public void setCdptvid(String cdptvid) {
		this.cdptvid = cdptvid;
	}

}

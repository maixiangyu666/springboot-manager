package com.kc.base.nc.bean;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso(value={})
@XmlRootElement(name="item")
public class Body {
	private String crowno;//行号
	private String pk_group;//集团
	private String pk_org;//组织
	private String cmaterialoid;//物料编码
	private String cmaterialvid;//物料编码(版本)
	private String cunitid;//主单位
	private String castunitid;//单位
	private String vchangerate;//换算率
	private String nnum;//主数量
	private String nastnum;//数量
	private String vfree2;//育肥猪批次号
	@XmlElement
	public String getCrowno() {
		return crowno;
	}
	public void setCrowno(String crowno) {
		this.crowno = crowno;
	}
	@XmlElement
	public String getPk_group() {
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
	@XmlElement
	public String getCunitid() {
		return cunitid;
	}
	public void setCunitid(String cunitid) {
		this.cunitid = cunitid;
	}
	@XmlElement
	public String getCastunitid() {
		return castunitid;
	}
	public void setCastunitid(String castunitid) {
		this.castunitid = castunitid;
	}
	@XmlElement
	public String getVchangerate() {
		return vchangerate;
	}
	public void setVchangerate(String vchangerate) {
		this.vchangerate = vchangerate;
	}
	@XmlElement
	public String getNnum() {
		return nnum;
	}
	public void setNnum(String nnum) {
		this.nnum = nnum;
	}
	@XmlElement
	public String getNastnum() {
		return nastnum;
	}
	public void setNastnum(String nastnum) {
		this.nastnum = nastnum;
	}
	@XmlElement
	public String getCmaterialoid() {
		return cmaterialoid;
	}
	public void setCmaterialoid(String cmaterialoid) {
		this.cmaterialoid = cmaterialoid;
	}
	@XmlElement
	public String getCmaterialvid() {
		return cmaterialvid;
	}
	public void setCmaterialvid(String cmaterialvid) {
		this.cmaterialvid = cmaterialvid;
	}
	@XmlElement
	public String getVfree2() {
		return vfree2;
	}
	public void setVfree2(String vfree2) {
		this.vfree2 = vfree2;
	}
	
}

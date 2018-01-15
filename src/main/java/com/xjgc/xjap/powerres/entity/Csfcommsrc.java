package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Csfcommsrc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "csfcommsrc", catalog = "e8000")

public class Csfcommsrc implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer rtuguid;
	private String bchno;
	private Integer daddr;
	private Integer btype;
	private Integer rladdr;
	private Integer rcaddr;
	private Integer btcr;
	private Integer brot;
	private Integer baddr;
	private Integer dyxnum;
	private Integer dycnum;
	private Integer dddnum;
	private Integer yccoef;
	private Integer dhtype;
	private String wcmid;
	private Integer encrypt;
	private Integer rtuflag;

	// Constructors

	/** default constructor */
	public Csfcommsrc() {
	}

	/** minimal constructor */
	public Csfcommsrc(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Csfcommsrc(Integer id, String name, Integer rtuguid, String bchno, Integer daddr, Integer btype,
			Integer rladdr, Integer rcaddr, Integer btcr, Integer brot, Integer baddr, Integer dyxnum, Integer dycnum,
			Integer dddnum, Integer yccoef, Integer dhtype, String wcmid, Integer encrypt, Integer rtuflag) {
		this.id = id;
		this.name = name;
		this.rtuguid = rtuguid;
		this.bchno = bchno;
		this.daddr = daddr;
		this.btype = btype;
		this.rladdr = rladdr;
		this.rcaddr = rcaddr;
		this.btcr = btcr;
		this.brot = brot;
		this.baddr = baddr;
		this.dyxnum = dyxnum;
		this.dycnum = dycnum;
		this.dddnum = dddnum;
		this.yccoef = yccoef;
		this.dhtype = dhtype;
		this.wcmid = wcmid;
		this.encrypt = encrypt;
		this.rtuflag = rtuflag;
	}

	// Property accessors
	@Id

	@Column(name = "ID", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 40)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "RTUGUID")

	public Integer getRtuguid() {
		return this.rtuguid;
	}

	public void setRtuguid(Integer rtuguid) {
		this.rtuguid = rtuguid;
	}

	@Column(name = "bchno", length = 50)

	public String getBchno() {
		return this.bchno;
	}

	public void setBchno(String bchno) {
		this.bchno = bchno;
	}

	@Column(name = "daddr")

	public Integer getDaddr() {
		return this.daddr;
	}

	public void setDaddr(Integer daddr) {
		this.daddr = daddr;
	}

	@Column(name = "btype")

	public Integer getBtype() {
		return this.btype;
	}

	public void setBtype(Integer btype) {
		this.btype = btype;
	}

	@Column(name = "rladdr")

	public Integer getRladdr() {
		return this.rladdr;
	}

	public void setRladdr(Integer rladdr) {
		this.rladdr = rladdr;
	}

	@Column(name = "rcaddr")

	public Integer getRcaddr() {
		return this.rcaddr;
	}

	public void setRcaddr(Integer rcaddr) {
		this.rcaddr = rcaddr;
	}

	@Column(name = "btcr")

	public Integer getBtcr() {
		return this.btcr;
	}

	public void setBtcr(Integer btcr) {
		this.btcr = btcr;
	}

	@Column(name = "brot")

	public Integer getBrot() {
		return this.brot;
	}

	public void setBrot(Integer brot) {
		this.brot = brot;
	}

	@Column(name = "baddr")

	public Integer getBaddr() {
		return this.baddr;
	}

	public void setBaddr(Integer baddr) {
		this.baddr = baddr;
	}

	@Column(name = "dyxnum")

	public Integer getDyxnum() {
		return this.dyxnum;
	}

	public void setDyxnum(Integer dyxnum) {
		this.dyxnum = dyxnum;
	}

	@Column(name = "dycnum")

	public Integer getDycnum() {
		return this.dycnum;
	}

	public void setDycnum(Integer dycnum) {
		this.dycnum = dycnum;
	}

	@Column(name = "dddnum")

	public Integer getDddnum() {
		return this.dddnum;
	}

	public void setDddnum(Integer dddnum) {
		this.dddnum = dddnum;
	}

	@Column(name = "yccoef")

	public Integer getYccoef() {
		return this.yccoef;
	}

	public void setYccoef(Integer yccoef) {
		this.yccoef = yccoef;
	}

	@Column(name = "DHTYPE")

	public Integer getDhtype() {
		return this.dhtype;
	}

	public void setDhtype(Integer dhtype) {
		this.dhtype = dhtype;
	}

	@Column(name = "WCMID", length = 40)

	public String getWcmid() {
		return this.wcmid;
	}

	public void setWcmid(String wcmid) {
		this.wcmid = wcmid;
	}

	@Column(name = "encrypt")

	public Integer getEncrypt() {
		return this.encrypt;
	}

	public void setEncrypt(Integer encrypt) {
		this.encrypt = encrypt;
	}

	@Column(name = "rtuflag")

	public Integer getRtuflag() {
		return this.rtuflag;
	}

	public void setRtuflag(Integer rtuflag) {
		this.rtuflag = rtuflag;
	}

}
package com.xjgc.xjap.powerres.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Aperiodstat entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "aperiodstat", catalog = "e8000")

public class Aperiodstat implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer analogid;
	private Integer periodtypeid;
	private Timestamp statictime;
	private Integer totaltime;
	private Integer qualifytime;
	private Integer llowertime;
	private Integer llowercount;
	private Integer lowertime;
	private Integer lowercount;
	private Integer uppertime;
	private Integer uppercount;
	private Integer uupertime;
	private Integer uupercount;
	private Integer deleteflag;
	private Integer saveflag;
	private Integer totalfieldtime;

	// Constructors

	/** default constructor */
	public Aperiodstat() {
	}

	/** minimal constructor */
	public Aperiodstat(Integer id, Integer analogid, Integer periodtypeid) {
		this.id = id;
		this.analogid = analogid;
		this.periodtypeid = periodtypeid;
	}

	/** full constructor */
	public Aperiodstat(Integer id, Integer analogid, Integer periodtypeid, Timestamp statictime, Integer totaltime,
			Integer qualifytime, Integer llowertime, Integer llowercount, Integer lowertime, Integer lowercount,
			Integer uppertime, Integer uppercount, Integer uupertime, Integer uupercount, Integer deleteflag,
			Integer saveflag, Integer totalfieldtime) {
		this.id = id;
		this.analogid = analogid;
		this.periodtypeid = periodtypeid;
		this.statictime = statictime;
		this.totaltime = totaltime;
		this.qualifytime = qualifytime;
		this.llowertime = llowertime;
		this.llowercount = llowercount;
		this.lowertime = lowertime;
		this.lowercount = lowercount;
		this.uppertime = uppertime;
		this.uppercount = uppercount;
		this.uupertime = uupertime;
		this.uupercount = uupercount;
		this.deleteflag = deleteflag;
		this.saveflag = saveflag;
		this.totalfieldtime = totalfieldtime;
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

	@Column(name = "ANALOGID", nullable = false)

	public Integer getAnalogid() {
		return this.analogid;
	}

	public void setAnalogid(Integer analogid) {
		this.analogid = analogid;
	}

	@Column(name = "PERIODTYPEID", nullable = false)

	public Integer getPeriodtypeid() {
		return this.periodtypeid;
	}

	public void setPeriodtypeid(Integer periodtypeid) {
		this.periodtypeid = periodtypeid;
	}

	@Column(name = "STATICTIME", length = 19)

	public Timestamp getStatictime() {
		return this.statictime;
	}

	public void setStatictime(Timestamp statictime) {
		this.statictime = statictime;
	}

	@Column(name = "TOTALTIME")

	public Integer getTotaltime() {
		return this.totaltime;
	}

	public void setTotaltime(Integer totaltime) {
		this.totaltime = totaltime;
	}

	@Column(name = "QUALIFYTIME")

	public Integer getQualifytime() {
		return this.qualifytime;
	}

	public void setQualifytime(Integer qualifytime) {
		this.qualifytime = qualifytime;
	}

	@Column(name = "LLOWERTIME")

	public Integer getLlowertime() {
		return this.llowertime;
	}

	public void setLlowertime(Integer llowertime) {
		this.llowertime = llowertime;
	}

	@Column(name = "LLOWERCOUNT")

	public Integer getLlowercount() {
		return this.llowercount;
	}

	public void setLlowercount(Integer llowercount) {
		this.llowercount = llowercount;
	}

	@Column(name = "LOWERTIME")

	public Integer getLowertime() {
		return this.lowertime;
	}

	public void setLowertime(Integer lowertime) {
		this.lowertime = lowertime;
	}

	@Column(name = "LOWERCOUNT")

	public Integer getLowercount() {
		return this.lowercount;
	}

	public void setLowercount(Integer lowercount) {
		this.lowercount = lowercount;
	}

	@Column(name = "UPPERTIME")

	public Integer getUppertime() {
		return this.uppertime;
	}

	public void setUppertime(Integer uppertime) {
		this.uppertime = uppertime;
	}

	@Column(name = "UPPERCOUNT")

	public Integer getUppercount() {
		return this.uppercount;
	}

	public void setUppercount(Integer uppercount) {
		this.uppercount = uppercount;
	}

	@Column(name = "UUPERTIME")

	public Integer getUupertime() {
		return this.uupertime;
	}

	public void setUupertime(Integer uupertime) {
		this.uupertime = uupertime;
	}

	@Column(name = "UUPERCOUNT")

	public Integer getUupercount() {
		return this.uupercount;
	}

	public void setUupercount(Integer uupercount) {
		this.uupercount = uupercount;
	}

	@Column(name = "DELETEFLAG")

	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

	@Column(name = "SAVEFLAG")

	public Integer getSaveflag() {
		return this.saveflag;
	}

	public void setSaveflag(Integer saveflag) {
		this.saveflag = saveflag;
	}

	@Column(name = "TOTALFIELDTIME")

	public Integer getTotalfieldtime() {
		return this.totalfieldtime;
	}

	public void setTotalfieldtime(Integer totalfieldtime) {
		this.totalfieldtime = totalfieldtime;
	}

}
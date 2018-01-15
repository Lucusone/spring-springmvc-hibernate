package com.xjgc.xjap.powerres.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Analogstat entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "analogstat", catalog = "e8000")

public class Analogstat implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer statsvtimerid;
	private Integer addtimes;
	private Double addvalue;
	private Double avevalue;
	private Double maxdata;
	private Timestamp maxdatatime;
	private Double mindata;
	private Timestamp mindatatime;
	private Integer uupercount;
	private Integer uupertime;
	private Integer uppercount;
	private Integer uppertime;
	private Integer lowercount;
	private Integer lowertime;
	private Integer llowercount;
	private Integer llowertime;
	private Integer qualifytime;
	private Timestamp statictime;
	private Integer totaltime;
	private Integer deleteflag;
	private Integer saveflag;
	private Integer totalfieldtime;

	// Constructors

	/** default constructor */
	public Analogstat() {
	}

	/** minimal constructor */
	public Analogstat(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Analogstat(Integer id, Integer statsvtimerid, Integer addtimes, Double addvalue, Double avevalue,
			Double maxdata, Timestamp maxdatatime, Double mindata, Timestamp mindatatime, Integer uupercount,
			Integer uupertime, Integer uppercount, Integer uppertime, Integer lowercount, Integer lowertime,
			Integer llowercount, Integer llowertime, Integer qualifytime, Timestamp statictime, Integer totaltime,
			Integer deleteflag, Integer saveflag, Integer totalfieldtime) {
		this.id = id;
		this.statsvtimerid = statsvtimerid;
		this.addtimes = addtimes;
		this.addvalue = addvalue;
		this.avevalue = avevalue;
		this.maxdata = maxdata;
		this.maxdatatime = maxdatatime;
		this.mindata = mindata;
		this.mindatatime = mindatatime;
		this.uupercount = uupercount;
		this.uupertime = uupertime;
		this.uppercount = uppercount;
		this.uppertime = uppertime;
		this.lowercount = lowercount;
		this.lowertime = lowertime;
		this.llowercount = llowercount;
		this.llowertime = llowertime;
		this.qualifytime = qualifytime;
		this.statictime = statictime;
		this.totaltime = totaltime;
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

	@Column(name = "STATSVTIMERID")

	public Integer getStatsvtimerid() {
		return this.statsvtimerid;
	}

	public void setStatsvtimerid(Integer statsvtimerid) {
		this.statsvtimerid = statsvtimerid;
	}

	@Column(name = "ADDTIMES")

	public Integer getAddtimes() {
		return this.addtimes;
	}

	public void setAddtimes(Integer addtimes) {
		this.addtimes = addtimes;
	}

	@Column(name = "ADDVALUE", precision = 22, scale = 0)

	public Double getAddvalue() {
		return this.addvalue;
	}

	public void setAddvalue(Double addvalue) {
		this.addvalue = addvalue;
	}

	@Column(name = "AVEVALUE", precision = 22, scale = 0)

	public Double getAvevalue() {
		return this.avevalue;
	}

	public void setAvevalue(Double avevalue) {
		this.avevalue = avevalue;
	}

	@Column(name = "MAXDATA", precision = 22, scale = 0)

	public Double getMaxdata() {
		return this.maxdata;
	}

	public void setMaxdata(Double maxdata) {
		this.maxdata = maxdata;
	}

	@Column(name = "MAXDATATIME", length = 19)

	public Timestamp getMaxdatatime() {
		return this.maxdatatime;
	}

	public void setMaxdatatime(Timestamp maxdatatime) {
		this.maxdatatime = maxdatatime;
	}

	@Column(name = "MINDATA", precision = 22, scale = 0)

	public Double getMindata() {
		return this.mindata;
	}

	public void setMindata(Double mindata) {
		this.mindata = mindata;
	}

	@Column(name = "MINDATATIME", length = 19)

	public Timestamp getMindatatime() {
		return this.mindatatime;
	}

	public void setMindatatime(Timestamp mindatatime) {
		this.mindatatime = mindatatime;
	}

	@Column(name = "UUPERCOUNT")

	public Integer getUupercount() {
		return this.uupercount;
	}

	public void setUupercount(Integer uupercount) {
		this.uupercount = uupercount;
	}

	@Column(name = "UUPERTIME")

	public Integer getUupertime() {
		return this.uupertime;
	}

	public void setUupertime(Integer uupertime) {
		this.uupertime = uupertime;
	}

	@Column(name = "UPPERCOUNT")

	public Integer getUppercount() {
		return this.uppercount;
	}

	public void setUppercount(Integer uppercount) {
		this.uppercount = uppercount;
	}

	@Column(name = "UPPERTIME")

	public Integer getUppertime() {
		return this.uppertime;
	}

	public void setUppertime(Integer uppertime) {
		this.uppertime = uppertime;
	}

	@Column(name = "LOWERCOUNT")

	public Integer getLowercount() {
		return this.lowercount;
	}

	public void setLowercount(Integer lowercount) {
		this.lowercount = lowercount;
	}

	@Column(name = "LOWERTIME")

	public Integer getLowertime() {
		return this.lowertime;
	}

	public void setLowertime(Integer lowertime) {
		this.lowertime = lowertime;
	}

	@Column(name = "LLOWERCOUNT")

	public Integer getLlowercount() {
		return this.llowercount;
	}

	public void setLlowercount(Integer llowercount) {
		this.llowercount = llowercount;
	}

	@Column(name = "LLOWERTIME")

	public Integer getLlowertime() {
		return this.llowertime;
	}

	public void setLlowertime(Integer llowertime) {
		this.llowertime = llowertime;
	}

	@Column(name = "QUALIFYTIME")

	public Integer getQualifytime() {
		return this.qualifytime;
	}

	public void setQualifytime(Integer qualifytime) {
		this.qualifytime = qualifytime;
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
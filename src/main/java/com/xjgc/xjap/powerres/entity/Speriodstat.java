package com.xjgc.xjap.powerres.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Speriodstat entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "speriodstat", catalog = "e8000")

public class Speriodstat implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer statusid;
	private Integer periodtypeid;
	private Integer closecount;
	private Integer opencount;
	private Integer closetime;
	private Integer opentime;
	private Integer totalruntime;
	private Integer staticstate;
	private Timestamp statictime;
	private Integer deleteflag;
	private Integer totaltime;
	private Integer saveflag;

	// Constructors

	/** default constructor */
	public Speriodstat() {
	}

	/** minimal constructor */
	public Speriodstat(Integer id, Integer statusid, Integer periodtypeid) {
		this.id = id;
		this.statusid = statusid;
		this.periodtypeid = periodtypeid;
	}

	/** full constructor */
	public Speriodstat(Integer id, Integer statusid, Integer periodtypeid, Integer closecount, Integer opencount,
			Integer closetime, Integer opentime, Integer totalruntime, Integer staticstate, Timestamp statictime,
			Integer deleteflag, Integer totaltime, Integer saveflag) {
		this.id = id;
		this.statusid = statusid;
		this.periodtypeid = periodtypeid;
		this.closecount = closecount;
		this.opencount = opencount;
		this.closetime = closetime;
		this.opentime = opentime;
		this.totalruntime = totalruntime;
		this.staticstate = staticstate;
		this.statictime = statictime;
		this.deleteflag = deleteflag;
		this.totaltime = totaltime;
		this.saveflag = saveflag;
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

	@Column(name = "STATUSID", nullable = false)

	public Integer getStatusid() {
		return this.statusid;
	}

	public void setStatusid(Integer statusid) {
		this.statusid = statusid;
	}

	@Column(name = "PERIODTYPEID", nullable = false)

	public Integer getPeriodtypeid() {
		return this.periodtypeid;
	}

	public void setPeriodtypeid(Integer periodtypeid) {
		this.periodtypeid = periodtypeid;
	}

	@Column(name = "CLOSECOUNT")

	public Integer getClosecount() {
		return this.closecount;
	}

	public void setClosecount(Integer closecount) {
		this.closecount = closecount;
	}

	@Column(name = "OPENCOUNT")

	public Integer getOpencount() {
		return this.opencount;
	}

	public void setOpencount(Integer opencount) {
		this.opencount = opencount;
	}

	@Column(name = "CLOSETIME")

	public Integer getClosetime() {
		return this.closetime;
	}

	public void setClosetime(Integer closetime) {
		this.closetime = closetime;
	}

	@Column(name = "OPENTIME")

	public Integer getOpentime() {
		return this.opentime;
	}

	public void setOpentime(Integer opentime) {
		this.opentime = opentime;
	}

	@Column(name = "TOTALRUNTIME")

	public Integer getTotalruntime() {
		return this.totalruntime;
	}

	public void setTotalruntime(Integer totalruntime) {
		this.totalruntime = totalruntime;
	}

	@Column(name = "STATICSTATE")

	public Integer getStaticstate() {
		return this.staticstate;
	}

	public void setStaticstate(Integer staticstate) {
		this.staticstate = staticstate;
	}

	@Column(name = "STATICTIME", length = 19)

	public Timestamp getStatictime() {
		return this.statictime;
	}

	public void setStatictime(Timestamp statictime) {
		this.statictime = statictime;
	}

	@Column(name = "DELETEFLAG")

	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

	@Column(name = "TOTALTIME")

	public Integer getTotaltime() {
		return this.totaltime;
	}

	public void setTotaltime(Integer totaltime) {
		this.totaltime = totaltime;
	}

	@Column(name = "SAVEFLAG")

	public Integer getSaveflag() {
		return this.saveflag;
	}

	public void setSaveflag(Integer saveflag) {
		this.saveflag = saveflag;
	}

}
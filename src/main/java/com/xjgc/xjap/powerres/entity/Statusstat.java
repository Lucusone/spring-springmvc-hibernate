package com.xjgc.xjap.powerres.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Statusstat entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "statusstat", catalog = "e8000")

public class Statusstat implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer statsvtimerid;
	private Integer closecount;
	private Integer opencount;
	private Integer closetime;
	private Integer opentime;
	private Integer totalruntime;
	private Timestamp statictime;
	private Integer deleteflag;
	private Integer totaltime;
	private Integer saveflag;

	// Constructors

	/** default constructor */
	public Statusstat() {
	}

	/** minimal constructor */
	public Statusstat(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Statusstat(Integer id, Integer statsvtimerid, Integer closecount, Integer opencount, Integer closetime,
			Integer opentime, Integer totalruntime, Timestamp statictime, Integer deleteflag, Integer totaltime,
			Integer saveflag) {
		this.id = id;
		this.statsvtimerid = statsvtimerid;
		this.closecount = closecount;
		this.opencount = opencount;
		this.closetime = closetime;
		this.opentime = opentime;
		this.totalruntime = totalruntime;
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

	@Column(name = "STATSVTIMERID")

	public Integer getStatsvtimerid() {
		return this.statsvtimerid;
	}

	public void setStatsvtimerid(Integer statsvtimerid) {
		this.statsvtimerid = statsvtimerid;
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
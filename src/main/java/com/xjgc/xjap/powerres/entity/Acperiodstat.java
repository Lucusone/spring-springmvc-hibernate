package com.xjgc.xjap.powerres.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Acperiodstat entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "acperiodstat", catalog = "e8000")

public class Acperiodstat implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer accumulatorid;
	private Integer periodtypeid;
	private Double amountvalue;
	private Timestamp statictime;
	private Integer deleteflag;
	private Integer saveflag;
	private Integer totalTime;

	// Constructors

	/** default constructor */
	public Acperiodstat() {
	}

	/** minimal constructor */
	public Acperiodstat(Integer id, Integer accumulatorid, Integer periodtypeid) {
		this.id = id;
		this.accumulatorid = accumulatorid;
		this.periodtypeid = periodtypeid;
	}

	/** full constructor */
	public Acperiodstat(Integer id, Integer accumulatorid, Integer periodtypeid, Double amountvalue,
			Timestamp statictime, Integer deleteflag, Integer saveflag, Integer totalTime) {
		this.id = id;
		this.accumulatorid = accumulatorid;
		this.periodtypeid = periodtypeid;
		this.amountvalue = amountvalue;
		this.statictime = statictime;
		this.deleteflag = deleteflag;
		this.saveflag = saveflag;
		this.totalTime = totalTime;
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

	@Column(name = "ACCUMULATORID", nullable = false)

	public Integer getAccumulatorid() {
		return this.accumulatorid;
	}

	public void setAccumulatorid(Integer accumulatorid) {
		this.accumulatorid = accumulatorid;
	}

	@Column(name = "PERIODTYPEID", nullable = false)

	public Integer getPeriodtypeid() {
		return this.periodtypeid;
	}

	public void setPeriodtypeid(Integer periodtypeid) {
		this.periodtypeid = periodtypeid;
	}

	@Column(name = "AMOUNTVALUE", precision = 22, scale = 0)

	public Double getAmountvalue() {
		return this.amountvalue;
	}

	public void setAmountvalue(Double amountvalue) {
		this.amountvalue = amountvalue;
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

	@Column(name = "SAVEFLAG")

	public Integer getSaveflag() {
		return this.saveflag;
	}

	public void setSaveflag(Integer saveflag) {
		this.saveflag = saveflag;
	}

	@Column(name = "TotalTime")

	public Integer getTotalTime() {
		return this.totalTime;
	}

	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}

}
package com.xjgc.xjap.powerres.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Period entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "period", catalog = "e8000")

public class Period implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer periodtypeid;
	private Timestamp starttime;
	private Timestamp endtime;

	// Constructors

	/** default constructor */
	public Period() {
	}

	/** minimal constructor */
	public Period(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Period(Integer id, Integer periodtypeid, Timestamp starttime, Timestamp endtime) {
		this.id = id;
		this.periodtypeid = periodtypeid;
		this.starttime = starttime;
		this.endtime = endtime;
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

	@Column(name = "PERIODTYPEID")

	public Integer getPeriodtypeid() {
		return this.periodtypeid;
	}

	public void setPeriodtypeid(Integer periodtypeid) {
		this.periodtypeid = periodtypeid;
	}

	@Column(name = "STARTTIME", length = 19)

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	@Column(name = "ENDTIME", length = 19)

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

}
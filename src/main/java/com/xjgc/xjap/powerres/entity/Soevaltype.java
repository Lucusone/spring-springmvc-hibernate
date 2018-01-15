package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Soevaltype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "soevaltype", catalog = "e8000")

public class Soevaltype implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer meastypeid;
	private String description;
	private String name;
	private Integer value;
	private Integer reportflag;
	private Integer alarmid;

	// Constructors

	/** default constructor */
	public Soevaltype() {
	}

	/** minimal constructor */
	public Soevaltype(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Soevaltype(Integer id, Integer meastypeid, String description, String name, Integer value,
			Integer reportflag, Integer alarmid) {
		this.id = id;
		this.meastypeid = meastypeid;
		this.description = description;
		this.name = name;
		this.value = value;
		this.reportflag = reportflag;
		this.alarmid = alarmid;
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

	@Column(name = "MEASTYPEID")

	public Integer getMeastypeid() {
		return this.meastypeid;
	}

	public void setMeastypeid(Integer meastypeid) {
		this.meastypeid = meastypeid;
	}

	@Column(name = "DESCRIPTION", length = 64)

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "NAME", length = 64)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "VALUE")

	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Column(name = "REPORTFLAG")

	public Integer getReportflag() {
		return this.reportflag;
	}

	public void setReportflag(Integer reportflag) {
		this.reportflag = reportflag;
	}

	@Column(name = "ALARMID")

	public Integer getAlarmid() {
		return this.alarmid;
	}

	public void setAlarmid(Integer alarmid) {
		this.alarmid = alarmid;
	}

}
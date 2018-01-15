package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Alarmemail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "alarmemail", catalog = "e8000")

public class Alarmemail implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer alarmid;
	private Integer msgemailid;

	// Constructors

	/** default constructor */
	public Alarmemail() {
	}

	/** full constructor */
	public Alarmemail(Integer id, Integer alarmid, Integer msgemailid) {
		this.id = id;
		this.alarmid = alarmid;
		this.msgemailid = msgemailid;
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

	@Column(name = "ALARMID", nullable = false)

	public Integer getAlarmid() {
		return this.alarmid;
	}

	public void setAlarmid(Integer alarmid) {
		this.alarmid = alarmid;
	}

	@Column(name = "MSGEMAILID", nullable = false)

	public Integer getMsgemailid() {
		return this.msgemailid;
	}

	public void setMsgemailid(Integer msgemailid) {
		this.msgemailid = msgemailid;
	}

}
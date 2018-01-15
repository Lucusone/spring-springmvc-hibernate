package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Alarmgroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "alarmgroup", catalog = "e8000")

public class Alarmgroup implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer alarmid;
	private Integer almgrptypeid;

	// Constructors

	/** default constructor */
	public Alarmgroup() {
	}

	/** minimal constructor */
	public Alarmgroup(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Alarmgroup(Integer id, Integer alarmid, Integer almgrptypeid) {
		this.id = id;
		this.alarmid = alarmid;
		this.almgrptypeid = almgrptypeid;
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

	@Column(name = "ALARMID")

	public Integer getAlarmid() {
		return this.alarmid;
	}

	public void setAlarmid(Integer alarmid) {
		this.alarmid = alarmid;
	}

	@Column(name = "ALMGRPTYPEID")

	public Integer getAlmgrptypeid() {
		return this.almgrptypeid;
	}

	public void setAlmgrptypeid(Integer almgrptypeid) {
		this.almgrptypeid = almgrptypeid;
	}

}
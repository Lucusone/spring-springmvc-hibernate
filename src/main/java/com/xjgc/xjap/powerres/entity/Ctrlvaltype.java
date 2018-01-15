package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ctrlvaltype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ctrlvaltype", catalog = "e8000")

public class Ctrlvaltype implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer alarmid;
	private Integer meastypeid;
	private String name;
	private Integer value;
	private Integer statusValue;

	// Constructors

	/** default constructor */
	public Ctrlvaltype() {
	}

	/** minimal constructor */
	public Ctrlvaltype(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Ctrlvaltype(Integer id, Integer alarmid, Integer meastypeid, String name, Integer value,
			Integer statusValue) {
		this.id = id;
		this.alarmid = alarmid;
		this.meastypeid = meastypeid;
		this.name = name;
		this.value = value;
		this.statusValue = statusValue;
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

	@Column(name = "MEASTYPEID")

	public Integer getMeastypeid() {
		return this.meastypeid;
	}

	public void setMeastypeid(Integer meastypeid) {
		this.meastypeid = meastypeid;
	}

	@Column(name = "NAME", length = 128)

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

	@Column(name = "StatusValue")

	public Integer getStatusValue() {
		return this.statusValue;
	}

	public void setStatusValue(Integer statusValue) {
		this.statusValue = statusValue;
	}

}
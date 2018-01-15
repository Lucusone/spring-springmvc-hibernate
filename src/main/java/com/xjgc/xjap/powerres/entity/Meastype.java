package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Meastype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "meastype", catalog = "e8000")

public class Meastype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private Integer measclassid;
	private Integer ctrlmtypeid;
	private Integer alarmId;
	private Integer faultAlarmId;

	// Constructors

	/** default constructor */
	public Meastype() {
	}

	/** minimal constructor */
	public Meastype(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Meastype(Integer id, String code, String name, Integer measclassid, Integer ctrlmtypeid, Integer alarmId,
			Integer faultAlarmId) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.measclassid = measclassid;
		this.ctrlmtypeid = ctrlmtypeid;
		this.alarmId = alarmId;
		this.faultAlarmId = faultAlarmId;
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

	@Column(name = "CODE", length = 16)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "NAME", length = 128)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "MEASCLASSID")

	public Integer getMeasclassid() {
		return this.measclassid;
	}

	public void setMeasclassid(Integer measclassid) {
		this.measclassid = measclassid;
	}

	@Column(name = "CTRLMTYPEID")

	public Integer getCtrlmtypeid() {
		return this.ctrlmtypeid;
	}

	public void setCtrlmtypeid(Integer ctrlmtypeid) {
		this.ctrlmtypeid = ctrlmtypeid;
	}

	@Column(name = "AlarmID")

	public Integer getAlarmId() {
		return this.alarmId;
	}

	public void setAlarmId(Integer alarmId) {
		this.alarmId = alarmId;
	}

	@Column(name = "FaultAlarmID")

	public Integer getFaultAlarmId() {
		return this.faultAlarmId;
	}

	public void setFaultAlarmId(Integer faultAlarmId) {
		this.faultAlarmId = faultAlarmId;
	}

}
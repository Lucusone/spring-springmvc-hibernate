package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bay entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bay", catalog = "e8000")

public class Bay implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private String description;
	private Integer parentBayId;
	private Integer bayTypeId;
	private Integer districtId;
	private Integer stationId;
	private Integer dsubstationId;
	private Integer baseVoltageId;
	private Integer tobayid;
	private Integer proflag;
	private Integer lockenable;
	private Integer runstatus;
	private Integer fault;
	private Integer alarm;
	private Integer gzstate;
	private Integer deleteflag;
	private Integer replacebayid;
	private String alarmpage;
	private String family;

	// Constructors

	/** default constructor */
	public Bay() {
	}

	/** minimal constructor */
	public Bay(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Bay(Integer id, String code, String name, String description, Integer parentBayId, Integer bayTypeId,
			Integer districtId, Integer stationId, Integer dsubstationId, Integer baseVoltageId, Integer tobayid,
			Integer proflag, Integer lockenable, Integer runstatus, Integer fault, Integer alarm, Integer gzstate,
			Integer deleteflag, Integer replacebayid, String alarmpage, String family) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.parentBayId = parentBayId;
		this.bayTypeId = bayTypeId;
		this.districtId = districtId;
		this.stationId = stationId;
		this.dsubstationId = dsubstationId;
		this.baseVoltageId = baseVoltageId;
		this.tobayid = tobayid;
		this.proflag = proflag;
		this.lockenable = lockenable;
		this.runstatus = runstatus;
		this.fault = fault;
		this.alarm = alarm;
		this.gzstate = gzstate;
		this.deleteflag = deleteflag;
		this.replacebayid = replacebayid;
		this.alarmpage = alarmpage;
		this.family = family;
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

	@Column(name = "NAME", length = 32)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Description", length = 64)

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "parentBayID")

	public Integer getParentBayId() {
		return this.parentBayId;
	}

	public void setParentBayId(Integer parentBayId) {
		this.parentBayId = parentBayId;
	}

	@Column(name = "BayTypeID")

	public Integer getBayTypeId() {
		return this.bayTypeId;
	}

	public void setBayTypeId(Integer bayTypeId) {
		this.bayTypeId = bayTypeId;
	}

	@Column(name = "DistrictId")

	public Integer getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	@Column(name = "StationID")

	public Integer getStationId() {
		return this.stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	@Column(name = "DSubstationID")

	public Integer getDsubstationId() {
		return this.dsubstationId;
	}

	public void setDsubstationId(Integer dsubstationId) {
		this.dsubstationId = dsubstationId;
	}

	@Column(name = "BaseVoltageID")

	public Integer getBaseVoltageId() {
		return this.baseVoltageId;
	}

	public void setBaseVoltageId(Integer baseVoltageId) {
		this.baseVoltageId = baseVoltageId;
	}

	@Column(name = "TOBAYID")

	public Integer getTobayid() {
		return this.tobayid;
	}

	public void setTobayid(Integer tobayid) {
		this.tobayid = tobayid;
	}

	@Column(name = "PROFLAG")

	public Integer getProflag() {
		return this.proflag;
	}

	public void setProflag(Integer proflag) {
		this.proflag = proflag;
	}

	@Column(name = "LOCKENABLE")

	public Integer getLockenable() {
		return this.lockenable;
	}

	public void setLockenable(Integer lockenable) {
		this.lockenable = lockenable;
	}

	@Column(name = "RUNSTATUS")

	public Integer getRunstatus() {
		return this.runstatus;
	}

	public void setRunstatus(Integer runstatus) {
		this.runstatus = runstatus;
	}

	@Column(name = "FAULT")

	public Integer getFault() {
		return this.fault;
	}

	public void setFault(Integer fault) {
		this.fault = fault;
	}

	@Column(name = "ALARM")

	public Integer getAlarm() {
		return this.alarm;
	}

	public void setAlarm(Integer alarm) {
		this.alarm = alarm;
	}

	@Column(name = "GZSTATE")

	public Integer getGzstate() {
		return this.gzstate;
	}

	public void setGzstate(Integer gzstate) {
		this.gzstate = gzstate;
	}

	@Column(name = "DELETEFLAG")

	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

	@Column(name = "REPLACEBAYID")

	public Integer getReplacebayid() {
		return this.replacebayid;
	}

	public void setReplacebayid(Integer replacebayid) {
		this.replacebayid = replacebayid;
	}

	@Column(name = "ALARMPAGE", length = 128)

	public String getAlarmpage() {
		return this.alarmpage;
	}

	public void setAlarmpage(String alarmpage) {
		this.alarmpage = alarmpage;
	}

	@Column(name = "FAMILY", length = 64)

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

}
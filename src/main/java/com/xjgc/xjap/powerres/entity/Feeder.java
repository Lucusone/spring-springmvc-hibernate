package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Feeder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "feeder", catalog = "e8000")

public class Feeder implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private String description;
	private String rdfid;
	private Integer districtId;
	private Integer stationId;
	private Integer busId;
	private Integer spare;
	private Integer maxCurrent;
	private String workdayMaxCurrent;
	private String workdayMinCurrent;
	private String holidayMaxCurrent;
	private String holidayMinCurrent;

	// Constructors

	/** default constructor */
	public Feeder() {
	}

	/** minimal constructor */
	public Feeder(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Feeder(Integer id, String code, String name, String description, String rdfid, Integer districtId,
			Integer stationId, Integer busId, Integer spare, Integer maxCurrent, String workdayMaxCurrent,
			String workdayMinCurrent, String holidayMaxCurrent, String holidayMinCurrent) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.rdfid = rdfid;
		this.districtId = districtId;
		this.stationId = stationId;
		this.busId = busId;
		this.spare = spare;
		this.maxCurrent = maxCurrent;
		this.workdayMaxCurrent = workdayMaxCurrent;
		this.workdayMinCurrent = workdayMinCurrent;
		this.holidayMaxCurrent = holidayMaxCurrent;
		this.holidayMinCurrent = holidayMinCurrent;
	}

	// Property accessors
	@Id

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "code", length = 16)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", length = 32)

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

	@Column(name = "rdfid", length = 64)

	public String getRdfid() {
		return this.rdfid;
	}

	public void setRdfid(String rdfid) {
		this.rdfid = rdfid;
	}

	@Column(name = "districtID")

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

	@Column(name = "BusID")

	public Integer getBusId() {
		return this.busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	@Column(name = "spare")

	public Integer getSpare() {
		return this.spare;
	}

	public void setSpare(Integer spare) {
		this.spare = spare;
	}

	@Column(name = "MaxCurrent")

	public Integer getMaxCurrent() {
		return this.maxCurrent;
	}

	public void setMaxCurrent(Integer maxCurrent) {
		this.maxCurrent = maxCurrent;
	}

	@Column(name = "WorkdayMaxCurrent", length = 1024)

	public String getWorkdayMaxCurrent() {
		return this.workdayMaxCurrent;
	}

	public void setWorkdayMaxCurrent(String workdayMaxCurrent) {
		this.workdayMaxCurrent = workdayMaxCurrent;
	}

	@Column(name = "WorkdayMinCurrent", length = 1024)

	public String getWorkdayMinCurrent() {
		return this.workdayMinCurrent;
	}

	public void setWorkdayMinCurrent(String workdayMinCurrent) {
		this.workdayMinCurrent = workdayMinCurrent;
	}

	@Column(name = "HolidayMaxCurrent", length = 1024)

	public String getHolidayMaxCurrent() {
		return this.holidayMaxCurrent;
	}

	public void setHolidayMaxCurrent(String holidayMaxCurrent) {
		this.holidayMaxCurrent = holidayMaxCurrent;
	}

	@Column(name = "HolidayMinCurrent", length = 1024)

	public String getHolidayMinCurrent() {
		return this.holidayMinCurrent;
	}

	public void setHolidayMinCurrent(String holidayMinCurrent) {
		this.holidayMinCurrent = holidayMinCurrent;
	}

}
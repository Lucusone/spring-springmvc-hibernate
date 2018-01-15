package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Powertransformer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "powertransformer", catalog = "e8000")

public class Powertransformer implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private String rdfid;
	private Integer equipTypeId;
	private Integer districtId;
	private Integer stationId;
	private Integer bayId;
	private Integer maxCurrent;
	private Integer capacity;
	private Integer topoStatus;
	private Integer runState;
	private Integer comStatus;
	private Integer tagStatus;

	// Constructors

	/** default constructor */
	public Powertransformer() {
	}

	/** minimal constructor */
	public Powertransformer(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Powertransformer(Integer id, String name, String description, String rdfid, Integer equipTypeId,
			Integer districtId, Integer stationId, Integer bayId, Integer maxCurrent, Integer capacity,
			Integer topoStatus, Integer runState, Integer comStatus, Integer tagStatus) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.rdfid = rdfid;
		this.equipTypeId = equipTypeId;
		this.districtId = districtId;
		this.stationId = stationId;
		this.bayId = bayId;
		this.maxCurrent = maxCurrent;
		this.capacity = capacity;
		this.topoStatus = topoStatus;
		this.runState = runState;
		this.comStatus = comStatus;
		this.tagStatus = tagStatus;
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

	@Column(name = "Rdfid", length = 64)

	public String getRdfid() {
		return this.rdfid;
	}

	public void setRdfid(String rdfid) {
		this.rdfid = rdfid;
	}

	@Column(name = "EquipTypeID")

	public Integer getEquipTypeId() {
		return this.equipTypeId;
	}

	public void setEquipTypeId(Integer equipTypeId) {
		this.equipTypeId = equipTypeId;
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

	@Column(name = "BayID")

	public Integer getBayId() {
		return this.bayId;
	}

	public void setBayId(Integer bayId) {
		this.bayId = bayId;
	}

	@Column(name = "MaxCurrent")

	public Integer getMaxCurrent() {
		return this.maxCurrent;
	}

	public void setMaxCurrent(Integer maxCurrent) {
		this.maxCurrent = maxCurrent;
	}

	@Column(name = "Capacity")

	public Integer getCapacity() {
		return this.capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Column(name = "topoStatus")

	public Integer getTopoStatus() {
		return this.topoStatus;
	}

	public void setTopoStatus(Integer topoStatus) {
		this.topoStatus = topoStatus;
	}

	@Column(name = "runState")

	public Integer getRunState() {
		return this.runState;
	}

	public void setRunState(Integer runState) {
		this.runState = runState;
	}

	@Column(name = "comStatus")

	public Integer getComStatus() {
		return this.comStatus;
	}

	public void setComStatus(Integer comStatus) {
		this.comStatus = comStatus;
	}

	@Column(name = "tagStatus")

	public Integer getTagStatus() {
		return this.tagStatus;
	}

	public void setTagStatus(Integer tagStatus) {
		this.tagStatus = tagStatus;
	}

}
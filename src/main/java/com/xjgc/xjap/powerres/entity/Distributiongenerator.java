package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Distributiongenerator entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "distributiongenerator", catalog = "e8000")

public class Distributiongenerator implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private String rdfid;
	private Double ratedMw;
	private Integer equipTypeId;
	private Integer baseVoltageId;
	private Integer districtId;
	private Integer stationId;
	private Integer bayId;
	private Integer feederId;
	private Integer dsubStationId;
	private Integer inode;
	private Integer status;
	private Integer topoStatus;
	private Integer comStatus;
	private Integer runState;
	private Integer tagStatus;

	// Constructors

	/** default constructor */
	public Distributiongenerator() {
	}

	/** minimal constructor */
	public Distributiongenerator(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Distributiongenerator(Integer id, String name, String description, String rdfid, Double ratedMw,
			Integer equipTypeId, Integer baseVoltageId, Integer districtId, Integer stationId, Integer bayId,
			Integer feederId, Integer dsubStationId, Integer inode, Integer status, Integer topoStatus,
			Integer comStatus, Integer runState, Integer tagStatus) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.rdfid = rdfid;
		this.ratedMw = ratedMw;
		this.equipTypeId = equipTypeId;
		this.baseVoltageId = baseVoltageId;
		this.districtId = districtId;
		this.stationId = stationId;
		this.bayId = bayId;
		this.feederId = feederId;
		this.dsubStationId = dsubStationId;
		this.inode = inode;
		this.status = status;
		this.topoStatus = topoStatus;
		this.comStatus = comStatus;
		this.runState = runState;
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

	@Column(name = "RatedMW", precision = 22, scale = 0)

	public Double getRatedMw() {
		return this.ratedMw;
	}

	public void setRatedMw(Double ratedMw) {
		this.ratedMw = ratedMw;
	}

	@Column(name = "EquipTypeID")

	public Integer getEquipTypeId() {
		return this.equipTypeId;
	}

	public void setEquipTypeId(Integer equipTypeId) {
		this.equipTypeId = equipTypeId;
	}

	@Column(name = "BaseVoltageID")

	public Integer getBaseVoltageId() {
		return this.baseVoltageId;
	}

	public void setBaseVoltageId(Integer baseVoltageId) {
		this.baseVoltageId = baseVoltageId;
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

	@Column(name = "FeederID")

	public Integer getFeederId() {
		return this.feederId;
	}

	public void setFeederId(Integer feederId) {
		this.feederId = feederId;
	}

	@Column(name = "DSubStationID")

	public Integer getDsubStationId() {
		return this.dsubStationId;
	}

	public void setDsubStationId(Integer dsubStationId) {
		this.dsubStationId = dsubStationId;
	}

	@Column(name = "inode")

	public Integer getInode() {
		return this.inode;
	}

	public void setInode(Integer inode) {
		this.inode = inode;
	}

	@Column(name = "status")

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "topoStatus")

	public Integer getTopoStatus() {
		return this.topoStatus;
	}

	public void setTopoStatus(Integer topoStatus) {
		this.topoStatus = topoStatus;
	}

	@Column(name = "comStatus")

	public Integer getComStatus() {
		return this.comStatus;
	}

	public void setComStatus(Integer comStatus) {
		this.comStatus = comStatus;
	}

	@Column(name = "runState")

	public Integer getRunState() {
		return this.runState;
	}

	public void setRunState(Integer runState) {
		this.runState = runState;
	}

	@Column(name = "tagStatus")

	public Integer getTagStatus() {
		return this.tagStatus;
	}

	public void setTagStatus(Integer tagStatus) {
		this.tagStatus = tagStatus;
	}

}
package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Compensator entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "compensator", catalog = "e8000")

public class Compensator implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private String rdfid;
	private Integer equiptypeid;
	private Integer baseVoltageId;
	private Integer districtId;
	private Integer stationId;
	private Integer bayId;
	private Integer feederId;
	private Integer dsubStationId;
	private Integer inode;
	private Double ratedKv;
	private Double ratedMva;
	private Integer topoStatus;
	private Integer runState;
	private Integer tagStatus;

	// Constructors

	/** default constructor */
	public Compensator() {
	}

	/** minimal constructor */
	public Compensator(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Compensator(Integer id, String name, String description, String rdfid, Integer equiptypeid,
			Integer baseVoltageId, Integer districtId, Integer stationId, Integer bayId, Integer feederId,
			Integer dsubStationId, Integer inode, Double ratedKv, Double ratedMva, Integer topoStatus, Integer runState,
			Integer tagStatus) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.rdfid = rdfid;
		this.equiptypeid = equiptypeid;
		this.baseVoltageId = baseVoltageId;
		this.districtId = districtId;
		this.stationId = stationId;
		this.bayId = bayId;
		this.feederId = feederId;
		this.dsubStationId = dsubStationId;
		this.inode = inode;
		this.ratedKv = ratedKv;
		this.ratedMva = ratedMva;
		this.topoStatus = topoStatus;
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

	@Column(name = "description", length = 64)

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

	@Column(name = "equiptypeid")

	public Integer getEquiptypeid() {
		return this.equiptypeid;
	}

	public void setEquiptypeid(Integer equiptypeid) {
		this.equiptypeid = equiptypeid;
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

	@Column(name = "RatedKV", precision = 22, scale = 0)

	public Double getRatedKv() {
		return this.ratedKv;
	}

	public void setRatedKv(Double ratedKv) {
		this.ratedKv = ratedKv;
	}

	@Column(name = "ratedMVA", precision = 22, scale = 0)

	public Double getRatedMva() {
		return this.ratedMva;
	}

	public void setRatedMva(Double ratedMva) {
		this.ratedMva = ratedMva;
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

	@Column(name = "tagStatus")

	public Integer getTagStatus() {
		return this.tagStatus;
	}

	public void setTagStatus(Integer tagStatus) {
		this.tagStatus = tagStatus;
	}

}
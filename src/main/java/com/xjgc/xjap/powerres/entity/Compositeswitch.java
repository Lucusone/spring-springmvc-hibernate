package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Compositeswitch entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "compositeswitch", catalog = "e8000")

public class Compositeswitch implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer baseVoltageId;
	private Integer districtId;
	private Integer stationId;
	private Integer bayId;
	private Integer feederId;
	private Integer dsubStationId;
	private String rdfid;
	private Integer equiptypeid;
	private Integer poleId;
	private Integer tagStatus;
	private Integer deleteFlag;

	// Constructors

	/** default constructor */
	public Compositeswitch() {
	}

	/** minimal constructor */
	public Compositeswitch(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Compositeswitch(Integer id, String name, Integer baseVoltageId, Integer districtId, Integer stationId,
			Integer bayId, Integer feederId, Integer dsubStationId, String rdfid, Integer equiptypeid, Integer poleId,
			Integer tagStatus, Integer deleteFlag) {
		this.id = id;
		this.name = name;
		this.baseVoltageId = baseVoltageId;
		this.districtId = districtId;
		this.stationId = stationId;
		this.bayId = bayId;
		this.feederId = feederId;
		this.dsubStationId = dsubStationId;
		this.rdfid = rdfid;
		this.equiptypeid = equiptypeid;
		this.poleId = poleId;
		this.tagStatus = tagStatus;
		this.deleteFlag = deleteFlag;
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

	@Column(name = "poleID")

	public Integer getPoleId() {
		return this.poleId;
	}

	public void setPoleId(Integer poleId) {
		this.poleId = poleId;
	}

	@Column(name = "tagStatus")

	public Integer getTagStatus() {
		return this.tagStatus;
	}

	public void setTagStatus(Integer tagStatus) {
		this.tagStatus = tagStatus;
	}

	@Column(name = "DeleteFlag")

	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
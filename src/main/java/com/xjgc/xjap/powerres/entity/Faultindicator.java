package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Faultindicator entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "faultindicator", catalog = "e8000")

public class Faultindicator implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private String description;
	private String rdfid;
	private Integer districtId;
	private Integer stationId;
	private Integer bayId;
	private Integer feederId;
	private Integer dsubStationId;
	private Integer inode;
	private Integer aclineSegmentId;
	private Integer scadaType;
	private Integer topoStatus;
	private Integer status;
	private Integer comStatus;

	// Constructors

	/** default constructor */
	public Faultindicator() {
	}

	/** minimal constructor */
	public Faultindicator(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Faultindicator(Integer id, String code, String name, String description, String rdfid, Integer districtId,
			Integer stationId, Integer bayId, Integer feederId, Integer dsubStationId, Integer inode,
			Integer aclineSegmentId, Integer scadaType, Integer topoStatus, Integer status, Integer comStatus) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.rdfid = rdfid;
		this.districtId = districtId;
		this.stationId = stationId;
		this.bayId = bayId;
		this.feederId = feederId;
		this.dsubStationId = dsubStationId;
		this.inode = inode;
		this.aclineSegmentId = aclineSegmentId;
		this.scadaType = scadaType;
		this.topoStatus = topoStatus;
		this.status = status;
		this.comStatus = comStatus;
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

	@Column(name = "Rdfid", length = 64)

	public String getRdfid() {
		return this.rdfid;
	}

	public void setRdfid(String rdfid) {
		this.rdfid = rdfid;
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

	@Column(name = "ACLineSegmentID")

	public Integer getAclineSegmentId() {
		return this.aclineSegmentId;
	}

	public void setAclineSegmentId(Integer aclineSegmentId) {
		this.aclineSegmentId = aclineSegmentId;
	}

	@Column(name = "scadaType")

	public Integer getScadaType() {
		return this.scadaType;
	}

	public void setScadaType(Integer scadaType) {
		this.scadaType = scadaType;
	}

	@Column(name = "topoStatus")

	public Integer getTopoStatus() {
		return this.topoStatus;
	}

	public void setTopoStatus(Integer topoStatus) {
		this.topoStatus = topoStatus;
	}

	@Column(name = "status")

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "comStatus")

	public Integer getComStatus() {
		return this.comStatus;
	}

	public void setComStatus(Integer comStatus) {
		this.comStatus = comStatus;
	}

}
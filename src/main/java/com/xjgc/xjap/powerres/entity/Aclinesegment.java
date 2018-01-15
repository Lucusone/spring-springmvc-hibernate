package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Aclinesegment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "aclinesegment", catalog = "e8000")

public class Aclinesegment implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer equipTypeId;
	private Integer lineSegmentTypeId;
	private Double length;
	private Integer baseVoltageId;
	private Integer districtId;
	private Integer stationId;
	private Integer bayId;
	private Integer feederId;
	private Integer dsubStationId;
	private Integer inode;
	private Integer jnode;
	private Integer topoStatus;
	private Integer tagStatus;

	// Constructors

	/** default constructor */
	public Aclinesegment() {
	}

	/** minimal constructor */
	public Aclinesegment(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Aclinesegment(Integer id, String name, Integer equipTypeId, Integer lineSegmentTypeId, Double length,
			Integer baseVoltageId, Integer districtId, Integer stationId, Integer bayId, Integer feederId,
			Integer dsubStationId, Integer inode, Integer jnode, Integer topoStatus, Integer tagStatus) {
		this.id = id;
		this.name = name;
		this.equipTypeId = equipTypeId;
		this.lineSegmentTypeId = lineSegmentTypeId;
		this.length = length;
		this.baseVoltageId = baseVoltageId;
		this.districtId = districtId;
		this.stationId = stationId;
		this.bayId = bayId;
		this.feederId = feederId;
		this.dsubStationId = dsubStationId;
		this.inode = inode;
		this.jnode = jnode;
		this.topoStatus = topoStatus;
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

	@Column(name = "EquipTypeID")

	public Integer getEquipTypeId() {
		return this.equipTypeId;
	}

	public void setEquipTypeId(Integer equipTypeId) {
		this.equipTypeId = equipTypeId;
	}

	@Column(name = "LineSegmentTypeID")

	public Integer getLineSegmentTypeId() {
		return this.lineSegmentTypeId;
	}

	public void setLineSegmentTypeId(Integer lineSegmentTypeId) {
		this.lineSegmentTypeId = lineSegmentTypeId;
	}

	@Column(name = "Length", precision = 22, scale = 0)

	public Double getLength() {
		return this.length;
	}

	public void setLength(Double length) {
		this.length = length;
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

	@Column(name = "jnode")

	public Integer getJnode() {
		return this.jnode;
	}

	public void setJnode(Integer jnode) {
		this.jnode = jnode;
	}

	@Column(name = "topoStatus")

	public Integer getTopoStatus() {
		return this.topoStatus;
	}

	public void setTopoStatus(Integer topoStatus) {
		this.topoStatus = topoStatus;
	}

	@Column(name = "tagStatus")

	public Integer getTagStatus() {
		return this.tagStatus;
	}

	public void setTagStatus(Integer tagStatus) {
		this.tagStatus = tagStatus;
	}

}
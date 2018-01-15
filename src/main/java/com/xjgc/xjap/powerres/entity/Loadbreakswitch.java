package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Loadbreakswitch entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "loadbreakswitch", catalog = "e8000")

public class Loadbreakswitch implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private String description;
	private String rdfid;
	private Integer baseVoltageId;
	private Integer districtId;
	private Integer stationId;
	private Integer bayId;
	private Integer feederId;
	private Integer dsubStationId;
	private Integer compositeSwitchId;
	private Integer equipTypeId;
	private Integer inode;
	private Integer jnode;
	private Integer poleId;
	private Integer normalOpen;
	private String family;
	private Integer scadaType;
	private Integer switchUseId;
	private Integer status;
	private Integer topoStatus;
	private Integer comStatus;
	private Integer runState;
	private Integer tagStatus;

	// Constructors

	/** default constructor */
	public Loadbreakswitch() {
	}

	/** minimal constructor */
	public Loadbreakswitch(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Loadbreakswitch(Integer id, String code, String name, String description, String rdfid,
			Integer baseVoltageId, Integer districtId, Integer stationId, Integer bayId, Integer feederId,
			Integer dsubStationId, Integer compositeSwitchId, Integer equipTypeId, Integer inode, Integer jnode,
			Integer poleId, Integer normalOpen, String family, Integer scadaType, Integer switchUseId, Integer status,
			Integer topoStatus, Integer comStatus, Integer runState, Integer tagStatus) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.rdfid = rdfid;
		this.baseVoltageId = baseVoltageId;
		this.districtId = districtId;
		this.stationId = stationId;
		this.bayId = bayId;
		this.feederId = feederId;
		this.dsubStationId = dsubStationId;
		this.compositeSwitchId = compositeSwitchId;
		this.equipTypeId = equipTypeId;
		this.inode = inode;
		this.jnode = jnode;
		this.poleId = poleId;
		this.normalOpen = normalOpen;
		this.family = family;
		this.scadaType = scadaType;
		this.switchUseId = switchUseId;
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

	@Column(name = "CompositeSwitchID")

	public Integer getCompositeSwitchId() {
		return this.compositeSwitchId;
	}

	public void setCompositeSwitchId(Integer compositeSwitchId) {
		this.compositeSwitchId = compositeSwitchId;
	}

	@Column(name = "EquipTypeID")

	public Integer getEquipTypeId() {
		return this.equipTypeId;
	}

	public void setEquipTypeId(Integer equipTypeId) {
		this.equipTypeId = equipTypeId;
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

	@Column(name = "poleID")

	public Integer getPoleId() {
		return this.poleId;
	}

	public void setPoleId(Integer poleId) {
		this.poleId = poleId;
	}

	@Column(name = "normalOpen")

	public Integer getNormalOpen() {
		return this.normalOpen;
	}

	public void setNormalOpen(Integer normalOpen) {
		this.normalOpen = normalOpen;
	}

	@Column(name = "Family", length = 16)

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Column(name = "scadaType")

	public Integer getScadaType() {
		return this.scadaType;
	}

	public void setScadaType(Integer scadaType) {
		this.scadaType = scadaType;
	}

	@Column(name = "switchUseID")

	public Integer getSwitchUseId() {
		return this.switchUseId;
	}

	public void setSwitchUseId(Integer switchUseId) {
		this.switchUseId = switchUseId;
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
package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Transformerwinding entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "transformerwinding", catalog = "e8000")

public class Transformerwinding implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private String rdfid;
	private Integer equiptypeId;
	private Integer baseVoltageId;
	private Integer districtId;
	private Integer stationId;
	private Integer bayId;
	private Integer ptransformerId;
	private Integer inode;
	private Integer knode;
	private Integer topoStatus;

	// Constructors

	/** default constructor */
	public Transformerwinding() {
	}

	/** minimal constructor */
	public Transformerwinding(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Transformerwinding(Integer id, String name, String description, String rdfid, Integer equiptypeId,
			Integer baseVoltageId, Integer districtId, Integer stationId, Integer bayId, Integer ptransformerId,
			Integer inode, Integer knode, Integer topoStatus) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.rdfid = rdfid;
		this.equiptypeId = equiptypeId;
		this.baseVoltageId = baseVoltageId;
		this.districtId = districtId;
		this.stationId = stationId;
		this.bayId = bayId;
		this.ptransformerId = ptransformerId;
		this.inode = inode;
		this.knode = knode;
		this.topoStatus = topoStatus;
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

	@Column(name = "equiptypeID")

	public Integer getEquiptypeId() {
		return this.equiptypeId;
	}

	public void setEquiptypeId(Integer equiptypeId) {
		this.equiptypeId = equiptypeId;
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

	@Column(name = "PTransformerID")

	public Integer getPtransformerId() {
		return this.ptransformerId;
	}

	public void setPtransformerId(Integer ptransformerId) {
		this.ptransformerId = ptransformerId;
	}

	@Column(name = "inode")

	public Integer getInode() {
		return this.inode;
	}

	public void setInode(Integer inode) {
		this.inode = inode;
	}

	@Column(name = "knode")

	public Integer getKnode() {
		return this.knode;
	}

	public void setKnode(Integer knode) {
		this.knode = knode;
	}

	@Column(name = "topoStatus")

	public Integer getTopoStatus() {
		return this.topoStatus;
	}

	public void setTopoStatus(Integer topoStatus) {
		this.topoStatus = topoStatus;
	}

}
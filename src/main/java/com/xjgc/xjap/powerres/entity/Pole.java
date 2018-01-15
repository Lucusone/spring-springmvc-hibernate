package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Pole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pole", catalog = "e8000")

public class Pole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private String rdfid;
	private Integer equiptypeid;
	private String poleNo;
	private Integer districtId;
	private Integer stationId;
	private Integer feederId;
	private Integer inode;
	private String equipList;
	private Integer tagStatus;

	// Constructors

	/** default constructor */
	public Pole() {
	}

	/** minimal constructor */
	public Pole(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Pole(Integer id, String name, String description, String rdfid, Integer equiptypeid, String poleNo,
			Integer districtId, Integer stationId, Integer feederId, Integer inode, String equipList,
			Integer tagStatus) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.rdfid = rdfid;
		this.equiptypeid = equiptypeid;
		this.poleNo = poleNo;
		this.districtId = districtId;
		this.stationId = stationId;
		this.feederId = feederId;
		this.inode = inode;
		this.equipList = equipList;
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

	@Column(name = "Equiptypeid")

	public Integer getEquiptypeid() {
		return this.equiptypeid;
	}

	public void setEquiptypeid(Integer equiptypeid) {
		this.equiptypeid = equiptypeid;
	}

	@Column(name = "PoleNo", length = 64)

	public String getPoleNo() {
		return this.poleNo;
	}

	public void setPoleNo(String poleNo) {
		this.poleNo = poleNo;
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

	@Column(name = "FeederID")

	public Integer getFeederId() {
		return this.feederId;
	}

	public void setFeederId(Integer feederId) {
		this.feederId = feederId;
	}

	@Column(name = "inode")

	public Integer getInode() {
		return this.inode;
	}

	public void setInode(Integer inode) {
		this.inode = inode;
	}

	@Column(name = "EquipList", length = 256)

	public String getEquipList() {
		return this.equipList;
	}

	public void setEquipList(String equipList) {
		this.equipList = equipList;
	}

	@Column(name = "tagStatus")

	public Integer getTagStatus() {
		return this.tagStatus;
	}

	public void setTagStatus(Integer tagStatus) {
		this.tagStatus = tagStatus;
	}

}
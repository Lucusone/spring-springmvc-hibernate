package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Linksegment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "linksegment", catalog = "e8000")

public class Linksegment implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private String description;
	private String rdfid;
	private Integer inode;
	private Integer jnode;
	private Integer districtId;
	private Integer stationId;

	// Constructors

	/** default constructor */
	public Linksegment() {
	}

	/** minimal constructor */
	public Linksegment(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Linksegment(Integer id, String code, String name, String description, String rdfid, Integer inode,
			Integer jnode, Integer districtId, Integer stationId) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.rdfid = rdfid;
		this.inode = inode;
		this.jnode = jnode;
		this.districtId = districtId;
		this.stationId = stationId;
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

}
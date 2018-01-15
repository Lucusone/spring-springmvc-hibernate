package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Toponode entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "toponode", catalog = "e8000")

public class Toponode implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer nodeType;
	private Integer topoRegionId;
	private String linkIds;

	// Constructors

	/** default constructor */
	public Toponode() {
	}

	/** minimal constructor */
	public Toponode(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Toponode(Integer id, Integer nodeType, Integer topoRegionId, String linkIds) {
		this.id = id;
		this.nodeType = nodeType;
		this.topoRegionId = topoRegionId;
		this.linkIds = linkIds;
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

	@Column(name = "NodeType")

	public Integer getNodeType() {
		return this.nodeType;
	}

	public void setNodeType(Integer nodeType) {
		this.nodeType = nodeType;
	}

	@Column(name = "TopoRegionID")

	public Integer getTopoRegionId() {
		return this.topoRegionId;
	}

	public void setTopoRegionId(Integer topoRegionId) {
		this.topoRegionId = topoRegionId;
	}

	@Column(name = "LinkIDs", length = 128)

	public String getLinkIds() {
		return this.linkIds;
	}

	public void setLinkIds(String linkIds) {
		this.linkIds = linkIds;
	}

}
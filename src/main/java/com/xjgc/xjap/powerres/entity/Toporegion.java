package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Toporegion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "toporegion", catalog = "e8000")

public class Toporegion implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String rdfid;
	private String switchs;
	private String faultIndicators;
	private String disTransformers;
	private String linkDevs;
	private Integer stationId;
	private Integer feederId;
	private String dgLoadSwId;
	private Integer topoStatus;
	private Integer faultStatus;

	// Constructors

	/** default constructor */
	public Toporegion() {
	}

	/** minimal constructor */
	public Toporegion(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Toporegion(Integer id, String name, String rdfid, String switchs, String faultIndicators,
			String disTransformers, String linkDevs, Integer stationId, Integer feederId, String dgLoadSwId,
			Integer topoStatus, Integer faultStatus) {
		this.id = id;
		this.name = name;
		this.rdfid = rdfid;
		this.switchs = switchs;
		this.faultIndicators = faultIndicators;
		this.disTransformers = disTransformers;
		this.linkDevs = linkDevs;
		this.stationId = stationId;
		this.feederId = feederId;
		this.dgLoadSwId = dgLoadSwId;
		this.topoStatus = topoStatus;
		this.faultStatus = faultStatus;
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

	@Column(name = "name", length = 64)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "rdfid", length = 64)

	public String getRdfid() {
		return this.rdfid;
	}

	public void setRdfid(String rdfid) {
		this.rdfid = rdfid;
	}

	@Column(name = "switchs", length = 1024)

	public String getSwitchs() {
		return this.switchs;
	}

	public void setSwitchs(String switchs) {
		this.switchs = switchs;
	}

	@Column(name = "FaultIndicators", length = 1024)

	public String getFaultIndicators() {
		return this.faultIndicators;
	}

	public void setFaultIndicators(String faultIndicators) {
		this.faultIndicators = faultIndicators;
	}

	@Column(name = "DisTransformers", length = 1024)

	public String getDisTransformers() {
		return this.disTransformers;
	}

	public void setDisTransformers(String disTransformers) {
		this.disTransformers = disTransformers;
	}

	@Column(name = "LinkDevs", length = 1024)

	public String getLinkDevs() {
		return this.linkDevs;
	}

	public void setLinkDevs(String linkDevs) {
		this.linkDevs = linkDevs;
	}

	@Column(name = "StationId")

	public Integer getStationId() {
		return this.stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	@Column(name = "FeederId")

	public Integer getFeederId() {
		return this.feederId;
	}

	public void setFeederId(Integer feederId) {
		this.feederId = feederId;
	}

	@Column(name = "DgLoadSwId", length = 16)

	public String getDgLoadSwId() {
		return this.dgLoadSwId;
	}

	public void setDgLoadSwId(String dgLoadSwId) {
		this.dgLoadSwId = dgLoadSwId;
	}

	@Column(name = "topoStatus")

	public Integer getTopoStatus() {
		return this.topoStatus;
	}

	public void setTopoStatus(Integer topoStatus) {
		this.topoStatus = topoStatus;
	}

	@Column(name = "faultStatus")

	public Integer getFaultStatus() {
		return this.faultStatus;
	}

	public void setFaultStatus(Integer faultStatus) {
		this.faultStatus = faultStatus;
	}

}
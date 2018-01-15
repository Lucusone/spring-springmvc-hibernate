package com.xjgc.xjap.powerres.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tag entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tag", catalog = "e8000")

public class Tag implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer stationId;
	private Integer feederId;
	private Integer equipid;
	private Integer equipclassid;
	private Integer tagtypeid;
	private Integer userid;
	private Date settime;

	// Constructors

	/** default constructor */
	public Tag() {
	}

	/** minimal constructor */
	public Tag(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Tag(Integer id, Integer stationId, Integer feederId, Integer equipid, Integer equipclassid,
			Integer tagtypeid, Integer userid, Date settime) {
		this.id = id;
		this.stationId = stationId;
		this.feederId = feederId;
		this.equipid = equipid;
		this.equipclassid = equipclassid;
		this.tagtypeid = tagtypeid;
		this.userid = userid;
		this.settime = settime;
	}

	// Property accessors
	@Id

	@Column(name = "ID", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Column(name = "equipid")

	public Integer getEquipid() {
		return this.equipid;
	}

	public void setEquipid(Integer equipid) {
		this.equipid = equipid;
	}

	@Column(name = "equipclassid")

	public Integer getEquipclassid() {
		return this.equipclassid;
	}

	public void setEquipclassid(Integer equipclassid) {
		this.equipclassid = equipclassid;
	}

	@Column(name = "tagtypeid")

	public Integer getTagtypeid() {
		return this.tagtypeid;
	}

	public void setTagtypeid(Integer tagtypeid) {
		this.tagtypeid = tagtypeid;
	}

	@Column(name = "userid")

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "settime", length = 10)

	public Date getSettime() {
		return this.settime;
	}

	public void setSettime(Date settime) {
		this.settime = settime;
	}

}
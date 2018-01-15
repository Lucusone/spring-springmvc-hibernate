package com.xjgc.xjap.powerres.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tapcontrol entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tapcontrol", catalog = "e8000")

public class Tapcontrol implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private Integer districtId;
	private Integer stationId;
	private Integer bayId;
	private Integer transformerId;
	private Integer trwdId;
	private Integer meastypeid;
	private Integer analogid;
	private Integer commsrcid;
	private Integer upPointId;
	private Integer downPointId;
	private Integer stopPointId;
	private Integer upCtlValue;
	private Integer downCtlValue;
	private Integer stopCtlValue;
	private Integer overtimelmt;
	private Integer attribute;
	private String doublecode;
	private Integer lockflag;
	private String lkexpcal;
	private Integer wait;
	private Integer deleteflag;
	private String family;
	private Timestamp startTime;

	// Constructors

	/** default constructor */
	public Tapcontrol() {
	}

	/** minimal constructor */
	public Tapcontrol(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Tapcontrol(Integer id, String name, String description, Integer districtId, Integer stationId, Integer bayId,
			Integer transformerId, Integer trwdId, Integer meastypeid, Integer analogid, Integer commsrcid,
			Integer upPointId, Integer downPointId, Integer stopPointId, Integer upCtlValue, Integer downCtlValue,
			Integer stopCtlValue, Integer overtimelmt, Integer attribute, String doublecode, Integer lockflag,
			String lkexpcal, Integer wait, Integer deleteflag, String family, Timestamp startTime) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.districtId = districtId;
		this.stationId = stationId;
		this.bayId = bayId;
		this.transformerId = transformerId;
		this.trwdId = trwdId;
		this.meastypeid = meastypeid;
		this.analogid = analogid;
		this.commsrcid = commsrcid;
		this.upPointId = upPointId;
		this.downPointId = downPointId;
		this.stopPointId = stopPointId;
		this.upCtlValue = upCtlValue;
		this.downCtlValue = downCtlValue;
		this.stopCtlValue = stopCtlValue;
		this.overtimelmt = overtimelmt;
		this.attribute = attribute;
		this.doublecode = doublecode;
		this.lockflag = lockflag;
		this.lkexpcal = lkexpcal;
		this.wait = wait;
		this.deleteflag = deleteflag;
		this.family = family;
		this.startTime = startTime;
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

	@Column(name = "TransformerID")

	public Integer getTransformerId() {
		return this.transformerId;
	}

	public void setTransformerId(Integer transformerId) {
		this.transformerId = transformerId;
	}

	@Column(name = "trwdID")

	public Integer getTrwdId() {
		return this.trwdId;
	}

	public void setTrwdId(Integer trwdId) {
		this.trwdId = trwdId;
	}

	@Column(name = "meastypeid")

	public Integer getMeastypeid() {
		return this.meastypeid;
	}

	public void setMeastypeid(Integer meastypeid) {
		this.meastypeid = meastypeid;
	}

	@Column(name = "analogid")

	public Integer getAnalogid() {
		return this.analogid;
	}

	public void setAnalogid(Integer analogid) {
		this.analogid = analogid;
	}

	@Column(name = "commsrcid")

	public Integer getCommsrcid() {
		return this.commsrcid;
	}

	public void setCommsrcid(Integer commsrcid) {
		this.commsrcid = commsrcid;
	}

	@Column(name = "upPointID")

	public Integer getUpPointId() {
		return this.upPointId;
	}

	public void setUpPointId(Integer upPointId) {
		this.upPointId = upPointId;
	}

	@Column(name = "downPointID")

	public Integer getDownPointId() {
		return this.downPointId;
	}

	public void setDownPointId(Integer downPointId) {
		this.downPointId = downPointId;
	}

	@Column(name = "stopPointID")

	public Integer getStopPointId() {
		return this.stopPointId;
	}

	public void setStopPointId(Integer stopPointId) {
		this.stopPointId = stopPointId;
	}

	@Column(name = "upCtlValue")

	public Integer getUpCtlValue() {
		return this.upCtlValue;
	}

	public void setUpCtlValue(Integer upCtlValue) {
		this.upCtlValue = upCtlValue;
	}

	@Column(name = "downCtlValue")

	public Integer getDownCtlValue() {
		return this.downCtlValue;
	}

	public void setDownCtlValue(Integer downCtlValue) {
		this.downCtlValue = downCtlValue;
	}

	@Column(name = "stopCtlValue")

	public Integer getStopCtlValue() {
		return this.stopCtlValue;
	}

	public void setStopCtlValue(Integer stopCtlValue) {
		this.stopCtlValue = stopCtlValue;
	}

	@Column(name = "overtimelmt")

	public Integer getOvertimelmt() {
		return this.overtimelmt;
	}

	public void setOvertimelmt(Integer overtimelmt) {
		this.overtimelmt = overtimelmt;
	}

	@Column(name = "attribute")

	public Integer getAttribute() {
		return this.attribute;
	}

	public void setAttribute(Integer attribute) {
		this.attribute = attribute;
	}

	@Column(name = "doublecode", length = 32)

	public String getDoublecode() {
		return this.doublecode;
	}

	public void setDoublecode(String doublecode) {
		this.doublecode = doublecode;
	}

	@Column(name = "lockflag")

	public Integer getLockflag() {
		return this.lockflag;
	}

	public void setLockflag(Integer lockflag) {
		this.lockflag = lockflag;
	}

	@Column(name = "lkexpcal", length = 256)

	public String getLkexpcal() {
		return this.lkexpcal;
	}

	public void setLkexpcal(String lkexpcal) {
		this.lkexpcal = lkexpcal;
	}

	@Column(name = "wait")

	public Integer getWait() {
		return this.wait;
	}

	public void setWait(Integer wait) {
		this.wait = wait;
	}

	@Column(name = "deleteflag")

	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

	@Column(name = "family", length = 64)

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Column(name = "StartTime", length = 19)

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

}
package com.xjgc.xjap.powerres.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Analogcontrol entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "analogcontrol", catalog = "e8000")

public class Analogcontrol implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private String description;
	private Integer districtId;
	private Integer stationId;
	private Integer bayId;
	private Integer feederId;
	private Integer dsubStationId;
	private String equipObject;
	private Integer meastypeid;
	private Integer analogid;
	private Integer commsrcid;
	private Integer commPointId;
	private Integer overtimelmt;
	private Integer attribute;
	private Integer ctrlmode;
	private String doublecode;
	private Integer lockflag;
	private String lkexpcal;
	private Integer deleteflag;
	private String family;
	private Integer ctrlCount;
	private Integer sucCount;
	private Timestamp startTime;

	// Constructors

	/** default constructor */
	public Analogcontrol() {
	}

	/** minimal constructor */
	public Analogcontrol(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Analogcontrol(Integer id, String code, String name, String description, Integer districtId,
			Integer stationId, Integer bayId, Integer feederId, Integer dsubStationId, String equipObject,
			Integer meastypeid, Integer analogid, Integer commsrcid, Integer commPointId, Integer overtimelmt,
			Integer attribute, Integer ctrlmode, String doublecode, Integer lockflag, String lkexpcal,
			Integer deleteflag, String family, Integer ctrlCount, Integer sucCount, Timestamp startTime) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.districtId = districtId;
		this.stationId = stationId;
		this.bayId = bayId;
		this.feederId = feederId;
		this.dsubStationId = dsubStationId;
		this.equipObject = equipObject;
		this.meastypeid = meastypeid;
		this.analogid = analogid;
		this.commsrcid = commsrcid;
		this.commPointId = commPointId;
		this.overtimelmt = overtimelmt;
		this.attribute = attribute;
		this.ctrlmode = ctrlmode;
		this.doublecode = doublecode;
		this.lockflag = lockflag;
		this.lkexpcal = lkexpcal;
		this.deleteflag = deleteflag;
		this.family = family;
		this.ctrlCount = ctrlCount;
		this.sucCount = sucCount;
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

	@Column(name = "EquipObject", length = 16)

	public String getEquipObject() {
		return this.equipObject;
	}

	public void setEquipObject(String equipObject) {
		this.equipObject = equipObject;
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

	@Column(name = "CommPointID")

	public Integer getCommPointId() {
		return this.commPointId;
	}

	public void setCommPointId(Integer commPointId) {
		this.commPointId = commPointId;
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

	@Column(name = "ctrlmode")

	public Integer getCtrlmode() {
		return this.ctrlmode;
	}

	public void setCtrlmode(Integer ctrlmode) {
		this.ctrlmode = ctrlmode;
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

	@Column(name = "CtrlCount")

	public Integer getCtrlCount() {
		return this.ctrlCount;
	}

	public void setCtrlCount(Integer ctrlCount) {
		this.ctrlCount = ctrlCount;
	}

	@Column(name = "SucCount")

	public Integer getSucCount() {
		return this.sucCount;
	}

	public void setSucCount(Integer sucCount) {
		this.sucCount = sucCount;
	}

	@Column(name = "StartTime", length = 19)

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

}
package com.xjgc.xjap.powerres.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Digitalcontrol entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "digitalcontrol", catalog = "e8000")

public class Digitalcontrol implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer commsrcid;
	private Integer commPointId;
	private String description;
	private Integer districtId;
	private Integer stationId;
	private Integer bayId;
	private Integer feederId;
	private Integer dsubStationId;
	private String equipObject;
	private Integer meastypeid;
	private Integer statusid;
	private Integer relationid1;
	private Integer relationid2;
	private Integer relationid3;
	private Integer relationid4;
	private Integer onstate1;
	private Integer offstate1;
	private Integer onstate2;
	private Integer offstate2;
	private Integer onstate3;
	private Integer offstate3;
	private Integer onstate4;
	private Integer offstate4;
	private Integer overtimelmt;
	private Integer attribute;
	private Integer ctrlmode;
	private Integer lockflag;
	private String lkexpcal;
	private Integer maxctrlcount;
	private String doublecode;
	private Integer deleteflag;
	private String family;
	private Integer ctrlCount;
	private Integer sucCount;
	private Timestamp startTime;

	// Constructors

	/** default constructor */
	public Digitalcontrol() {
	}

	/** minimal constructor */
	public Digitalcontrol(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Digitalcontrol(Integer id, String name, Integer commsrcid, Integer commPointId, String description,
			Integer districtId, Integer stationId, Integer bayId, Integer feederId, Integer dsubStationId,
			String equipObject, Integer meastypeid, Integer statusid, Integer relationid1, Integer relationid2,
			Integer relationid3, Integer relationid4, Integer onstate1, Integer offstate1, Integer onstate2,
			Integer offstate2, Integer onstate3, Integer offstate3, Integer onstate4, Integer offstate4,
			Integer overtimelmt, Integer attribute, Integer ctrlmode, Integer lockflag, String lkexpcal,
			Integer maxctrlcount, String doublecode, Integer deleteflag, String family, Integer ctrlCount,
			Integer sucCount, Timestamp startTime) {
		this.id = id;
		this.name = name;
		this.commsrcid = commsrcid;
		this.commPointId = commPointId;
		this.description = description;
		this.districtId = districtId;
		this.stationId = stationId;
		this.bayId = bayId;
		this.feederId = feederId;
		this.dsubStationId = dsubStationId;
		this.equipObject = equipObject;
		this.meastypeid = meastypeid;
		this.statusid = statusid;
		this.relationid1 = relationid1;
		this.relationid2 = relationid2;
		this.relationid3 = relationid3;
		this.relationid4 = relationid4;
		this.onstate1 = onstate1;
		this.offstate1 = offstate1;
		this.onstate2 = onstate2;
		this.offstate2 = offstate2;
		this.onstate3 = onstate3;
		this.offstate3 = offstate3;
		this.onstate4 = onstate4;
		this.offstate4 = offstate4;
		this.overtimelmt = overtimelmt;
		this.attribute = attribute;
		this.ctrlmode = ctrlmode;
		this.lockflag = lockflag;
		this.lkexpcal = lkexpcal;
		this.maxctrlcount = maxctrlcount;
		this.doublecode = doublecode;
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

	@Column(name = "name", length = 32)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Column(name = "statusid")

	public Integer getStatusid() {
		return this.statusid;
	}

	public void setStatusid(Integer statusid) {
		this.statusid = statusid;
	}

	@Column(name = "relationid1")

	public Integer getRelationid1() {
		return this.relationid1;
	}

	public void setRelationid1(Integer relationid1) {
		this.relationid1 = relationid1;
	}

	@Column(name = "relationid2")

	public Integer getRelationid2() {
		return this.relationid2;
	}

	public void setRelationid2(Integer relationid2) {
		this.relationid2 = relationid2;
	}

	@Column(name = "relationid3")

	public Integer getRelationid3() {
		return this.relationid3;
	}

	public void setRelationid3(Integer relationid3) {
		this.relationid3 = relationid3;
	}

	@Column(name = "relationid4")

	public Integer getRelationid4() {
		return this.relationid4;
	}

	public void setRelationid4(Integer relationid4) {
		this.relationid4 = relationid4;
	}

	@Column(name = "onstate1")

	public Integer getOnstate1() {
		return this.onstate1;
	}

	public void setOnstate1(Integer onstate1) {
		this.onstate1 = onstate1;
	}

	@Column(name = "offstate1")

	public Integer getOffstate1() {
		return this.offstate1;
	}

	public void setOffstate1(Integer offstate1) {
		this.offstate1 = offstate1;
	}

	@Column(name = "onstate2")

	public Integer getOnstate2() {
		return this.onstate2;
	}

	public void setOnstate2(Integer onstate2) {
		this.onstate2 = onstate2;
	}

	@Column(name = "offstate2")

	public Integer getOffstate2() {
		return this.offstate2;
	}

	public void setOffstate2(Integer offstate2) {
		this.offstate2 = offstate2;
	}

	@Column(name = "onstate3")

	public Integer getOnstate3() {
		return this.onstate3;
	}

	public void setOnstate3(Integer onstate3) {
		this.onstate3 = onstate3;
	}

	@Column(name = "offstate3")

	public Integer getOffstate3() {
		return this.offstate3;
	}

	public void setOffstate3(Integer offstate3) {
		this.offstate3 = offstate3;
	}

	@Column(name = "onstate4")

	public Integer getOnstate4() {
		return this.onstate4;
	}

	public void setOnstate4(Integer onstate4) {
		this.onstate4 = onstate4;
	}

	@Column(name = "offstate4")

	public Integer getOffstate4() {
		return this.offstate4;
	}

	public void setOffstate4(Integer offstate4) {
		this.offstate4 = offstate4;
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

	@Column(name = "maxctrlcount")

	public Integer getMaxctrlcount() {
		return this.maxctrlcount;
	}

	public void setMaxctrlcount(Integer maxctrlcount) {
		this.maxctrlcount = maxctrlcount;
	}

	@Column(name = "doublecode", length = 32)

	public String getDoublecode() {
		return this.doublecode;
	}

	public void setDoublecode(String doublecode) {
		this.doublecode = doublecode;
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
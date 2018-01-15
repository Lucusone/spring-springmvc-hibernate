package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Analog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "analog", catalog = "e8000")

public class Analog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer districtId;
	private Integer commsrcid;
	private Integer commpointid;
	private Integer stationId;
	private Integer bayId;
	private Integer feederId;
	private Integer dsubStationId;
	private String equipObject;
	private Double value;
	private Integer seqsvtimerid;
	private Integer meastypeid;
	private Integer limittypeid;
	private Integer abrupttypeid;
	private String description;
	private String pathname;
	private Double scalefactor;
	private Double offset;
	private Double zerodb;
	private Double diffdb;
	private Integer olddatimelim;
	private Integer measunitid;
	private Integer smprate;
	private Double maxval;
	private Double minval;
	private Double qualifyupval;
	private Double qualifyloval;
	private Double qualifydb;
	private String alarmpage;
	private String alarmvoice;
	private Integer complexflag;
	private Integer proflag;
	private Integer origin;
	private Double angle;
	private Integer prealarmstate;
	private Integer exceptime1;
	private Integer exceptime2;
	private Integer unchangedtime;
	private Integer isabrupt;
	private Integer abrupttime;
	private Integer operatorstate;
	private Integer deleteflag;
	private Integer lockflag;
	private Integer prohibitAlarm;
	private String family;
	private Integer uselmttypeflag;
	private Double uppervalue;
	private Double lowervalue;
	private Integer upperalarmact;
	private Integer loweralarmact;
	private Double deadzone;
	private Integer delaytime;
	private Integer datatransflag;

	// Constructors

	/** default constructor */
	public Analog() {
	}

	/** minimal constructor */
	public Analog(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Analog(Integer id, String name, Integer districtId, Integer commsrcid, Integer commpointid,
			Integer stationId, Integer bayId, Integer feederId, Integer dsubStationId, String equipObject, Double value,
			Integer seqsvtimerid, Integer meastypeid, Integer limittypeid, Integer abrupttypeid, String description,
			String pathname, Double scalefactor, Double offset, Double zerodb, Double diffdb, Integer olddatimelim,
			Integer measunitid, Integer smprate, Double maxval, Double minval, Double qualifyupval, Double qualifyloval,
			Double qualifydb, String alarmpage, String alarmvoice, Integer complexflag, Integer proflag, Integer origin,
			Double angle, Integer prealarmstate, Integer exceptime1, Integer exceptime2, Integer unchangedtime,
			Integer isabrupt, Integer abrupttime, Integer operatorstate, Integer deleteflag, Integer lockflag,
			Integer prohibitAlarm, String family, Integer uselmttypeflag, Double uppervalue, Double lowervalue,
			Integer upperalarmact, Integer loweralarmact, Double deadzone, Integer delaytime, Integer datatransflag) {
		this.id = id;
		this.name = name;
		this.districtId = districtId;
		this.commsrcid = commsrcid;
		this.commpointid = commpointid;
		this.stationId = stationId;
		this.bayId = bayId;
		this.feederId = feederId;
		this.dsubStationId = dsubStationId;
		this.equipObject = equipObject;
		this.value = value;
		this.seqsvtimerid = seqsvtimerid;
		this.meastypeid = meastypeid;
		this.limittypeid = limittypeid;
		this.abrupttypeid = abrupttypeid;
		this.description = description;
		this.pathname = pathname;
		this.scalefactor = scalefactor;
		this.offset = offset;
		this.zerodb = zerodb;
		this.diffdb = diffdb;
		this.olddatimelim = olddatimelim;
		this.measunitid = measunitid;
		this.smprate = smprate;
		this.maxval = maxval;
		this.minval = minval;
		this.qualifyupval = qualifyupval;
		this.qualifyloval = qualifyloval;
		this.qualifydb = qualifydb;
		this.alarmpage = alarmpage;
		this.alarmvoice = alarmvoice;
		this.complexflag = complexflag;
		this.proflag = proflag;
		this.origin = origin;
		this.angle = angle;
		this.prealarmstate = prealarmstate;
		this.exceptime1 = exceptime1;
		this.exceptime2 = exceptime2;
		this.unchangedtime = unchangedtime;
		this.isabrupt = isabrupt;
		this.abrupttime = abrupttime;
		this.operatorstate = operatorstate;
		this.deleteflag = deleteflag;
		this.lockflag = lockflag;
		this.prohibitAlarm = prohibitAlarm;
		this.family = family;
		this.uselmttypeflag = uselmttypeflag;
		this.uppervalue = uppervalue;
		this.lowervalue = lowervalue;
		this.upperalarmact = upperalarmact;
		this.loweralarmact = loweralarmact;
		this.deadzone = deadzone;
		this.delaytime = delaytime;
		this.datatransflag = datatransflag;
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

	@Column(name = "NAME", length = 128)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DistrictId")

	public Integer getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	@Column(name = "COMMSRCID")

	public Integer getCommsrcid() {
		return this.commsrcid;
	}

	public void setCommsrcid(Integer commsrcid) {
		this.commsrcid = commsrcid;
	}

	@Column(name = "COMMPOINTID")

	public Integer getCommpointid() {
		return this.commpointid;
	}

	public void setCommpointid(Integer commpointid) {
		this.commpointid = commpointid;
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

	@Column(name = "VALUE", precision = 22, scale = 0)

	public Double getValue() {
		return this.value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Column(name = "SEQSVTIMERID")

	public Integer getSeqsvtimerid() {
		return this.seqsvtimerid;
	}

	public void setSeqsvtimerid(Integer seqsvtimerid) {
		this.seqsvtimerid = seqsvtimerid;
	}

	@Column(name = "MEASTYPEID")

	public Integer getMeastypeid() {
		return this.meastypeid;
	}

	public void setMeastypeid(Integer meastypeid) {
		this.meastypeid = meastypeid;
	}

	@Column(name = "LIMITTYPEID")

	public Integer getLimittypeid() {
		return this.limittypeid;
	}

	public void setLimittypeid(Integer limittypeid) {
		this.limittypeid = limittypeid;
	}

	@Column(name = "ABRUPTTYPEID")

	public Integer getAbrupttypeid() {
		return this.abrupttypeid;
	}

	public void setAbrupttypeid(Integer abrupttypeid) {
		this.abrupttypeid = abrupttypeid;
	}

	@Column(name = "DESCRIPTION", length = 128)

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "PATHNAME", length = 64)

	public String getPathname() {
		return this.pathname;
	}

	public void setPathname(String pathname) {
		this.pathname = pathname;
	}

	@Column(name = "SCALEFACTOR", precision = 22, scale = 0)

	public Double getScalefactor() {
		return this.scalefactor;
	}

	public void setScalefactor(Double scalefactor) {
		this.scalefactor = scalefactor;
	}

	@Column(name = "OFFSET", precision = 22, scale = 0)

	public Double getOffset() {
		return this.offset;
	}

	public void setOffset(Double offset) {
		this.offset = offset;
	}

	@Column(name = "ZERODB", precision = 22, scale = 0)

	public Double getZerodb() {
		return this.zerodb;
	}

	public void setZerodb(Double zerodb) {
		this.zerodb = zerodb;
	}

	@Column(name = "DIFFDB", precision = 22, scale = 0)

	public Double getDiffdb() {
		return this.diffdb;
	}

	public void setDiffdb(Double diffdb) {
		this.diffdb = diffdb;
	}

	@Column(name = "OLDDATIMELIM")

	public Integer getOlddatimelim() {
		return this.olddatimelim;
	}

	public void setOlddatimelim(Integer olddatimelim) {
		this.olddatimelim = olddatimelim;
	}

	@Column(name = "MEASUNITID")

	public Integer getMeasunitid() {
		return this.measunitid;
	}

	public void setMeasunitid(Integer measunitid) {
		this.measunitid = measunitid;
	}

	@Column(name = "SMPRATE")

	public Integer getSmprate() {
		return this.smprate;
	}

	public void setSmprate(Integer smprate) {
		this.smprate = smprate;
	}

	@Column(name = "MAXVAL", precision = 22, scale = 0)

	public Double getMaxval() {
		return this.maxval;
	}

	public void setMaxval(Double maxval) {
		this.maxval = maxval;
	}

	@Column(name = "MINVAL", precision = 22, scale = 0)

	public Double getMinval() {
		return this.minval;
	}

	public void setMinval(Double minval) {
		this.minval = minval;
	}

	@Column(name = "QUALIFYUPVAL", precision = 22, scale = 0)

	public Double getQualifyupval() {
		return this.qualifyupval;
	}

	public void setQualifyupval(Double qualifyupval) {
		this.qualifyupval = qualifyupval;
	}

	@Column(name = "QUALIFYLOVAL", precision = 22, scale = 0)

	public Double getQualifyloval() {
		return this.qualifyloval;
	}

	public void setQualifyloval(Double qualifyloval) {
		this.qualifyloval = qualifyloval;
	}

	@Column(name = "QUALIFYDB", precision = 22, scale = 0)

	public Double getQualifydb() {
		return this.qualifydb;
	}

	public void setQualifydb(Double qualifydb) {
		this.qualifydb = qualifydb;
	}

	@Column(name = "ALARMPAGE", length = 128)

	public String getAlarmpage() {
		return this.alarmpage;
	}

	public void setAlarmpage(String alarmpage) {
		this.alarmpage = alarmpage;
	}

	@Column(name = "ALARMVOICE", length = 128)

	public String getAlarmvoice() {
		return this.alarmvoice;
	}

	public void setAlarmvoice(String alarmvoice) {
		this.alarmvoice = alarmvoice;
	}

	@Column(name = "COMPLEXFLAG")

	public Integer getComplexflag() {
		return this.complexflag;
	}

	public void setComplexflag(Integer complexflag) {
		this.complexflag = complexflag;
	}

	@Column(name = "PROFLAG")

	public Integer getProflag() {
		return this.proflag;
	}

	public void setProflag(Integer proflag) {
		this.proflag = proflag;
	}

	@Column(name = "ORIGIN")

	public Integer getOrigin() {
		return this.origin;
	}

	public void setOrigin(Integer origin) {
		this.origin = origin;
	}

	@Column(name = "ANGLE", precision = 22, scale = 0)

	public Double getAngle() {
		return this.angle;
	}

	public void setAngle(Double angle) {
		this.angle = angle;
	}

	@Column(name = "PREALARMSTATE")

	public Integer getPrealarmstate() {
		return this.prealarmstate;
	}

	public void setPrealarmstate(Integer prealarmstate) {
		this.prealarmstate = prealarmstate;
	}

	@Column(name = "EXCEPTIME1")

	public Integer getExceptime1() {
		return this.exceptime1;
	}

	public void setExceptime1(Integer exceptime1) {
		this.exceptime1 = exceptime1;
	}

	@Column(name = "EXCEPTIME2")

	public Integer getExceptime2() {
		return this.exceptime2;
	}

	public void setExceptime2(Integer exceptime2) {
		this.exceptime2 = exceptime2;
	}

	@Column(name = "UNCHANGEDTIME")

	public Integer getUnchangedtime() {
		return this.unchangedtime;
	}

	public void setUnchangedtime(Integer unchangedtime) {
		this.unchangedtime = unchangedtime;
	}

	@Column(name = "ISABRUPT")

	public Integer getIsabrupt() {
		return this.isabrupt;
	}

	public void setIsabrupt(Integer isabrupt) {
		this.isabrupt = isabrupt;
	}

	@Column(name = "ABRUPTTIME")

	public Integer getAbrupttime() {
		return this.abrupttime;
	}

	public void setAbrupttime(Integer abrupttime) {
		this.abrupttime = abrupttime;
	}

	@Column(name = "OPERATORSTATE")

	public Integer getOperatorstate() {
		return this.operatorstate;
	}

	public void setOperatorstate(Integer operatorstate) {
		this.operatorstate = operatorstate;
	}

	@Column(name = "DELETEFLAG")

	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

	@Column(name = "LOCKFLAG")

	public Integer getLockflag() {
		return this.lockflag;
	}

	public void setLockflag(Integer lockflag) {
		this.lockflag = lockflag;
	}

	@Column(name = "ProhibitAlarm")

	public Integer getProhibitAlarm() {
		return this.prohibitAlarm;
	}

	public void setProhibitAlarm(Integer prohibitAlarm) {
		this.prohibitAlarm = prohibitAlarm;
	}

	@Column(name = "FAMILY", length = 64)

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Column(name = "USELMTTYPEFLAG")

	public Integer getUselmttypeflag() {
		return this.uselmttypeflag;
	}

	public void setUselmttypeflag(Integer uselmttypeflag) {
		this.uselmttypeflag = uselmttypeflag;
	}

	@Column(name = "UPPERVALUE", precision = 22, scale = 0)

	public Double getUppervalue() {
		return this.uppervalue;
	}

	public void setUppervalue(Double uppervalue) {
		this.uppervalue = uppervalue;
	}

	@Column(name = "LOWERVALUE", precision = 22, scale = 0)

	public Double getLowervalue() {
		return this.lowervalue;
	}

	public void setLowervalue(Double lowervalue) {
		this.lowervalue = lowervalue;
	}

	@Column(name = "UPPERALARMACT")

	public Integer getUpperalarmact() {
		return this.upperalarmact;
	}

	public void setUpperalarmact(Integer upperalarmact) {
		this.upperalarmact = upperalarmact;
	}

	@Column(name = "LOWERALARMACT")

	public Integer getLoweralarmact() {
		return this.loweralarmact;
	}

	public void setLoweralarmact(Integer loweralarmact) {
		this.loweralarmact = loweralarmact;
	}

	@Column(name = "DEADZONE", precision = 22, scale = 0)

	public Double getDeadzone() {
		return this.deadzone;
	}

	public void setDeadzone(Double deadzone) {
		this.deadzone = deadzone;
	}

	@Column(name = "DELAYTIME")

	public Integer getDelaytime() {
		return this.delaytime;
	}

	public void setDelaytime(Integer delaytime) {
		this.delaytime = delaytime;
	}

	@Column(name = "DATATRANSFLAG")

	public Integer getDatatransflag() {
		return this.datatransflag;
	}

	public void setDatatransflag(Integer datatransflag) {
		this.datatransflag = datatransflag;
	}

}
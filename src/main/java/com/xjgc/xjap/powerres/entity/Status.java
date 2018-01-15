package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Status entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "status", catalog = "e8000")

public class Status implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer commsrcid;
	private Integer commpointid;
	private Integer districtId;
	private Integer stationId;
	private Integer bayId;
	private Integer feederId;
	private Integer dsubStationId;
	private String equipObject;
	private Double value;
	private Integer seqsvtimerid;
	private Integer meastypeid;
	private String description;
	private String pathname;
	private String alarmpage;
	private String alarmvoice;
	private Integer proflag;
	private Integer lastvalue;
	private Integer gzstate;
	private Integer origin;
	private Integer surgetimes;
	private Integer alarmcounter;
	private Integer operatorstate;
	private Integer deleteflag;
	private String family;
	private Integer lockflag;
	private Integer prohibitAlarm;
	private Integer delaytime;
	private Integer revertlmt;
	private Integer maxfaultlmt;
	private Integer changecountlmt;
	private Integer revertalarmact;
	private Integer maxfaultalact;
	private Integer changecountalact;
	private Integer datatransflag;

	// Constructors

	/** default constructor */
	public Status() {
	}

	/** minimal constructor */
	public Status(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Status(Integer id, String name, Integer commsrcid, Integer commpointid, Integer districtId,
			Integer stationId, Integer bayId, Integer feederId, Integer dsubStationId, String equipObject, Double value,
			Integer seqsvtimerid, Integer meastypeid, String description, String pathname, String alarmpage,
			String alarmvoice, Integer proflag, Integer lastvalue, Integer gzstate, Integer origin, Integer surgetimes,
			Integer alarmcounter, Integer operatorstate, Integer deleteflag, String family, Integer lockflag,
			Integer prohibitAlarm, Integer delaytime, Integer revertlmt, Integer maxfaultlmt, Integer changecountlmt,
			Integer revertalarmact, Integer maxfaultalact, Integer changecountalact, Integer datatransflag) {
		this.id = id;
		this.name = name;
		this.commsrcid = commsrcid;
		this.commpointid = commpointid;
		this.districtId = districtId;
		this.stationId = stationId;
		this.bayId = bayId;
		this.feederId = feederId;
		this.dsubStationId = dsubStationId;
		this.equipObject = equipObject;
		this.value = value;
		this.seqsvtimerid = seqsvtimerid;
		this.meastypeid = meastypeid;
		this.description = description;
		this.pathname = pathname;
		this.alarmpage = alarmpage;
		this.alarmvoice = alarmvoice;
		this.proflag = proflag;
		this.lastvalue = lastvalue;
		this.gzstate = gzstate;
		this.origin = origin;
		this.surgetimes = surgetimes;
		this.alarmcounter = alarmcounter;
		this.operatorstate = operatorstate;
		this.deleteflag = deleteflag;
		this.family = family;
		this.lockflag = lockflag;
		this.prohibitAlarm = prohibitAlarm;
		this.delaytime = delaytime;
		this.revertlmt = revertlmt;
		this.maxfaultlmt = maxfaultlmt;
		this.changecountlmt = changecountlmt;
		this.revertalarmact = revertalarmact;
		this.maxfaultalact = maxfaultalact;
		this.changecountalact = changecountalact;
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

	@Column(name = "VALUE", precision = 4, scale = 0)

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

	@Column(name = "PROFLAG")

	public Integer getProflag() {
		return this.proflag;
	}

	public void setProflag(Integer proflag) {
		this.proflag = proflag;
	}

	@Column(name = "LASTVALUE")

	public Integer getLastvalue() {
		return this.lastvalue;
	}

	public void setLastvalue(Integer lastvalue) {
		this.lastvalue = lastvalue;
	}

	@Column(name = "GZSTATE")

	public Integer getGzstate() {
		return this.gzstate;
	}

	public void setGzstate(Integer gzstate) {
		this.gzstate = gzstate;
	}

	@Column(name = "ORIGIN")

	public Integer getOrigin() {
		return this.origin;
	}

	public void setOrigin(Integer origin) {
		this.origin = origin;
	}

	@Column(name = "SURGETIMES")

	public Integer getSurgetimes() {
		return this.surgetimes;
	}

	public void setSurgetimes(Integer surgetimes) {
		this.surgetimes = surgetimes;
	}

	@Column(name = "ALARMCOUNTER")

	public Integer getAlarmcounter() {
		return this.alarmcounter;
	}

	public void setAlarmcounter(Integer alarmcounter) {
		this.alarmcounter = alarmcounter;
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

	@Column(name = "FAMILY", length = 64)

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
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

	@Column(name = "DELAYTIME")

	public Integer getDelaytime() {
		return this.delaytime;
	}

	public void setDelaytime(Integer delaytime) {
		this.delaytime = delaytime;
	}

	@Column(name = "REVERTLMT")

	public Integer getRevertlmt() {
		return this.revertlmt;
	}

	public void setRevertlmt(Integer revertlmt) {
		this.revertlmt = revertlmt;
	}

	@Column(name = "MAXFAULTLMT")

	public Integer getMaxfaultlmt() {
		return this.maxfaultlmt;
	}

	public void setMaxfaultlmt(Integer maxfaultlmt) {
		this.maxfaultlmt = maxfaultlmt;
	}

	@Column(name = "CHANGECOUNTLMT")

	public Integer getChangecountlmt() {
		return this.changecountlmt;
	}

	public void setChangecountlmt(Integer changecountlmt) {
		this.changecountlmt = changecountlmt;
	}

	@Column(name = "REVERTALARMACT")

	public Integer getRevertalarmact() {
		return this.revertalarmact;
	}

	public void setRevertalarmact(Integer revertalarmact) {
		this.revertalarmact = revertalarmact;
	}

	@Column(name = "MAXFAULTALACT")

	public Integer getMaxfaultalact() {
		return this.maxfaultalact;
	}

	public void setMaxfaultalact(Integer maxfaultalact) {
		this.maxfaultalact = maxfaultalact;
	}

	@Column(name = "CHANGECOUNTALACT")

	public Integer getChangecountalact() {
		return this.changecountalact;
	}

	public void setChangecountalact(Integer changecountalact) {
		this.changecountalact = changecountalact;
	}

	@Column(name = "DATATRANSFLAG")

	public Integer getDatatransflag() {
		return this.datatransflag;
	}

	public void setDatatransflag(Integer datatransflag) {
		this.datatransflag = datatransflag;
	}

}
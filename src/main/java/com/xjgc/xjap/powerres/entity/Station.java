package com.xjgc.xjap.powerres.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Station entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "station", catalog = "e8000")

public class Station implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private Integer districtid;
	private Integer maxvoltageid;
	private String description;
	private String pathname;
	private String telphone;
	private Date rundate;
	private Integer proflag;
	private Integer wfmode;
	private Integer wftime;
	private Integer fault;
	private Integer alarm;
	private Integer gzstate;
	private Integer daynum;
	private Date lastdate;
	private Integer status;
	private Integer lockenable;
	private Integer deleteflag;
	private Integer commsrcid;
	private String alarmpage;
	private String family;
	private Integer stationTypeid;

	// Constructors

	/** default constructor */
	public Station() {
	}

	/** minimal constructor */
	public Station(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Station(Integer id, String code, String name, Integer districtid, Integer maxvoltageid, String description,
			String pathname, String telphone, Date rundate, Integer proflag, Integer wfmode, Integer wftime,
			Integer fault, Integer alarm, Integer gzstate, Integer daynum, Date lastdate, Integer status,
			Integer lockenable, Integer deleteflag, Integer commsrcid, String alarmpage, String family,
			Integer stationTypeid) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.districtid = districtid;
		this.maxvoltageid = maxvoltageid;
		this.description = description;
		this.pathname = pathname;
		this.telphone = telphone;
		this.rundate = rundate;
		this.proflag = proflag;
		this.wfmode = wfmode;
		this.wftime = wftime;
		this.fault = fault;
		this.alarm = alarm;
		this.gzstate = gzstate;
		this.daynum = daynum;
		this.lastdate = lastdate;
		this.status = status;
		this.lockenable = lockenable;
		this.deleteflag = deleteflag;
		this.commsrcid = commsrcid;
		this.alarmpage = alarmpage;
		this.family = family;
		this.stationTypeid = stationTypeid;
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

	@Column(name = "CODE", length = 16)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "NAME", length = 128)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DISTRICTID")

	public Integer getDistrictid() {
		return this.districtid;
	}

	public void setDistrictid(Integer districtid) {
		this.districtid = districtid;
	}

	@Column(name = "MAXVOLTAGEID")

	public Integer getMaxvoltageid() {
		return this.maxvoltageid;
	}

	public void setMaxvoltageid(Integer maxvoltageid) {
		this.maxvoltageid = maxvoltageid;
	}

	@Column(name = "DESCRIPTION", length = 64)

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

	@Column(name = "TELPHONE", length = 32)

	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RUNDATE", length = 10)

	public Date getRundate() {
		return this.rundate;
	}

	public void setRundate(Date rundate) {
		this.rundate = rundate;
	}

	@Column(name = "PROFLAG")

	public Integer getProflag() {
		return this.proflag;
	}

	public void setProflag(Integer proflag) {
		this.proflag = proflag;
	}

	@Column(name = "WFMODE")

	public Integer getWfmode() {
		return this.wfmode;
	}

	public void setWfmode(Integer wfmode) {
		this.wfmode = wfmode;
	}

	@Column(name = "WFTIME")

	public Integer getWftime() {
		return this.wftime;
	}

	public void setWftime(Integer wftime) {
		this.wftime = wftime;
	}

	@Column(name = "FAULT")

	public Integer getFault() {
		return this.fault;
	}

	public void setFault(Integer fault) {
		this.fault = fault;
	}

	@Column(name = "ALARM")

	public Integer getAlarm() {
		return this.alarm;
	}

	public void setAlarm(Integer alarm) {
		this.alarm = alarm;
	}

	@Column(name = "GZSTATE")

	public Integer getGzstate() {
		return this.gzstate;
	}

	public void setGzstate(Integer gzstate) {
		this.gzstate = gzstate;
	}

	@Column(name = "DAYNUM")

	public Integer getDaynum() {
		return this.daynum;
	}

	public void setDaynum(Integer daynum) {
		this.daynum = daynum;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LASTDATE", length = 10)

	public Date getLastdate() {
		return this.lastdate;
	}

	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}

	@Column(name = "STATUS")

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "LOCKENABLE")

	public Integer getLockenable() {
		return this.lockenable;
	}

	public void setLockenable(Integer lockenable) {
		this.lockenable = lockenable;
	}

	@Column(name = "DELETEFLAG")

	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

	@Column(name = "COMMSRCID")

	public Integer getCommsrcid() {
		return this.commsrcid;
	}

	public void setCommsrcid(Integer commsrcid) {
		this.commsrcid = commsrcid;
	}

	@Column(name = "ALARMPAGE", length = 128)

	public String getAlarmpage() {
		return this.alarmpage;
	}

	public void setAlarmpage(String alarmpage) {
		this.alarmpage = alarmpage;
	}

	@Column(name = "FAMILY", length = 64)

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Column(name = "StationTYPEID")

	public Integer getStationTypeid() {
		return this.stationTypeid;
	}

	public void setStationTypeid(Integer stationTypeid) {
		this.stationTypeid = stationTypeid;
	}

}
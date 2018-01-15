package com.xjgc.xjap.powerres.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Setting entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "setting", catalog = "e8000")

public class Setting implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private Integer districtId;
	private Integer stationId;
	private Integer bayId;
	private Integer feederId;
	private Integer dsubStationId;
	private String equipObject;
	private Integer settingenumid;
	private Integer ctrlworddefid;
	private Integer meastypeid;
	private Integer commsrcid;
	private Integer commpointid;
	private Integer cpuid;
	private Integer settingmode;
	private String description;
	private String pathname;
	private Double maxdatavalue;
	private Double mindatavalue;
	private Integer analogid;
	private Double step;
	private Integer measunitid;
	private String settingvalue;
	private Integer settingarea;
	private Integer editarea;
	private Integer setareanum;
	private Integer valuetype;
	private Double firstcol;
	private Double secondcol;
	private Integer overtimelmt;
	private Integer deleteflag;
	private String family;
	private Integer lockflag;
	private Integer settingEnable;
	private Set<Settingarea> settingareas = new HashSet<Settingarea>(0);

	// Constructors

	/** default constructor */
	public Setting() {
	}

	/** minimal constructor */
	public Setting(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Setting(Integer id, String code, String name, Integer districtId, Integer stationId, Integer bayId,
			Integer feederId, Integer dsubStationId, String equipObject, Integer settingenumid, Integer ctrlworddefid,
			Integer meastypeid, Integer commsrcid, Integer commpointid, Integer cpuid, Integer settingmode,
			String description, String pathname, Double maxdatavalue, Double mindatavalue, Integer analogid,
			Double step, Integer measunitid, String settingvalue, Integer settingarea, Integer editarea,
			Integer setareanum, Integer valuetype, Double firstcol, Double secondcol, Integer overtimelmt,
			Integer deleteflag, String family, Integer lockflag, Integer settingEnable, Set<Settingarea> settingareas) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.districtId = districtId;
		this.stationId = stationId;
		this.bayId = bayId;
		this.feederId = feederId;
		this.dsubStationId = dsubStationId;
		this.equipObject = equipObject;
		this.settingenumid = settingenumid;
		this.ctrlworddefid = ctrlworddefid;
		this.meastypeid = meastypeid;
		this.commsrcid = commsrcid;
		this.commpointid = commpointid;
		this.cpuid = cpuid;
		this.settingmode = settingmode;
		this.description = description;
		this.pathname = pathname;
		this.maxdatavalue = maxdatavalue;
		this.mindatavalue = mindatavalue;
		this.analogid = analogid;
		this.step = step;
		this.measunitid = measunitid;
		this.settingvalue = settingvalue;
		this.settingarea = settingarea;
		this.editarea = editarea;
		this.setareanum = setareanum;
		this.valuetype = valuetype;
		this.firstcol = firstcol;
		this.secondcol = secondcol;
		this.overtimelmt = overtimelmt;
		this.deleteflag = deleteflag;
		this.family = family;
		this.lockflag = lockflag;
		this.settingEnable = settingEnable;
		this.settingareas = settingareas;
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

	@Column(name = "SETTINGENUMID")

	public Integer getSettingenumid() {
		return this.settingenumid;
	}

	public void setSettingenumid(Integer settingenumid) {
		this.settingenumid = settingenumid;
	}

	@Column(name = "CTRLWORDDEFID")

	public Integer getCtrlworddefid() {
		return this.ctrlworddefid;
	}

	public void setCtrlworddefid(Integer ctrlworddefid) {
		this.ctrlworddefid = ctrlworddefid;
	}

	@Column(name = "MEASTYPEID")

	public Integer getMeastypeid() {
		return this.meastypeid;
	}

	public void setMeastypeid(Integer meastypeid) {
		this.meastypeid = meastypeid;
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

	@Column(name = "CPUID")

	public Integer getCpuid() {
		return this.cpuid;
	}

	public void setCpuid(Integer cpuid) {
		this.cpuid = cpuid;
	}

	@Column(name = "SETTINGMODE")

	public Integer getSettingmode() {
		return this.settingmode;
	}

	public void setSettingmode(Integer settingmode) {
		this.settingmode = settingmode;
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

	@Column(name = "MAXDATAVALUE", precision = 22, scale = 0)

	public Double getMaxdatavalue() {
		return this.maxdatavalue;
	}

	public void setMaxdatavalue(Double maxdatavalue) {
		this.maxdatavalue = maxdatavalue;
	}

	@Column(name = "MINDATAVALUE", precision = 22, scale = 0)

	public Double getMindatavalue() {
		return this.mindatavalue;
	}

	public void setMindatavalue(Double mindatavalue) {
		this.mindatavalue = mindatavalue;
	}

	@Column(name = "ANALOGID")

	public Integer getAnalogid() {
		return this.analogid;
	}

	public void setAnalogid(Integer analogid) {
		this.analogid = analogid;
	}

	@Column(name = "STEP", precision = 22, scale = 0)

	public Double getStep() {
		return this.step;
	}

	public void setStep(Double step) {
		this.step = step;
	}

	@Column(name = "MEASUNITID")

	public Integer getMeasunitid() {
		return this.measunitid;
	}

	public void setMeasunitid(Integer measunitid) {
		this.measunitid = measunitid;
	}

	@Column(name = "SETTINGVALUE", length = 100)

	public String getSettingvalue() {
		return this.settingvalue;
	}

	public void setSettingvalue(String settingvalue) {
		this.settingvalue = settingvalue;
	}

	@Column(name = "SETTINGAREA")

	public Integer getSettingarea() {
		return this.settingarea;
	}

	public void setSettingarea(Integer settingarea) {
		this.settingarea = settingarea;
	}

	@Column(name = "EDITAREA")

	public Integer getEditarea() {
		return this.editarea;
	}

	public void setEditarea(Integer editarea) {
		this.editarea = editarea;
	}

	@Column(name = "SETAREANUM")

	public Integer getSetareanum() {
		return this.setareanum;
	}

	public void setSetareanum(Integer setareanum) {
		this.setareanum = setareanum;
	}

	@Column(name = "VALUETYPE")

	public Integer getValuetype() {
		return this.valuetype;
	}

	public void setValuetype(Integer valuetype) {
		this.valuetype = valuetype;
	}

	@Column(name = "FIRSTCOL", precision = 22, scale = 0)

	public Double getFirstcol() {
		return this.firstcol;
	}

	public void setFirstcol(Double firstcol) {
		this.firstcol = firstcol;
	}

	@Column(name = "SECONDCOL", precision = 22, scale = 0)

	public Double getSecondcol() {
		return this.secondcol;
	}

	public void setSecondcol(Double secondcol) {
		this.secondcol = secondcol;
	}

	@Column(name = "OVERTIMELMT")

	public Integer getOvertimelmt() {
		return this.overtimelmt;
	}

	public void setOvertimelmt(Integer overtimelmt) {
		this.overtimelmt = overtimelmt;
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

	@Column(name = "SettingEnable")

	public Integer getSettingEnable() {
		return this.settingEnable;
	}

	public void setSettingEnable(Integer settingEnable) {
		this.settingEnable = settingEnable;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "setting")

	public Set<Settingarea> getSettingareas() {
		return this.settingareas;
	}

	public void setSettingareas(Set<Settingarea> settingareas) {
		this.settingareas = settingareas;
	}

}
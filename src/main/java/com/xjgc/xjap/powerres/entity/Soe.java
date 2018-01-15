package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Soe entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "soe", catalog = "e8000")

public class Soe implements java.io.Serializable {

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
	private Integer commsrcid;
	private Integer commpointid;
	private String family;
	private Integer deleteflag;
	private Integer meastypeid;
	private Integer operatorstate;
	private Integer value;
	private Integer datatransflag;
	private String alarmpage;
	private String alarmvoice;
	private Integer gzenabled;
	private Integer gzstate;
	private Integer paranum;

	// Constructors

	/** default constructor */
	public Soe() {
	}

	/** minimal constructor */
	public Soe(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Soe(Integer id, String code, String name, String description, Integer districtId, Integer stationId,
			Integer bayId, Integer feederId, Integer dsubStationId, String equipObject, Integer commsrcid,
			Integer commpointid, String family, Integer deleteflag, Integer meastypeid, Integer operatorstate,
			Integer value, Integer datatransflag, String alarmpage, String alarmvoice, Integer gzenabled,
			Integer gzstate, Integer paranum) {
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
		this.commsrcid = commsrcid;
		this.commpointid = commpointid;
		this.family = family;
		this.deleteflag = deleteflag;
		this.meastypeid = meastypeid;
		this.operatorstate = operatorstate;
		this.value = value;
		this.datatransflag = datatransflag;
		this.alarmpage = alarmpage;
		this.alarmvoice = alarmvoice;
		this.gzenabled = gzenabled;
		this.gzstate = gzstate;
		this.paranum = paranum;
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

	@Column(name = "DESCRIPTION", length = 128)

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

	@Column(name = "FAMILY", length = 64)

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Column(name = "DELETEFLAG")

	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

	@Column(name = "MEASTYPEID")

	public Integer getMeastypeid() {
		return this.meastypeid;
	}

	public void setMeastypeid(Integer meastypeid) {
		this.meastypeid = meastypeid;
	}

	@Column(name = "OPERATORSTATE")

	public Integer getOperatorstate() {
		return this.operatorstate;
	}

	public void setOperatorstate(Integer operatorstate) {
		this.operatorstate = operatorstate;
	}

	@Column(name = "VALUE")

	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Column(name = "DATATRANSFLAG")

	public Integer getDatatransflag() {
		return this.datatransflag;
	}

	public void setDatatransflag(Integer datatransflag) {
		this.datatransflag = datatransflag;
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

	@Column(name = "GZENABLED")

	public Integer getGzenabled() {
		return this.gzenabled;
	}

	public void setGzenabled(Integer gzenabled) {
		this.gzenabled = gzenabled;
	}

	@Column(name = "GZSTATE")

	public Integer getGzstate() {
		return this.gzstate;
	}

	public void setGzstate(Integer gzstate) {
		this.gzstate = gzstate;
	}

	@Column(name = "PARANUM")

	public Integer getParanum() {
		return this.paranum;
	}

	public void setParanum(Integer paranum) {
		this.paranum = paranum;
	}

}
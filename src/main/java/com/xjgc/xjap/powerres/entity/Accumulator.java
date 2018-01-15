package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Accumulator entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "accumulator", catalog = "e8000")

public class Accumulator implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer districtId;
	private Integer stationId;
	private Integer bayId;
	private Integer feederId;
	private Integer dsubStationId;
	private String equipObject;
	private Double value;
	private Integer savetimerid;
	private Integer meastypeid;
	private Integer measunitid;
	private String description;
	private String pathname;
	private Integer signaltype;
	private Double scalefactor;
	private Double offset;
	private Integer commsrcid;
	private Integer commpointid;
	private Integer isperiodstatic;
	private Double uppervalue;
	private Double maxval;
	private Double minval;
	private Integer analogid;
	private Double incrementvalue;
	private Integer origin;
	private Double relativepower;
	private Double amountvalue;
	private Double totalvalue;
	private Integer deleteflag;
	private String family;
	private Integer lockflag;
	private Integer prohibitAlarm;
	private Integer saveflag;
	private Integer datatransflag;
	private String pathref;

	// Constructors

	/** default constructor */
	public Accumulator() {
	}

	/** minimal constructor */
	public Accumulator(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Accumulator(Integer id, String name, Integer districtId, Integer stationId, Integer bayId, Integer feederId,
			Integer dsubStationId, String equipObject, Double value, Integer savetimerid, Integer meastypeid,
			Integer measunitid, String description, String pathname, Integer signaltype, Double scalefactor,
			Double offset, Integer commsrcid, Integer commpointid, Integer isperiodstatic, Double uppervalue,
			Double maxval, Double minval, Integer analogid, Double incrementvalue, Integer origin, Double relativepower,
			Double amountvalue, Double totalvalue, Integer deleteflag, String family, Integer lockflag,
			Integer prohibitAlarm, Integer saveflag, Integer datatransflag, String pathref) {
		this.id = id;
		this.name = name;
		this.districtId = districtId;
		this.stationId = stationId;
		this.bayId = bayId;
		this.feederId = feederId;
		this.dsubStationId = dsubStationId;
		this.equipObject = equipObject;
		this.value = value;
		this.savetimerid = savetimerid;
		this.meastypeid = meastypeid;
		this.measunitid = measunitid;
		this.description = description;
		this.pathname = pathname;
		this.signaltype = signaltype;
		this.scalefactor = scalefactor;
		this.offset = offset;
		this.commsrcid = commsrcid;
		this.commpointid = commpointid;
		this.isperiodstatic = isperiodstatic;
		this.uppervalue = uppervalue;
		this.maxval = maxval;
		this.minval = minval;
		this.analogid = analogid;
		this.incrementvalue = incrementvalue;
		this.origin = origin;
		this.relativepower = relativepower;
		this.amountvalue = amountvalue;
		this.totalvalue = totalvalue;
		this.deleteflag = deleteflag;
		this.family = family;
		this.lockflag = lockflag;
		this.prohibitAlarm = prohibitAlarm;
		this.saveflag = saveflag;
		this.datatransflag = datatransflag;
		this.pathref = pathref;
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

	@Column(name = "SAVETIMERID")

	public Integer getSavetimerid() {
		return this.savetimerid;
	}

	public void setSavetimerid(Integer savetimerid) {
		this.savetimerid = savetimerid;
	}

	@Column(name = "MEASTYPEID")

	public Integer getMeastypeid() {
		return this.meastypeid;
	}

	public void setMeastypeid(Integer meastypeid) {
		this.meastypeid = meastypeid;
	}

	@Column(name = "MEASUNITID")

	public Integer getMeasunitid() {
		return this.measunitid;
	}

	public void setMeasunitid(Integer measunitid) {
		this.measunitid = measunitid;
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

	@Column(name = "SIGNALTYPE")

	public Integer getSignaltype() {
		return this.signaltype;
	}

	public void setSignaltype(Integer signaltype) {
		this.signaltype = signaltype;
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

	@Column(name = "ISPERIODSTATIC")

	public Integer getIsperiodstatic() {
		return this.isperiodstatic;
	}

	public void setIsperiodstatic(Integer isperiodstatic) {
		this.isperiodstatic = isperiodstatic;
	}

	@Column(name = "UPPERVALUE", precision = 22, scale = 0)

	public Double getUppervalue() {
		return this.uppervalue;
	}

	public void setUppervalue(Double uppervalue) {
		this.uppervalue = uppervalue;
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

	@Column(name = "ANALOGID")

	public Integer getAnalogid() {
		return this.analogid;
	}

	public void setAnalogid(Integer analogid) {
		this.analogid = analogid;
	}

	@Column(name = "INCREMENTVALUE", precision = 22, scale = 0)

	public Double getIncrementvalue() {
		return this.incrementvalue;
	}

	public void setIncrementvalue(Double incrementvalue) {
		this.incrementvalue = incrementvalue;
	}

	@Column(name = "ORIGIN")

	public Integer getOrigin() {
		return this.origin;
	}

	public void setOrigin(Integer origin) {
		this.origin = origin;
	}

	@Column(name = "RELATIVEPOWER", precision = 22, scale = 0)

	public Double getRelativepower() {
		return this.relativepower;
	}

	public void setRelativepower(Double relativepower) {
		this.relativepower = relativepower;
	}

	@Column(name = "AMOUNTVALUE", precision = 22, scale = 0)

	public Double getAmountvalue() {
		return this.amountvalue;
	}

	public void setAmountvalue(Double amountvalue) {
		this.amountvalue = amountvalue;
	}

	@Column(name = "TOTALVALUE", precision = 22, scale = 0)

	public Double getTotalvalue() {
		return this.totalvalue;
	}

	public void setTotalvalue(Double totalvalue) {
		this.totalvalue = totalvalue;
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

	@Column(name = "SAVEFLAG")

	public Integer getSaveflag() {
		return this.saveflag;
	}

	public void setSaveflag(Integer saveflag) {
		this.saveflag = saveflag;
	}

	@Column(name = "DATATRANSFLAG")

	public Integer getDatatransflag() {
		return this.datatransflag;
	}

	public void setDatatransflag(Integer datatransflag) {
		this.datatransflag = datatransflag;
	}

	@Column(name = "PATHREF", length = 64)

	public String getPathref() {
		return this.pathref;
	}

	public void setPathref(String pathref) {
		this.pathref = pathref;
	}

}
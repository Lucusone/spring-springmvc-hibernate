package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Exprcal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "exprcal", catalog = "e8000")

public class Exprcal implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer calvaltypeid;
	private Integer caltimerid;
	private Integer priority;
	private Integer calenable;
	private String family;
	private String formula;
	private Integer dataclassid;
	private Integer deleteflag;

	// Constructors

	/** default constructor */
	public Exprcal() {
	}

	/** minimal constructor */
	public Exprcal(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public Exprcal(Integer id, String name, Integer calvaltypeid, Integer caltimerid, Integer priority,
			Integer calenable, String family, String formula, Integer dataclassid, Integer deleteflag) {
		this.id = id;
		this.name = name;
		this.calvaltypeid = calvaltypeid;
		this.caltimerid = caltimerid;
		this.priority = priority;
		this.calenable = calenable;
		this.family = family;
		this.formula = formula;
		this.dataclassid = dataclassid;
		this.deleteflag = deleteflag;
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

	@Column(name = "NAME", nullable = false, length = 128)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "CALVALTYPEID")

	public Integer getCalvaltypeid() {
		return this.calvaltypeid;
	}

	public void setCalvaltypeid(Integer calvaltypeid) {
		this.calvaltypeid = calvaltypeid;
	}

	@Column(name = "CALTIMERID")

	public Integer getCaltimerid() {
		return this.caltimerid;
	}

	public void setCaltimerid(Integer caltimerid) {
		this.caltimerid = caltimerid;
	}

	@Column(name = "PRIORITY")

	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Column(name = "CALENABLE")

	public Integer getCalenable() {
		return this.calenable;
	}

	public void setCalenable(Integer calenable) {
		this.calenable = calenable;
	}

	@Column(name = "FAMILY", length = 64)

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Column(name = "FORMULA")

	public String getFormula() {
		return this.formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	@Column(name = "DATACLASSID")

	public Integer getDataclassid() {
		return this.dataclassid;
	}

	public void setDataclassid(Integer dataclassid) {
		this.dataclassid = dataclassid;
	}

	@Column(name = "DELETEFLAG")

	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

}
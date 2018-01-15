package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Equipmeastype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "equipmeastype", catalog = "e8000")

public class Equipmeastype implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer meastypeid;
	private Integer equipclassid;
	private Integer defselect;
	private Integer defproflag;

	// Constructors

	/** default constructor */
	public Equipmeastype() {
	}

	/** minimal constructor */
	public Equipmeastype(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Equipmeastype(Integer id, Integer meastypeid, Integer equipclassid, Integer defselect, Integer defproflag) {
		this.id = id;
		this.meastypeid = meastypeid;
		this.equipclassid = equipclassid;
		this.defselect = defselect;
		this.defproflag = defproflag;
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

	@Column(name = "MEASTYPEID")

	public Integer getMeastypeid() {
		return this.meastypeid;
	}

	public void setMeastypeid(Integer meastypeid) {
		this.meastypeid = meastypeid;
	}

	@Column(name = "EQUIPCLASSID")

	public Integer getEquipclassid() {
		return this.equipclassid;
	}

	public void setEquipclassid(Integer equipclassid) {
		this.equipclassid = equipclassid;
	}

	@Column(name = "DEFSELECT")

	public Integer getDefselect() {
		return this.defselect;
	}

	public void setDefselect(Integer defselect) {
		this.defselect = defselect;
	}

	@Column(name = "DEFPROFLAG")

	public Integer getDefproflag() {
		return this.defproflag;
	}

	public void setDefproflag(Integer defproflag) {
		this.defproflag = defproflag;
	}

}
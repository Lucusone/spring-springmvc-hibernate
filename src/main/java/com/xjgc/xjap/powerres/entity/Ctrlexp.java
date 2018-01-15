package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ctrlexp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ctrlexp", catalog = "e8000")

public class Ctrlexp implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer ctrlvaltypeid;
	private Integer controlid;
	private String opexprcal;
	private Integer deleteflag;

	// Constructors

	/** default constructor */
	public Ctrlexp() {
	}

	/** minimal constructor */
	public Ctrlexp(Integer id, Integer ctrlvaltypeid, Integer controlid) {
		this.id = id;
		this.ctrlvaltypeid = ctrlvaltypeid;
		this.controlid = controlid;
	}

	/** full constructor */
	public Ctrlexp(Integer id, Integer ctrlvaltypeid, Integer controlid, String opexprcal, Integer deleteflag) {
		this.id = id;
		this.ctrlvaltypeid = ctrlvaltypeid;
		this.controlid = controlid;
		this.opexprcal = opexprcal;
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

	@Column(name = "CTRLVALTYPEID", nullable = false)

	public Integer getCtrlvaltypeid() {
		return this.ctrlvaltypeid;
	}

	public void setCtrlvaltypeid(Integer ctrlvaltypeid) {
		this.ctrlvaltypeid = ctrlvaltypeid;
	}

	@Column(name = "CONTROLID", nullable = false)

	public Integer getControlid() {
		return this.controlid;
	}

	public void setControlid(Integer controlid) {
		this.controlid = controlid;
	}

	@Column(name = "OPEXPRCAL")

	public String getOpexprcal() {
		return this.opexprcal;
	}

	public void setOpexprcal(String opexprcal) {
		this.opexprcal = opexprcal;
	}

	@Column(name = "DELETEFLAG")

	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

}
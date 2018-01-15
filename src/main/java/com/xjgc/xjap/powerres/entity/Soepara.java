package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Soepara entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "soepara", catalog = "e8000")

public class Soepara implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer soevalid;
	private Integer unitid;
	private Integer stvalid;
	private Integer seqno;
	private String name;
	private String description;
	private Integer datatype;
	private Integer meastypeid;

	// Constructors

	/** default constructor */
	public Soepara() {
	}

	/** minimal constructor */
	public Soepara(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Soepara(Integer id, Integer soevalid, Integer unitid, Integer stvalid, Integer seqno, String name,
			String description, Integer datatype, Integer meastypeid) {
		this.id = id;
		this.soevalid = soevalid;
		this.unitid = unitid;
		this.stvalid = stvalid;
		this.seqno = seqno;
		this.name = name;
		this.description = description;
		this.datatype = datatype;
		this.meastypeid = meastypeid;
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

	@Column(name = "SOEVALID")

	public Integer getSoevalid() {
		return this.soevalid;
	}

	public void setSoevalid(Integer soevalid) {
		this.soevalid = soevalid;
	}

	@Column(name = "UNITID")

	public Integer getUnitid() {
		return this.unitid;
	}

	public void setUnitid(Integer unitid) {
		this.unitid = unitid;
	}

	@Column(name = "STVALID")

	public Integer getStvalid() {
		return this.stvalid;
	}

	public void setStvalid(Integer stvalid) {
		this.stvalid = stvalid;
	}

	@Column(name = "SEQNO")

	public Integer getSeqno() {
		return this.seqno;
	}

	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}

	@Column(name = "NAME", length = 16)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", length = 64)

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "DATATYPE")

	public Integer getDatatype() {
		return this.datatype;
	}

	public void setDatatype(Integer datatype) {
		this.datatype = datatype;
	}

	@Column(name = "MEASTYPEID")

	public Integer getMeastypeid() {
		return this.meastypeid;
	}

	public void setMeastypeid(Integer meastypeid) {
		this.meastypeid = meastypeid;
	}

}
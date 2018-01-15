package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Stvaltype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "stvaltype", catalog = "e8000")

public class Stvaltype implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer meastypeid;
	private String name;
	private Integer value;
	private String description;
	private Integer ctrlalarmid;
	private Integer faultalarmid;

	// Constructors

	/** default constructor */
	public Stvaltype() {
	}

	/** minimal constructor */
	public Stvaltype(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Stvaltype(Integer id, Integer meastypeid, String name, Integer value, String description,
			Integer ctrlalarmid, Integer faultalarmid) {
		this.id = id;
		this.meastypeid = meastypeid;
		this.name = name;
		this.value = value;
		this.description = description;
		this.ctrlalarmid = ctrlalarmid;
		this.faultalarmid = faultalarmid;
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

	@Column(name = "NAME", length = 64)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "VALUE")

	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Column(name = "DESCRIPTION", length = 64)

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "CTRLALARMID")

	public Integer getCtrlalarmid() {
		return this.ctrlalarmid;
	}

	public void setCtrlalarmid(Integer ctrlalarmid) {
		this.ctrlalarmid = ctrlalarmid;
	}

	@Column(name = "FAULTALARMID")

	public Integer getFaultalarmid() {
		return this.faultalarmid;
	}

	public void setFaultalarmid(Integer faultalarmid) {
		this.faultalarmid = faultalarmid;
	}

}
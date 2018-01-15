package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Measclass entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "measclass", catalog = "e8000")

public class Measclass implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer daclassid;
	private String name;
	private String code;

	// Constructors

	/** default constructor */
	public Measclass() {
	}

	/** minimal constructor */
	public Measclass(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Measclass(Integer id, Integer daclassid, String name, String code) {
		this.id = id;
		this.daclassid = daclassid;
		this.name = name;
		this.code = code;
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

	@Column(name = "DACLASSID")

	public Integer getDaclassid() {
		return this.daclassid;
	}

	public void setDaclassid(Integer daclassid) {
		this.daclassid = daclassid;
	}

	@Column(name = "NAME", length = 128)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "CODE", length = 16)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
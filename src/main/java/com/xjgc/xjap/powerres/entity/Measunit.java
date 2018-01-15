package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Measunit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "measunit", catalog = "e8000")

public class Measunit implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer measclassid;
	private String name;
	private String code;

	// Constructors

	/** default constructor */
	public Measunit() {
	}

	/** minimal constructor */
	public Measunit(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Measunit(Integer id, Integer measclassid, String name, String code) {
		this.id = id;
		this.measclassid = measclassid;
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

	@Column(name = "MEASCLASSID")

	public Integer getMeasclassid() {
		return this.measclassid;
	}

	public void setMeasclassid(Integer measclassid) {
		this.measclassid = measclassid;
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
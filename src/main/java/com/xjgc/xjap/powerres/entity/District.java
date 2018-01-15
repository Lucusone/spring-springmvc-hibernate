package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * District entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "district", catalog = "e8000")

public class District implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String code;
	private Integer companyid;
	private Integer parentdistrictid;

	// Constructors

	/** default constructor */
	public District() {
	}

	/** minimal constructor */
	public District(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public District(Integer id, String name, String code, Integer companyid, Integer parentdistrictid) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.companyid = companyid;
		this.parentdistrictid = parentdistrictid;
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

	@Column(name = "CODE", length = 16)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "COMPANYID")

	public Integer getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	@Column(name = "PARENTDISTRICTID")

	public Integer getParentdistrictid() {
		return this.parentdistrictid;
	}

	public void setParentdistrictid(Integer parentdistrictid) {
		this.parentdistrictid = parentdistrictid;
	}

}
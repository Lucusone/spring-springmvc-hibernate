package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Equiptype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "equiptype", catalog = "e8000")

public class Equiptype implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer equipclassid;
	private String name;
	private String code;

	// Constructors

	/** default constructor */
	public Equiptype() {
	}

	/** minimal constructor */
	public Equiptype(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Equiptype(Integer id, Integer equipclassid, String name, String code) {
		this.id = id;
		this.equipclassid = equipclassid;
		this.name = name;
		this.code = code;
	}

	// Property accessors
	@Id

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "equipclassid")

	public Integer getEquipclassid() {
		return this.equipclassid;
	}

	public void setEquipclassid(Integer equipclassid) {
		this.equipclassid = equipclassid;
	}

	@Column(name = "name", length = 128)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "code", length = 16)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
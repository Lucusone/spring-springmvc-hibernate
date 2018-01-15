package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Dataclass entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dataclass", catalog = "e8000")

public class Dataclass implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String code;

	// Constructors

	/** default constructor */
	public Dataclass() {
	}

	/** minimal constructor */
	public Dataclass(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Dataclass(Integer id, String name, String code) {
		this.id = id;
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

	@Column(name = "NAME", length = 16)

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
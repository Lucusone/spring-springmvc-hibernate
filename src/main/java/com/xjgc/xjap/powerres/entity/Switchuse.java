package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Switchuse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "switchuse", catalog = "e8000")

public class Switchuse implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;

	// Constructors

	/** default constructor */
	public Switchuse() {
	}

	/** minimal constructor */
	public Switchuse(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Switchuse(Integer id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
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

	@Column(name = "code", length = 16)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", length = 32)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
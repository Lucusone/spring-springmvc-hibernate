package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Family entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "family", catalog = "e8000")

public class Family implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;

	// Constructors

	/** default constructor */
	public Family() {
	}

	/** minimal constructor */
	public Family(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Family(Integer id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
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

	@Column(name = "CODE", length = 8)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "NAME", length = 128)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
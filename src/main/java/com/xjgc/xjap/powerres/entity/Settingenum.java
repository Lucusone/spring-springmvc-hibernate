package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Settingenum entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "settingenum", catalog = "e8000")

public class Settingenum implements java.io.Serializable {

	// Fields

	private Integer id;
	private String value;
	private String description;
	private String name;

	// Constructors

	/** default constructor */
	public Settingenum() {
	}

	/** minimal constructor */
	public Settingenum(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Settingenum(Integer id, String value, String description, String name) {
		this.id = id;
		this.value = value;
		this.description = description;
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

	@Column(name = "VALUE", length = 64)

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "DESCRIPTION", length = 64)

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "NAME", length = 128)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
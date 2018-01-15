package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Equippos entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "equippos", catalog = "e8000")

public class Equippos implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;

	// Constructors

	/** default constructor */
	public Equippos() {
	}

	/** minimal constructor */
	public Equippos(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Equippos(Integer id, String name) {
		this.id = id;
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

	@Column(name = "NAME", length = 128)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
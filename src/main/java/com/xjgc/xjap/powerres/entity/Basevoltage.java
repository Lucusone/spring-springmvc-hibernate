package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Basevoltage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "basevoltage", catalog = "e8000")

public class Basevoltage implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private Float nomvol;
	private Integer vlcolor;

	// Constructors

	/** default constructor */
	public Basevoltage() {
	}

	/** minimal constructor */
	public Basevoltage(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Basevoltage(Integer id, String code, String name, Float nomvol, Integer vlcolor) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.nomvol = nomvol;
		this.vlcolor = vlcolor;
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

	@Column(name = "nomvol", precision = 12, scale = 0)

	public Float getNomvol() {
		return this.nomvol;
	}

	public void setNomvol(Float nomvol) {
		this.nomvol = nomvol;
	}

	@Column(name = "vlcolor")

	public Integer getVlcolor() {
		return this.vlcolor;
	}

	public void setVlcolor(Integer vlcolor) {
		this.vlcolor = vlcolor;
	}

}
package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Equipclass entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "equipclass", catalog = "e8000")

public class Equipclass implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private String tablename;

	// Constructors

	/** default constructor */
	public Equipclass() {
	}

	/** minimal constructor */
	public Equipclass(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Equipclass(Integer id, String code, String name, String tablename) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.tablename = tablename;
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

	@Column(name = "code", length = 32)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", length = 64)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "tablename", length = 32)

	public String getTablename() {
		return this.tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

}
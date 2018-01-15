package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Alarmclass entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "alarmclass", catalog = "e8000")

public class Alarmclass implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer appid;
	private String name;
	private String description;

	// Constructors

	/** default constructor */
	public Alarmclass() {
	}

	/** minimal constructor */
	public Alarmclass(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Alarmclass(Integer id, Integer appid, String name, String description) {
		this.id = id;
		this.appid = appid;
		this.name = name;
		this.description = description;
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

	@Column(name = "APPID")

	public Integer getAppid() {
		return this.appid;
	}

	public void setAppid(Integer appid) {
		this.appid = appid;
	}

	@Column(name = "NAME", length = 128)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", length = 64)

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
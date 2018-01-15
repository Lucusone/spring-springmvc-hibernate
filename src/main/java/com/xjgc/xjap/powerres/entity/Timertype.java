package com.xjgc.xjap.powerres.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Timertype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "timertype", catalog = "e8000")

public class Timertype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer cycmode;
	private Integer cycspan;
	private Timestamp starttime;

	// Constructors

	/** default constructor */
	public Timertype() {
	}

	/** minimal constructor */
	public Timertype(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Timertype(Integer id, String name, Integer cycmode, Integer cycspan, Timestamp starttime) {
		this.id = id;
		this.name = name;
		this.cycmode = cycmode;
		this.cycspan = cycspan;
		this.starttime = starttime;
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

	@Column(name = "NAME", length = 32)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "CYCMODE")

	public Integer getCycmode() {
		return this.cycmode;
	}

	public void setCycmode(Integer cycmode) {
		this.cycmode = cycmode;
	}

	@Column(name = "CYCSPAN")

	public Integer getCycspan() {
		return this.cycspan;
	}

	public void setCycspan(Integer cycspan) {
		this.cycspan = cycspan;
	}

	@Column(name = "STARTTIME", length = 19)

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

}
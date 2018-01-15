package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Voltagelevel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "voltagelevel", catalog = "e8000")

public class Voltagelevel implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private Integer stationId;
	private Integer baseVoltageId;

	// Constructors

	/** default constructor */
	public Voltagelevel() {
	}

	/** minimal constructor */
	public Voltagelevel(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Voltagelevel(Integer id, String code, String name, Integer stationId, Integer baseVoltageId) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.stationId = stationId;
		this.baseVoltageId = baseVoltageId;
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

	@Column(name = "stationID")

	public Integer getStationId() {
		return this.stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	@Column(name = "baseVoltageID")

	public Integer getBaseVoltageId() {
		return this.baseVoltageId;
	}

	public void setBaseVoltageId(Integer baseVoltageId) {
		this.baseVoltageId = baseVoltageId;
	}

}
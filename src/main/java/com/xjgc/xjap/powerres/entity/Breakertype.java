package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Breakertype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "breakertype", catalog = "e8000")

public class Breakertype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private String description;
	private Double breakingCapacity;
	private Integer maxBwNum;
	private Integer maxSgbwNum;
	private Integer doublesatus;
	private Integer dpsdelay;
	private Integer triphaseDelay;

	// Constructors

	/** default constructor */
	public Breakertype() {
	}

	/** minimal constructor */
	public Breakertype(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Breakertype(Integer id, String code, String name, String description, Double breakingCapacity,
			Integer maxBwNum, Integer maxSgbwNum, Integer doublesatus, Integer dpsdelay, Integer triphaseDelay) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.breakingCapacity = breakingCapacity;
		this.maxBwNum = maxBwNum;
		this.maxSgbwNum = maxSgbwNum;
		this.doublesatus = doublesatus;
		this.dpsdelay = dpsdelay;
		this.triphaseDelay = triphaseDelay;
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

	@Column(name = "description", length = 64)

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "breakingCapacity", precision = 22, scale = 0)

	public Double getBreakingCapacity() {
		return this.breakingCapacity;
	}

	public void setBreakingCapacity(Double breakingCapacity) {
		this.breakingCapacity = breakingCapacity;
	}

	@Column(name = "maxBwNum")

	public Integer getMaxBwNum() {
		return this.maxBwNum;
	}

	public void setMaxBwNum(Integer maxBwNum) {
		this.maxBwNum = maxBwNum;
	}

	@Column(name = "maxSgbwNum")

	public Integer getMaxSgbwNum() {
		return this.maxSgbwNum;
	}

	public void setMaxSgbwNum(Integer maxSgbwNum) {
		this.maxSgbwNum = maxSgbwNum;
	}

	@Column(name = "doublesatus")

	public Integer getDoublesatus() {
		return this.doublesatus;
	}

	public void setDoublesatus(Integer doublesatus) {
		this.doublesatus = doublesatus;
	}

	@Column(name = "DPSDelay")

	public Integer getDpsdelay() {
		return this.dpsdelay;
	}

	public void setDpsdelay(Integer dpsdelay) {
		this.dpsdelay = dpsdelay;
	}

	@Column(name = "triphaseDelay")

	public Integer getTriphaseDelay() {
		return this.triphaseDelay;
	}

	public void setTriphaseDelay(Integer triphaseDelay) {
		this.triphaseDelay = triphaseDelay;
	}

}
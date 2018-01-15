package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Aclinesegmenttype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "aclinesegmenttype", catalog = "e8000")

public class Aclinesegmenttype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private String description;
	private Double ratedMw;
	private Double ratedCurrent;
	private Double dr;
	private Double dx;

	// Constructors

	/** default constructor */
	public Aclinesegmenttype() {
	}

	/** minimal constructor */
	public Aclinesegmenttype(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Aclinesegmenttype(Integer id, String code, String name, String description, Double ratedMw,
			Double ratedCurrent, Double dr, Double dx) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.ratedMw = ratedMw;
		this.ratedCurrent = ratedCurrent;
		this.dr = dr;
		this.dx = dx;
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

	@Column(name = "description", length = 32)

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "RatedMW", precision = 22, scale = 0)

	public Double getRatedMw() {
		return this.ratedMw;
	}

	public void setRatedMw(Double ratedMw) {
		this.ratedMw = ratedMw;
	}

	@Column(name = "ratedCurrent", precision = 22, scale = 0)

	public Double getRatedCurrent() {
		return this.ratedCurrent;
	}

	public void setRatedCurrent(Double ratedCurrent) {
		this.ratedCurrent = ratedCurrent;
	}

	@Column(name = "dR", precision = 22, scale = 0)

	public Double getDr() {
		return this.dr;
	}

	public void setDr(Double dr) {
		this.dr = dr;
	}

	@Column(name = "dX", precision = 22, scale = 0)

	public Double getDx() {
		return this.dx;
	}

	public void setDx(Double dx) {
		this.dx = dx;
	}

}
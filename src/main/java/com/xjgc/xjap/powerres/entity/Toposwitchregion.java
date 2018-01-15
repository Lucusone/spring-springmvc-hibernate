package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Toposwitchregion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "toposwitchregion", catalog = "e8000")

public class Toposwitchregion implements java.io.Serializable {

	// Fields

	private Integer id;
	private String swObject;
	private Integer topoRegion1;
	private Integer topoRegion2;

	// Constructors

	/** default constructor */
	public Toposwitchregion() {
	}

	/** full constructor */
	public Toposwitchregion(String swObject, Integer topoRegion1, Integer topoRegion2) {
		this.swObject = swObject;
		this.topoRegion1 = topoRegion1;
		this.topoRegion2 = topoRegion2;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "swObject", length = 16)

	public String getSwObject() {
		return this.swObject;
	}

	public void setSwObject(String swObject) {
		this.swObject = swObject;
	}

	@Column(name = "TopoRegion1")

	public Integer getTopoRegion1() {
		return this.topoRegion1;
	}

	public void setTopoRegion1(Integer topoRegion1) {
		this.topoRegion1 = topoRegion1;
	}

	@Column(name = "TopoRegion2")

	public Integer getTopoRegion2() {
		return this.topoRegion2;
	}

	public void setTopoRegion2(Integer topoRegion2) {
		this.topoRegion2 = topoRegion2;
	}

}
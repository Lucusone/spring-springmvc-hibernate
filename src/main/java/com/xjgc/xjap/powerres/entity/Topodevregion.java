package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Topodevregion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "topodevregion", catalog = "e8000")

public class Topodevregion implements java.io.Serializable {

	// Fields

	private Integer id;
	private String devObject;
	private Integer topoRegion;

	// Constructors

	/** default constructor */
	public Topodevregion() {
	}

	/** full constructor */
	public Topodevregion(String devObject, Integer topoRegion) {
		this.devObject = devObject;
		this.topoRegion = topoRegion;
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

	@Column(name = "devObject", length = 16)

	public String getDevObject() {
		return this.devObject;
	}

	public void setDevObject(String devObject) {
		this.devObject = devObject;
	}

	@Column(name = "TopoRegion")

	public Integer getTopoRegion() {
		return this.topoRegion;
	}

	public void setTopoRegion(Integer topoRegion) {
		this.topoRegion = topoRegion;
	}

}
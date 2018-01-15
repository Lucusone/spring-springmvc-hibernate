package com.xjgc.xjap.powerres.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Viewpage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "viewpage", catalog = "e8000")

public class Viewpage implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private Timestamp savetime;
	private Integer releasestatus;
	private Integer pagetypeid;
	private Integer objectid;
	private String pagedata;

	// Constructors

	/** default constructor */
	public Viewpage() {
	}

	/** minimal constructor */
	public Viewpage(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Viewpage(Integer id, String name, String description, Timestamp savetime, Integer releasestatus,
			Integer pagetypeid, Integer objectid, String pagedata) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.savetime = savetime;
		this.releasestatus = releasestatus;
		this.pagetypeid = pagetypeid;
		this.objectid = objectid;
		this.pagedata = pagedata;
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

	@Column(name = "savetime", length = 19)

	public Timestamp getSavetime() {
		return this.savetime;
	}

	public void setSavetime(Timestamp savetime) {
		this.savetime = savetime;
	}

	@Column(name = "releasestatus")

	public Integer getReleasestatus() {
		return this.releasestatus;
	}

	public void setReleasestatus(Integer releasestatus) {
		this.releasestatus = releasestatus;
	}

	@Column(name = "pagetypeid")

	public Integer getPagetypeid() {
		return this.pagetypeid;
	}

	public void setPagetypeid(Integer pagetypeid) {
		this.pagetypeid = pagetypeid;
	}

	@Column(name = "objectid")

	public Integer getObjectid() {
		return this.objectid;
	}

	public void setObjectid(Integer objectid) {
		this.objectid = objectid;
	}

	@Column(name = "pagedata")

	public String getPagedata() {
		return this.pagedata;
	}

	public void setPagedata(String pagedata) {
		this.pagedata = pagedata;
	}

}
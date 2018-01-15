package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tagtype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tagtype", catalog = "e8000")

public class Tagtype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private String description;
	private Integer proflag;
	private String picturepath;
	private String mutexTag;

	// Constructors

	/** default constructor */
	public Tagtype() {
	}

	/** minimal constructor */
	public Tagtype(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Tagtype(Integer id, String code, String name, String description, Integer proflag, String picturepath,
			String mutexTag) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.proflag = proflag;
		this.picturepath = picturepath;
		this.mutexTag = mutexTag;
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

	@Column(name = "NAME", length = 32)

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

	@Column(name = "PROFLAG")

	public Integer getProflag() {
		return this.proflag;
	}

	public void setProflag(Integer proflag) {
		this.proflag = proflag;
	}

	@Column(name = "PICTUREPATH", length = 64)

	public String getPicturepath() {
		return this.picturepath;
	}

	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}

	@Column(name = "MutexTag", length = 64)

	public String getMutexTag() {
		return this.mutexTag;
	}

	public void setMutexTag(String mutexTag) {
		this.mutexTag = mutexTag;
	}

}
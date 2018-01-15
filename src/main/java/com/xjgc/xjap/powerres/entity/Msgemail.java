package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Msgemail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "msgemail", catalog = "e8000")

public class Msgemail implements java.io.Serializable {

	// Fields

	private Integer id;
	private String emailuser;
	private String emailaddress;

	// Constructors

	/** default constructor */
	public Msgemail() {
	}

	/** minimal constructor */
	public Msgemail(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Msgemail(Integer id, String emailuser, String emailaddress) {
		this.id = id;
		this.emailuser = emailuser;
		this.emailaddress = emailaddress;
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

	@Column(name = "EMAILUSER", length = 128)

	public String getEmailuser() {
		return this.emailuser;
	}

	public void setEmailuser(String emailuser) {
		this.emailuser = emailuser;
	}

	@Column(name = "EMAILADDRESS", length = 64)

	public String getEmailaddress() {
		return this.emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

}
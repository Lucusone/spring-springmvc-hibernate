package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Alarmuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "alarmuser", catalog = "e8000")

public class Alarmuser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String phonenum;
	private String emailaddress;

	// Constructors

	/** default constructor */
	public Alarmuser() {
	}

	/** minimal constructor */
	public Alarmuser(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Alarmuser(Integer id, String username, String phonenum, String emailaddress) {
		this.id = id;
		this.username = username;
		this.phonenum = phonenum;
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

	@Column(name = "USERNAME", length = 128)

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PHONENUM", length = 32)

	public String getPhonenum() {
		return this.phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	@Column(name = "EMAILADDRESS", length = 64)

	public String getEmailaddress() {
		return this.emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

}
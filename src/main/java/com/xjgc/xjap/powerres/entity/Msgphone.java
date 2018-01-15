package com.xjgc.xjap.powerres.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Msgphone entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "msgphone", catalog = "e8000")

public class Msgphone implements java.io.Serializable {

	// Fields

	private Integer id;
	private String phoneuser;
	private String phonenum;
	private Set<Alarmphone> alarmphones = new HashSet<Alarmphone>(0);

	// Constructors

	/** default constructor */
	public Msgphone() {
	}

	/** minimal constructor */
	public Msgphone(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Msgphone(Integer id, String phoneuser, String phonenum, Set<Alarmphone> alarmphones) {
		this.id = id;
		this.phoneuser = phoneuser;
		this.phonenum = phonenum;
		this.alarmphones = alarmphones;
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

	@Column(name = "PHONEUSER", length = 128)

	public String getPhoneuser() {
		return this.phoneuser;
	}

	public void setPhoneuser(String phoneuser) {
		this.phoneuser = phoneuser;
	}

	@Column(name = "PHONENUM", length = 128)

	public String getPhonenum() {
		return this.phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "msgphone")

	public Set<Alarmphone> getAlarmphones() {
		return this.alarmphones;
	}

	public void setAlarmphones(Set<Alarmphone> alarmphones) {
		this.alarmphones = alarmphones;
	}

}
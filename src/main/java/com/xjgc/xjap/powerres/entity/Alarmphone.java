package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Alarmphone entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "alarmphone", catalog = "e8000")

public class Alarmphone implements java.io.Serializable {

	// Fields

	private Integer id;
	private Alarm alarm;
	private Msgphone msgphone;

	// Constructors

	/** default constructor */
	public Alarmphone() {
	}

	/** full constructor */
	public Alarmphone(Integer id, Alarm alarm, Msgphone msgphone) {
		this.id = id;
		this.alarm = alarm;
		this.msgphone = msgphone;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALARMID", nullable = false)

	public Alarm getAlarm() {
		return this.alarm;
	}

	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MSGPHONEID", nullable = false)

	public Msgphone getMsgphone() {
		return this.msgphone;
	}

	public void setMsgphone(Msgphone msgphone) {
		this.msgphone = msgphone;
	}

}
package com.xjgc.xjap.powerres.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Settingarea entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "settingarea", catalog = "e8000")

public class Settingarea implements java.io.Serializable {

	// Fields

	private Integer id;
	private Setting setting;
	private Integer settingarea;
	private String settingvalue;
	private Timestamp curdatatime;
	private Integer deleteflag;

	// Constructors

	/** default constructor */
	public Settingarea() {
	}

	/** minimal constructor */
	public Settingarea(Integer id, Integer settingarea) {
		this.id = id;
		this.settingarea = settingarea;
	}

	/** full constructor */
	public Settingarea(Integer id, Setting setting, Integer settingarea, String settingvalue, Timestamp curdatatime,
			Integer deleteflag) {
		this.id = id;
		this.setting = setting;
		this.settingarea = settingarea;
		this.settingvalue = settingvalue;
		this.curdatatime = curdatatime;
		this.deleteflag = deleteflag;
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
	@JoinColumn(name = "SETTINGID")

	public Setting getSetting() {
		return this.setting;
	}

	public void setSetting(Setting setting) {
		this.setting = setting;
	}

	@Column(name = "SETTINGAREA", nullable = false)

	public Integer getSettingarea() {
		return this.settingarea;
	}

	public void setSettingarea(Integer settingarea) {
		this.settingarea = settingarea;
	}

	@Column(name = "SETTINGVALUE", length = 100)

	public String getSettingvalue() {
		return this.settingvalue;
	}

	public void setSettingvalue(String settingvalue) {
		this.settingvalue = settingvalue;
	}

	@Column(name = "CURDATATIME", length = 19)

	public Timestamp getCurdatatime() {
		return this.curdatatime;
	}

	public void setCurdatatime(Timestamp curdatatime) {
		this.curdatatime = curdatatime;
	}

	@Column(name = "DELETEFLAG")

	public Integer getDeleteflag() {
		return this.deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

}
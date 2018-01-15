package com.xjgc.xjap.powerres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Abrupttype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "abrupttype", catalog = "e8000")

public class Abrupttype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer isdiff;
	private Integer trend;
	private Double uplimit;
	private Double downlimit;
	private Double gradevalue;
	private Integer gradetimelmt;
	private Integer alarmlmt;
	private Integer delaytime;
	private Integer isfault;
	private Integer alarmact;

	// Constructors

	/** default constructor */
	public Abrupttype() {
	}

	/** minimal constructor */
	public Abrupttype(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Abrupttype(Integer id, String name, Integer isdiff, Integer trend, Double uplimit, Double downlimit,
			Double gradevalue, Integer gradetimelmt, Integer alarmlmt, Integer delaytime, Integer isfault,
			Integer alarmact) {
		this.id = id;
		this.name = name;
		this.isdiff = isdiff;
		this.trend = trend;
		this.uplimit = uplimit;
		this.downlimit = downlimit;
		this.gradevalue = gradevalue;
		this.gradetimelmt = gradetimelmt;
		this.alarmlmt = alarmlmt;
		this.delaytime = delaytime;
		this.isfault = isfault;
		this.alarmact = alarmact;
	}

	// Property accessors
	@Id

	@Column(name = "ID", unique = true, nullable = false, precision = 9, scale = 0)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 128)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ISDIFF")

	public Integer getIsdiff() {
		return this.isdiff;
	}

	public void setIsdiff(Integer isdiff) {
		this.isdiff = isdiff;
	}

	@Column(name = "TREND")

	public Integer getTrend() {
		return this.trend;
	}

	public void setTrend(Integer trend) {
		this.trend = trend;
	}

	@Column(name = "UPLIMIT", precision = 22, scale = 0)

	public Double getUplimit() {
		return this.uplimit;
	}

	public void setUplimit(Double uplimit) {
		this.uplimit = uplimit;
	}

	@Column(name = "DOWNLIMIT", precision = 22, scale = 0)

	public Double getDownlimit() {
		return this.downlimit;
	}

	public void setDownlimit(Double downlimit) {
		this.downlimit = downlimit;
	}

	@Column(name = "GRADEVALUE", precision = 22, scale = 0)

	public Double getGradevalue() {
		return this.gradevalue;
	}

	public void setGradevalue(Double gradevalue) {
		this.gradevalue = gradevalue;
	}

	@Column(name = "GRADETIMELMT")

	public Integer getGradetimelmt() {
		return this.gradetimelmt;
	}

	public void setGradetimelmt(Integer gradetimelmt) {
		this.gradetimelmt = gradetimelmt;
	}

	@Column(name = "ALARMLMT")

	public Integer getAlarmlmt() {
		return this.alarmlmt;
	}

	public void setAlarmlmt(Integer alarmlmt) {
		this.alarmlmt = alarmlmt;
	}

	@Column(name = "DELAYTIME")

	public Integer getDelaytime() {
		return this.delaytime;
	}

	public void setDelaytime(Integer delaytime) {
		this.delaytime = delaytime;
	}

	@Column(name = "ISFAULT")

	public Integer getIsfault() {
		return this.isfault;
	}

	public void setIsfault(Integer isfault) {
		this.isfault = isfault;
	}

	@Column(name = "ALARMACT")

	public Integer getAlarmact() {
		return this.alarmact;
	}

	public void setAlarmact(Integer alarmact) {
		this.alarmact = alarmact;
	}

}
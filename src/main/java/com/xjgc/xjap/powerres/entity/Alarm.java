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
 * Alarm entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "alarm", catalog = "e8000")

public class Alarm implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private Integer alarmlevelid;
	private Integer alarmclassid;
	private String alarmformat;
	private Integer autoconfirmtime;
	private Integer voicealarmtimes;
	private Integer priority;
	private String family;
	private Integer almopt;
	private String alarmpage;
	private String alarmvoice;
	private Integer userdefineflag;
	private Set<Alarmphone> alarmphones = new HashSet<Alarmphone>(0);

	// Constructors

	/** default constructor */
	public Alarm() {
	}

	/** minimal constructor */
	public Alarm(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Alarm(Integer id, String code, String name, Integer alarmlevelid, Integer alarmclassid, String alarmformat,
			Integer autoconfirmtime, Integer voicealarmtimes, Integer priority, String family, Integer almopt,
			String alarmpage, String alarmvoice, Integer userdefineflag, Set<Alarmphone> alarmphones) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.alarmlevelid = alarmlevelid;
		this.alarmclassid = alarmclassid;
		this.alarmformat = alarmformat;
		this.autoconfirmtime = autoconfirmtime;
		this.voicealarmtimes = voicealarmtimes;
		this.priority = priority;
		this.family = family;
		this.almopt = almopt;
		this.alarmpage = alarmpage;
		this.alarmvoice = alarmvoice;
		this.userdefineflag = userdefineflag;
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

	@Column(name = "CODE", length = 16)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "NAME", length = 128)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ALARMLEVELID")

	public Integer getAlarmlevelid() {
		return this.alarmlevelid;
	}

	public void setAlarmlevelid(Integer alarmlevelid) {
		this.alarmlevelid = alarmlevelid;
	}

	@Column(name = "ALARMCLASSID")

	public Integer getAlarmclassid() {
		return this.alarmclassid;
	}

	public void setAlarmclassid(Integer alarmclassid) {
		this.alarmclassid = alarmclassid;
	}

	@Column(name = "ALARMFORMAT")

	public String getAlarmformat() {
		return this.alarmformat;
	}

	public void setAlarmformat(String alarmformat) {
		this.alarmformat = alarmformat;
	}

	@Column(name = "AUTOCONFIRMTIME")

	public Integer getAutoconfirmtime() {
		return this.autoconfirmtime;
	}

	public void setAutoconfirmtime(Integer autoconfirmtime) {
		this.autoconfirmtime = autoconfirmtime;
	}

	@Column(name = "VOICEALARMTIMES")

	public Integer getVoicealarmtimes() {
		return this.voicealarmtimes;
	}

	public void setVoicealarmtimes(Integer voicealarmtimes) {
		this.voicealarmtimes = voicealarmtimes;
	}

	@Column(name = "PRIORITY")

	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Column(name = "FAMILY", length = 64)

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Column(name = "ALMOPT")

	public Integer getAlmopt() {
		return this.almopt;
	}

	public void setAlmopt(Integer almopt) {
		this.almopt = almopt;
	}

	@Column(name = "ALARMPAGE", length = 128)

	public String getAlarmpage() {
		return this.alarmpage;
	}

	public void setAlarmpage(String alarmpage) {
		this.alarmpage = alarmpage;
	}

	@Column(name = "ALARMVOICE", length = 128)

	public String getAlarmvoice() {
		return this.alarmvoice;
	}

	public void setAlarmvoice(String alarmvoice) {
		this.alarmvoice = alarmvoice;
	}

	@Column(name = "USERDEFINEFLAG")

	public Integer getUserdefineflag() {
		return this.userdefineflag;
	}

	public void setUserdefineflag(Integer userdefineflag) {
		this.userdefineflag = userdefineflag;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "alarm")

	public Set<Alarmphone> getAlarmphones() {
		return this.alarmphones;
	}

	public void setAlarmphones(Set<Alarmphone> alarmphones) {
		this.alarmphones = alarmphones;
	}

}
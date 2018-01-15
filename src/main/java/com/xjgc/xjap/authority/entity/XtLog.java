package com.xjgc.xjap.authority.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 类描�?:用户操作日志实体
 * XtLog entity. @author lucus
 */
@Entity
@Table(name = "xt_log")
public class XtLog implements Serializable {

	private static final long serialVersionUID = 1L;
	// Fields
	private String xtOplogid;
	private XtUser xtUser;
	private XtLogClass xtLogClass;
	private Timestamp xtOplogtime;
	private String xtOplogdescribe;
	private String xtOplogipaddress;
	private String xtOplogcomputer;

	// Property accessors
	@Id
	@Column(name = "XT_OPLOGID", unique = true, nullable = false, length = 32)
	public String getXtOplogid() {
		return this.xtOplogid;
	}

	public void setXtOplogid(String xtOplogid) {
		this.xtOplogid = xtOplogid;
	}

	@ManyToOne(targetEntity=XtUser.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public XtUser getXtUser() {
		return this.xtUser;
	}

	public void setXtUser(XtUser xtUser) {
		this.xtUser = xtUser;
	}

	@ManyToOne(targetEntity=XtLogClass.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "LOG_CLASS_ID")
	public XtLogClass getXtLogClass() {
		return this.xtLogClass;
	}

	public void setXtLogClass(XtLogClass xtLogClass) {
		this.xtLogClass = xtLogClass;
	}

	@Column(name = "XT_OPLOGTIME", nullable = true, length = 19)
	public Timestamp getXtOplogtime() {
		return this.xtOplogtime;
	}

	public void setXtOplogtime(Timestamp xtOplogtime) {
		this.xtOplogtime = xtOplogtime;
	}

	@Column(name = "XT_OPLOGDESCRIBE")
	public String getXtOplogdescribe() {
		return this.xtOplogdescribe;
	}

	public void setXtOplogdescribe(String xtOplogdescribe) {
		this.xtOplogdescribe = xtOplogdescribe;
	}

	@Column(name = "XT_OPLOGIPADDRESS", length = 25)
	public String getXtOplogipaddress() {
		return this.xtOplogipaddress;
	}

	public void setXtOplogipaddress(String xtOplogipaddress) {
		this.xtOplogipaddress = xtOplogipaddress;
	}

	@Column(name = "XT_OPLOGCOMPUTER", length = 20)
	public String getXtOplogcomputer() {
		return this.xtOplogcomputer;
	}

	public void setXtOplogcomputer(String xtOplogcomputer) {
		this.xtOplogcomputer = xtOplogcomputer;
	}
	
}
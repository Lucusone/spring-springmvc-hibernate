package com.xjgc.xjap.authority.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "xt_log_class")
public class XtLogClass implements Serializable{

	private static final long serialVersionUID = 1L;
	// Fields
	private String logClassId;
	private String logClassName;
	private List<XtLog> xtLogs = new ArrayList<XtLog>();

	// Constructors
	/** default constructor */
	public XtLogClass() {}

	/** minimal constructor */
	public XtLogClass(String logClassId) {
		this.logClassId = logClassId;
	}

	/** full constructor */
	public XtLogClass(String logClassId, String logClassName, List<XtLog> xtLogs) {
		this.logClassId = logClassId;
		this.logClassName = logClassName;
		this.xtLogs = xtLogs;
	}

	// Property accessors
	@Id
	@Column(name = "LOG_CLASS_ID", unique = true, nullable = false, length = 32)
	public String getLogClassId() {
		return this.logClassId;
	}

	public void setLogClassId(String logClassId) {
		this.logClassId = logClassId;
	}

	@Column(name = "LOG_CLASS_NAME", length = 32)
	public String getLogClassName() {
		return this.logClassName;
	}

	public void setLogClassName(String logClassName) {
		this.logClassName = logClassName;
	}

	@OneToMany(cascade = CascadeType.REMOVE, fetch=FetchType.LAZY , mappedBy = "xtLogClass")
	public List<XtLog> getXtLogs() {
		return this.xtLogs;
	}

	public void setXtLogs(List<XtLog> xtLogs) {
		this.xtLogs = xtLogs;
	}
	
}
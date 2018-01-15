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

/**
 * 类描�?: 操作
 * XtOperation entity. @author lucus
 */
@Entity
@Table(name = "xt_operation")
public class XtOperation implements Serializable {

	private static final long serialVersionUID = 1L;
	// Fields
	private String operId;
	private String operName;
	private List<XtPermAssign> xtPermAssigns = new ArrayList<XtPermAssign>();

	// Constructors
	/** default constructor */
	public XtOperation() {
	}

	/** minimal constructor */
	public XtOperation(String operId) {
		this.operId = operId;
	}

	/** full constructor */
	public XtOperation(String operId, String operName, List<XtPermAssign> xtPermAssigns) {
		this.operId = operId;
		this.operName = operName;
		this.xtPermAssigns = xtPermAssigns;
	}

	// Property accessors
	@Id
	@Column(name = "OPER_ID", unique = true, nullable = false, length = 32)
	public String getOperId() {
		return this.operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	@Column(name = "OPER_NAME", length = 64)
	public String getOperName() {
		return this.operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	@OneToMany(cascade = CascadeType.REMOVE,fetch=FetchType.LAZY, mappedBy = "xtOperation")
	public List<XtPermAssign> getXtPermAssigns() {
		return this.xtPermAssigns;
	}

	public void setXtPermAssigns(List<XtPermAssign> xtPermAssigns) {
		this.xtPermAssigns = xtPermAssigns;
	}

}
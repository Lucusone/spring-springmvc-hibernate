package com.xjgc.xjap.authority.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 权限
 * XtPermAssign entity. @author lucus
 */
@Entity
@Table(name = "xt_perm_assign")
public class XtPermAssign implements Serializable {

	private static final long serialVersionUID = 1L;
	// Fields
	private String permAssignId;
	private XtRole xtRole;
	private XtOperation xtOperation;
	private XtResource xtResource;

	// Constructors
	/** default constructor */
	public XtPermAssign() {
	}

	/** minimal constructor */
	public XtPermAssign(String permAssignId) {
		this.permAssignId = permAssignId;
	}

	/** full constructor */
	public XtPermAssign(String permAssignId, XtRole xtRole, XtOperation xtOperation, XtResource xtResource) {
		this.permAssignId = permAssignId;
		this.xtRole = xtRole;
		this.xtOperation = xtOperation;
		this.xtResource = xtResource;
	}

	// Property accessors
	@Id
	@Column(name = "PERM_ASSIGN_ID", unique = true, nullable = false, length = 32)
	public String getPermAssignId() {
		return this.permAssignId;
	}

	public void setPermAssignId(String permAssignId) {
		this.permAssignId = permAssignId;
	}

	@ManyToOne(targetEntity=XtRole.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID")
	public XtRole getXtRole() {
		return this.xtRole;
	}

	public void setXtRole(XtRole xtRole) {
		this.xtRole = xtRole;
	}

	@ManyToOne(targetEntity=XtOperation.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "OPER_ID")
	public XtOperation getXtOperation() {
		return this.xtOperation;
	}

	public void setXtOperation(XtOperation xtOperation) {
		this.xtOperation = xtOperation;
	}

	@ManyToOne(targetEntity=XtResource.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "RES_ID")
	public XtResource getXtResource() {
		return this.xtResource;
	}

	public void setXtResource(XtResource xtResource) {
		this.xtResource = xtResource;
	}

}
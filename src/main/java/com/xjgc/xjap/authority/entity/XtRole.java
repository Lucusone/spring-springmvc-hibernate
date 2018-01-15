package com.xjgc.xjap.authority.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "xt_role")
public class XtRole implements Serializable {

	private static final long serialVersionUID = 1L;
	// Fields
	private String roleId;
	private XtGroup xtGroup;
	private XtOrganization xtOrganization;
	private String roleName;
	private List<XtPermAssign> xtPermAssigns = new ArrayList<XtPermAssign>();
	private List<XtUserRole> xtUserRoles = new ArrayList<XtUserRole>();

	// Constructors
	/** default constructor */
	public XtRole() {
	}

	/** minimal constructor */
	public XtRole(String roleId, XtOrganization xtOrganization) {
		this.roleId = roleId;
		this.xtOrganization = xtOrganization;
	}

	/** full constructor */
	public XtRole(String roleId, XtGroup xtGroup, XtOrganization xtOrganization, String roleName,
			List<XtPermAssign> xtPermAssigns, List<XtUserRole> xtUserRoles) {
		this.roleId = roleId;
		this.xtGroup = xtGroup;
		this.xtOrganization = xtOrganization;
		this.roleName = roleName;
		this.xtPermAssigns = xtPermAssigns;
		this.xtUserRoles = xtUserRoles;
	}

	// Property accessors
	@Id
	@Column(name = "ROLE_ID", unique = true, nullable = false, length = 32)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	
	@ManyToOne(targetEntity=XtGroup.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "GROUP_ID")
	public XtGroup getXtGroup() {
		return this.xtGroup;
	}

	public void setXtGroup(XtGroup xtGroup) {
		this.xtGroup = xtGroup;
	}

	@ManyToOne(targetEntity=XtOrganization.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "ORG_ID", nullable = true)
	public XtOrganization getXtOrganization() {
		return this.xtOrganization;
	}

	public void setXtOrganization(XtOrganization xtOrganization) {
		this.xtOrganization = xtOrganization;
	}

	@Column(name = "ROLE_NAME", length = 20)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@OneToMany(cascade = CascadeType.REMOVE,fetch=FetchType.LAZY, mappedBy = "xtRole")
	public List<XtPermAssign> getXtPermAssigns() {
		return this.xtPermAssigns;
	}

	public void setXtPermAssigns(List<XtPermAssign> xtPermAssigns) {
		this.xtPermAssigns = xtPermAssigns;
	}

	@OneToMany(cascade = CascadeType.REMOVE,fetch=FetchType.LAZY, mappedBy = "xtRole")
	public List<XtUserRole> getXtUserRoles() {
		return this.xtUserRoles;
	}

	public void setXtUserRoles(List<XtUserRole> xtUserRoles) {
		this.xtUserRoles = xtUserRoles;
	}

}
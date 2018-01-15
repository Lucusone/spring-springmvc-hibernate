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

/**
 * 类描述：组实�?
 * XtGroup entity. @author lucus
 */
@Entity
@Table(name = "xt_group")
public class XtGroup implements Serializable{

	private static final long serialVersionUID = 1L;
	// Fields
	private String groupId;
	private XtOrganization xtOrganization;
	private String groupName;
	private List<XtRole> xtRoles = new ArrayList<XtRole>();
	private List<XtUser> xtUsers = new ArrayList<XtUser>();
	
	// Constructors
	/** default constructor */
	public XtGroup() {
	}

	/** minimal constructor */
	public XtGroup(String groupId) {
		this.groupId = groupId;
	}

	/** full constructor */
	public XtGroup(String groupId, XtOrganization xtOrganization, String groupName, List<XtRole> xtRoles,
			List<XtUser> xtUsers) {
		this.groupId = groupId;
		this.xtOrganization = xtOrganization;
		this.groupName = groupName;
		this.xtRoles = xtRoles;
		this.xtUsers = xtUsers;
	}

	// Property accessors
	@Id
	@Column(name = "GROUP_ID", unique = true, nullable = false, length = 32)
	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@ManyToOne(targetEntity=XtOrganization.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "ORG_ID")
	public XtOrganization getXtOrganization() {
		return this.xtOrganization;
	}

	public void setXtOrganization(XtOrganization xtOrganization) {
		this.xtOrganization = xtOrganization;
	}

	@Column(name = "GROUP_NAME", length = 32)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@OneToMany(cascade = CascadeType.REMOVE, fetch=FetchType.LAZY , mappedBy = "xtGroup")
	public List<XtRole> getXtRoles() {
		return this.xtRoles;
	}

	public void setXtRoles(List<XtRole> xtRoles) {
		this.xtRoles = xtRoles;
	}

	@OneToMany(cascade = CascadeType.REMOVE, fetch=FetchType.LAZY, mappedBy = "xtGroup")
	public List<XtUser> getXtUsers() {
		return this.xtUsers;
	}

	public void setXtUsers(List<XtUser> xtUsers) {
		this.xtUsers = xtUsers;
	}
	
}
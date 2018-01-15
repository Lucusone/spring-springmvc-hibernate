package com.xjgc.xjap.authority.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "xt_user_role")
public class XtUserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	  
	@Id
	@Column(name = "ROLE_USER_ID", unique = true, nullable = false, length = 32)
	private String roleUserId;
	
	@ManyToOne(targetEntity=XtRole.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID")
	private XtRole xtRole;
	
	@ManyToOne(targetEntity=XtUser.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private XtUser xtUser;


	public XtUserRole() {
	}

	public XtUserRole(String roleUserId) {
		this.roleUserId = roleUserId;
	}

	public XtUserRole(String roleUserId, XtRole xtRole, XtUser xtUser) {
		this.roleUserId = roleUserId;
		this.xtRole = xtRole;
		this.xtUser = xtUser;
	}

	public String getRoleUserId() {
		return this.roleUserId;
	}

	public void setRoleUserId(String roleUserId) {
		this.roleUserId = roleUserId;
	}

	public XtRole getXtRole() {
		return this.xtRole;
	}

	public void setXtRole(XtRole xtRole) {
		this.xtRole = xtRole;
	}

	public XtUser getXtUser() {
		return this.xtUser;
	}

	public void setXtUser(XtUser xtUser) {
		this.xtUser = xtUser;
	}

}
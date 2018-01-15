package com.xjgc.xjap.authority.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "xt_user")
public class XtUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String userId;
	private XtGroup xtGroup;
	private XtResource xtResource;
	private XtDept xtDept;
	private XtOrganization xtOrganization;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userAddr;
	private String userTel;
	private String userMobile;
	private String userFax;
	private String userInvalid;
	private String userPswInvalid;
	private Date userPswEndDate;
	private String userNote;
	private List<XtLog> xtLogs = new ArrayList<XtLog>();
	private List<XtUserRole> xtUserRoles = new ArrayList<XtUserRole>();

	public XtUser() {}
	
	@Id
	@Column(name = "USER_ID", unique = true, nullable = false, length = 32)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@ManyToOne(targetEntity = XtGroup.class, fetch=FetchType.LAZY)
	@JoinColumn(name = "GROUP_ID")
	public XtGroup getXtGroup() {
		return this.xtGroup;
	}

	public void setXtGroup(XtGroup xtGroup) {
		this.xtGroup = xtGroup;
	}

	@ManyToOne(targetEntity=XtResource.class, fetch=FetchType.LAZY)
	@JoinColumn(name = "RES_ID")
	public XtResource getXtResource() {
		return this.xtResource;
	}

	public void setXtResource(XtResource xtResource) {
		this.xtResource = xtResource;
	}

	@ManyToOne(targetEntity=XtDept.class, fetch=FetchType.LAZY)
	@JoinColumn(name = "DEPT_ID", nullable = true)
	public XtDept getXtDept() {
		return this.xtDept;
	}

	public void setXtDept(XtDept XtDept) {
		this.xtDept = XtDept;
	}

	@ManyToOne(targetEntity=XtOrganization.class, fetch=FetchType.LAZY)
	@JoinColumn(name = "ORG_ID", nullable = true)
	public XtOrganization getXtOrganization() {
		return this.xtOrganization;
	}

	public void setXtOrganization(XtOrganization xtOrganization) {
		this.xtOrganization = xtOrganization;
	}

	@Column(name = "USER_NAME", length = 38)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "USER_PASSWORD", length = 50)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "USER_EMAIL", length = 20)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "USER_ADDR", length = 100)
	public String getUserAddr() {
		return this.userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	@Column(name = "USER_TEL", length = 40)
	public String getUserTel() {
		return this.userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	@Column(name = "USER_MOBILE", length = 40)
	public String getUserMobile() {
		return this.userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	@Column(name = "USER_FAX", length = 15)
	public String getUserFax() {
		return this.userFax;
	}

	public void setUserFax(String userFax) {
		this.userFax = userFax;
	}

	@Column(name = "USER_INVALID", length = 1)
	public String getUserInvalid() {
		return this.userInvalid;
	}

	public void setUserInvalid(String userInvalid) {
		this.userInvalid = userInvalid;
	}

	@Column(name = "USER_PSW_INVALID", length = 1)
	public String getUserPswInvalid() {
		return this.userPswInvalid;
	}

	public void setUserPswInvalid(String userPswInvalid) {
		this.userPswInvalid = userPswInvalid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "USER_PSW_END_DATE", length = 10)
	public Date getUserPswEndDate() {
		return this.userPswEndDate;
	}

	public void setUserPswEndDate(Date userPswEndDate) {
		this.userPswEndDate = userPswEndDate;
	}

	@Column(name = "USER_NOTE")
	public String getUserNote() {
		return this.userNote;
	}

	public void setUserNote(String userNote) {
		this.userNote = userNote;
	}

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "xtUser")
	public List<XtLog> getXtLogs() {
		return this.xtLogs;
	}

	public void setXtLogs(List<XtLog> xtLogs) {
		this.xtLogs = xtLogs;
	}

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "xtUser")
	public List<XtUserRole> getXtUserRoles() {
		return this.xtUserRoles;
	}

	public void setXtUserRoles(List<XtUserRole> xtUserRoles) {
		this.xtUserRoles = xtUserRoles;
	}

}
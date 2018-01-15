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
 * 公司
 * XtOrganization entity. @author lucus
 */
@Entity
@Table(name = "xt_organization")
public class XtOrganization implements Serializable {

	private static final long serialVersionUID = 1L;
	// Fields
	private String orgId;
	private XtOrgType xtOrgType;
	private XtOrganization xtOrganization;
	private String orgName;
	private String orgTel;
	private String orgFax;
	private String orgPostcode;
	private String orgEmail;
	private String orgAddress;
	private String orgWebsite;
	private String orgNote;
	private String orgCode;
	private String orgIsinvalid;
	private List<XtOrganization> xtOrganizations = new ArrayList<XtOrganization>();
	private List<XtRole> xtRoles = new ArrayList<XtRole>();
	private List<XtDept> XtDepts = new ArrayList<XtDept>();
	private List<XtUser> xtUsers = new ArrayList<XtUser>();
	private List<XtGroup> xtGroups = new ArrayList<XtGroup>();

	// Constructors
	/** default constructor */
	public XtOrganization() {
	}

	/** minimal constructor */
	public XtOrganization(String orgId, String orgName) {
		this.orgId = orgId;
		this.orgName = orgName;
	}

	/** full constructor */
	public XtOrganization(String orgId, XtOrgType xtOrgType, XtOrganization xtOrganization, String orgName,
			String orgTel, String orgFax, String orgPostcode, String orgEmail, String orgAddress, String orgWebsite,
			String orgNote, String orgCode, String orgIsinvalid, List<XtOrganization> xtOrganizations,
			List<XtRole> xtRoles, List<XtDept> XtDepts, List<XtUser> xtUsers, List<XtGroup> xtGroups) {
		this.orgId = orgId;
		this.xtOrgType = xtOrgType;
		this.xtOrganization = xtOrganization;
		this.orgName = orgName;
		this.orgTel = orgTel;
		this.orgFax = orgFax;
		this.orgPostcode = orgPostcode;
		this.orgEmail = orgEmail;
		this.orgAddress = orgAddress;
		this.orgWebsite = orgWebsite;
		this.orgNote = orgNote;
		this.orgCode = orgCode;
		this.orgIsinvalid = orgIsinvalid;
		this.xtOrganizations = xtOrganizations;
		this.xtRoles = xtRoles;
		this.XtDepts = XtDepts;
		this.xtUsers = xtUsers;
		this.xtGroups = xtGroups;
	}

	// Property accessors
	@Id
	@Column(name = "ORG_ID", unique = true, nullable = false, length = 32)
	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	@ManyToOne(targetEntity=XtOrgType.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "ORG_TYPE_ID")
	public XtOrgType getXtOrgType() {
		return this.xtOrgType;
	}

	public void setXtOrgType(XtOrgType xtOrgType) {
		this.xtOrgType = xtOrgType;
	}

	@ManyToOne(targetEntity=XtOrganization.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "PARENT_ORG_ID")
	public XtOrganization getXtOrganization() {
		return this.xtOrganization;
	}

	public void setXtOrganization(XtOrganization xtOrganization) {
		this.xtOrganization = xtOrganization;
	}

	@Column(name = "ORG_NAME", nullable = true, length = 80)
	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Column(name = "ORG_TEL", length = 40)
	public String getOrgTel() {
		return this.orgTel;
	}

	public void setOrgTel(String orgTel) {
		this.orgTel = orgTel;
	}

	@Column(name = "ORG_FAX", length = 15)
	public String getOrgFax() {
		return this.orgFax;
	}

	public void setOrgFax(String orgFax) {
		this.orgFax = orgFax;
	}

	@Column(name = "ORG_POSTCODE", length = 6)
	public String getOrgPostcode() {
		return this.orgPostcode;
	}

	public void setOrgPostcode(String orgPostcode) {
		this.orgPostcode = orgPostcode;
	}

	@Column(name = "ORG_EMAIL", length = 20)
	public String getOrgEmail() {
		return this.orgEmail;
	}

	public void setOrgEmail(String orgEmail) {
		this.orgEmail = orgEmail;
	}

	@Column(name = "ORG_ADDRESS", length = 100)
	public String getOrgAddress() {
		return this.orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	@Column(name = "ORG_WEBSITE", length = 32)
	public String getOrgWebsite() {
		return this.orgWebsite;
	}

	public void setOrgWebsite(String orgWebsite) {
		this.orgWebsite = orgWebsite;
	}

	@Column(name = "ORG_NOTE", length = 200)
	public String getOrgNote() {
		return this.orgNote;
	}

	public void setOrgNote(String orgNote) {
		this.orgNote = orgNote;
	}

	@Column(name = "ORG_CODE", length = 50)
	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	@Column(name = "ORG_ISINVALID", length = 1)
	public String getOrgIsinvalid() {
		return this.orgIsinvalid;
	}

	public void setOrgIsinvalid(String orgIsinvalid) {
		this.orgIsinvalid = orgIsinvalid;
	}

	@OneToMany(cascade = CascadeType.REMOVE,fetch=FetchType.LAZY, mappedBy = "xtOrganization")
	public List<XtOrganization> getXtOrganizations() {
		return this.xtOrganizations;
	}

	public void setXtOrganizations(List<XtOrganization> xtOrganizations) {
		this.xtOrganizations = xtOrganizations;
	}

	@OneToMany(cascade = CascadeType.REMOVE,fetch=FetchType.LAZY, mappedBy = "xtOrganization")
	public List<XtRole> getXtRoles() {
		return this.xtRoles;
	}

	public void setXtRoles(List<XtRole> xtRoles) {
		this.xtRoles = xtRoles;
	}

	@OneToMany(cascade = CascadeType.REMOVE,fetch=FetchType.LAZY, mappedBy = "xtOrganization")
	public List<XtDept> getXtDepts() {
		return this.XtDepts;
	}

	public void setXtDepts(List<XtDept> XtDepts) {
		this.XtDepts = XtDepts;
	}

	@OneToMany(cascade = CascadeType.REMOVE,fetch=FetchType.LAZY, mappedBy = "xtOrganization")
	public List<XtUser> getXtUsers() {
		return this.xtUsers;
	}

	public void setXtUsers(List<XtUser> xtUsers) {
		this.xtUsers = xtUsers;
	}

	@OneToMany(cascade = CascadeType.REMOVE,fetch=FetchType.LAZY, mappedBy = "xtOrganization")
	public List<XtGroup> getXtGroups() {
		return this.xtGroups;
	}

	public void setXtGroups(List<XtGroup> xtGroups) {
		this.xtGroups = xtGroups;
	}

}
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
 * 类描述：公司类型编码
 * XtOrgType entity. @author lucus
 */
@Entity
@Table(name = "xt_org_type")
public class XtOrgType implements Serializable {

	private static final long serialVersionUID = 1L;
	// Fields
	private String orgTypeId;
	private String orgTypeName;
	private List<XtOrganization> xtOrganizations = new ArrayList<XtOrganization>();

	// Constructors
	/** default constructor */
	public XtOrgType() {
	}

	/** minimal constructor */
	public XtOrgType(String orgTypeId) {
		this.orgTypeId = orgTypeId;
	}

	/** full constructor */
	public XtOrgType(String orgTypeId, String orgTypeName, List<XtOrganization> xtOrganizations) {
		this.orgTypeId = orgTypeId;
		this.orgTypeName = orgTypeName;
		this.xtOrganizations = xtOrganizations;
	}

	// Property accessors
	@Id
	@Column(name = "ORG_TYPE_ID", unique = true, nullable = false, length = 32)
	public String getOrgTypeId() {
		return this.orgTypeId;
	}

	public void setOrgTypeId(String orgTypeId) {
		this.orgTypeId = orgTypeId;
	}

	@Column(name = "ORG_TYPE_NAME", length = 64)
	public String getOrgTypeName() {
		return this.orgTypeName;
	}

	public void setOrgTypeName(String orgTypeName) {
		this.orgTypeName = orgTypeName;
	}

	@OneToMany(cascade = CascadeType.REMOVE,fetch=FetchType.LAZY, mappedBy = "xtOrgType")
	public List<XtOrganization> getXtOrganizations() {
		return this.xtOrganizations;
	}

	public void setXtOrganizations(List<XtOrganization> xtOrganizations) {
		this.xtOrganizations = xtOrganizations;
	}
	
}
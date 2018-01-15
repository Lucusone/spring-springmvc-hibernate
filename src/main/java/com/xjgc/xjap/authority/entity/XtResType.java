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
 * XtResType entity. @author lucus
 */
@Entity
@Table(name = "xt_res_type")
public class XtResType implements Serializable {

	private static final long serialVersionUID = 1L;
	// Fields
	private String resTypeId;
	private String resTypeName;
	private List<XtResource> xtResources = new ArrayList<XtResource>();

	// Constructors

	/** default constructor */
	public XtResType() {
	}

	/** minimal constructor */
	public XtResType(String resTypeId) {
		this.resTypeId = resTypeId;
	}

	/** full constructor */
	public XtResType(String resTypeId, String resTypeName, List<XtResource> xtResources) {
		this.resTypeId = resTypeId;
		this.resTypeName = resTypeName;
		this.xtResources = xtResources;
	}

	// Property accessors
	@Id
	@Column(name = "RES_TYPE_ID", unique = true, nullable = false, length = 32)

	public String getResTypeId() {
		return this.resTypeId;
	}

	public void setResTypeId(String resTypeId) {
		this.resTypeId = resTypeId;
	}

	@Column(name = "RES_TYPE_NAME", length = 80)
	public String getResTypeName() {
		return this.resTypeName;
	}

	public void setResTypeName(String resTypeName) {
		this.resTypeName = resTypeName;
	}

	@OneToMany(cascade = CascadeType.REMOVE,fetch=FetchType.LAZY, mappedBy = "xtResType")
	public List<XtResource> getXtResources() {
		return this.xtResources;
	}

	public void setXtResources(List<XtResource> xtResources) {
		this.xtResources = xtResources;
	}

}
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
 * XtResClass entity. @author lucus
 */
@Entity
@Table(name = "xt_res_class")
public class XtResClass implements Serializable {

	private static final long serialVersionUID = 1L;
	// Fields
	private String resClassId;
	private XtResClass xtResClass;
	private String resClassName;
	private List<XtResClass> xtResClasses = new ArrayList<XtResClass>();
	private List<XtResource> xtResources = new ArrayList<XtResource>();

	// Constructors
	/** default constructor */
	public XtResClass() {}

	/** minimal constructor */
	public XtResClass(String resClassId) {
		this.resClassId = resClassId;
	}

	/** full constructor */
	public XtResClass(String resClassId, XtResClass xtResClass, String resClassName, List<XtResClass> xtResClasses,
			List<XtResource> xtResources) {
		this.resClassId = resClassId;
		this.xtResClass = xtResClass;
		this.resClassName = resClassName;
		this.xtResClasses = xtResClasses;
		this.xtResources = xtResources;
	}

	// Property accessors
	@Id
	@Column(name = "RES_CLASS_ID", unique = true, nullable = false, length = 32)
	public String getResClassId() {
		return this.resClassId;
	}

	public void setResClassId(String resClassId) {
		this.resClassId = resClassId;
	}

	@ManyToOne(targetEntity=XtResClass.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "PARENT_RES_CLASS_ID")
	public XtResClass getXtResClass() {
		return this.xtResClass;
	}

	public void setXtResClass(XtResClass xtResClass) {
		this.xtResClass = xtResClass;
	}

	@Column(name = "RES_CLASS_NAME", length = 80)
	public String getResClassName() {
		return this.resClassName;
	}

	public void setResClassName(String resClassName) {
		this.resClassName = resClassName;
	}

	@OneToMany(cascade = CascadeType.REMOVE,fetch=FetchType.LAZY,mappedBy = "xtResClass")
	public List<XtResClass> getXtResClasses() {
		return this.xtResClasses;
	}

	public void setXtResClasses(List<XtResClass> xtResClasses) {
		this.xtResClasses = xtResClasses;
	}

	@OneToMany(cascade = CascadeType.REMOVE,fetch=FetchType.LAZY,mappedBy = "xtResClass")
	public List<XtResource> getXtResources() {
		return this.xtResources;
	}

	public void setXtResources(List<XtResource> xtResources) {
		this.xtResources = xtResources;
	}

}
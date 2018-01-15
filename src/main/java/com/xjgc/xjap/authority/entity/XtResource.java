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
@Table(name = "xt_resource")
public class XtResource implements Serializable {

	private static final long serialVersionUID = 1L;
	// Fields
	private String resId;
	private XtResType xtResType;
	private XtResClass xtResClass;
	private String resName;
	private String resUrl;
	private String resObjectName;
	private String resAccessType;
	private String resActive;
	private String resUsebymenu;
	private String resUsebywf;
	private String resHelpPath;
	private Integer resOrder;
	private List<XtMenu> xtMenus = new ArrayList<XtMenu>();
	private List<XtUser> xtUsers = new ArrayList<XtUser>();
	private List<XtPermAssign> xtPermAssigns = new ArrayList<XtPermAssign>();

	// Constructors 
	/** default constructor */
	public XtResource() {
	}

	/** minimal constructor */
	public XtResource(String resId) {
		this.resId = resId;
	}

	/** full constructor */
	public XtResource(String resId, XtResType xtResType, XtResClass xtResClass, String resName, String resUrl,
			String resObjectName, String resAccessType, String resActive, String resUsebymenu, String resUsebywf,
			String resHelpPath, Integer resOrder, List<XtMenu> xtMenus, List<XtUser> xtUsers,
			List<XtPermAssign> xtPermAssigns) {
		this.resId = resId;
		this.xtResType = xtResType;
		this.xtResClass = xtResClass;
		this.resName = resName;
		this.resUrl = resUrl;
		this.resObjectName = resObjectName;
		this.resAccessType = resAccessType;
		this.resActive = resActive;
		this.resUsebymenu = resUsebymenu;
		this.resUsebywf = resUsebywf;
		this.resHelpPath = resHelpPath;
		this.resOrder = resOrder;
		this.xtMenus = xtMenus;
		this.xtUsers = xtUsers;
		this.xtPermAssigns = xtPermAssigns;
	}

	// Property accessors
	@Id
	@Column(name = "RES_ID", unique = true, nullable = false, length = 32)
	public String getResId() {
		return this.resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	@ManyToOne(targetEntity=XtResType.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "RES_TYPE_ID")
	public XtResType getXtResType() {
		return this.xtResType;
	}

	public void setXtResType(XtResType xtResType) {
		this.xtResType = xtResType;
	}

	@ManyToOne(targetEntity=XtResClass.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "RES_CLASS_ID")
	public XtResClass getXtResClass() {
		return this.xtResClass;
	}

	public void setXtResClass(XtResClass xtResClass) {
		this.xtResClass = xtResClass;
	}

	@Column(name = "RES_NAME", length = 80)
	public String getResName() {
		return this.resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	@Column(name = "RES_URL", length = 300)
	public String getResUrl() {
		return this.resUrl;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}

	@Column(name = "RES_OBJECT_NAME", length = 80)
	public String getResObjectName() {
		return this.resObjectName;
	}

	public void setResObjectName(String resObjectName) {
		this.resObjectName = resObjectName;
	}

	@Column(name = "RES_ACCESS_TYPE", length = 1)
	public String getResAccessType() {
		return this.resAccessType;
	}

	public void setResAccessType(String resAccessType) {
		this.resAccessType = resAccessType;
	}

	@Column(name = "RES_ACTIVE", length = 1)
	public String getResActive() {
		return this.resActive;
	}

	public void setResActive(String resActive) {
		this.resActive = resActive;
	}

	@Column(name = "RES_USEBYMENU", length = 1)
	public String getResUsebymenu() {
		return this.resUsebymenu;
	}

	public void setResUsebymenu(String resUsebymenu) {
		this.resUsebymenu = resUsebymenu;
	}

	@Column(name = "RES_USEBYWF", length = 1)
	public String getResUsebywf() {
		return this.resUsebywf;
	}

	public void setResUsebywf(String resUsebywf) {
		this.resUsebywf = resUsebywf;
	}

	@Column(name = "RES_HELP_PATH", length = 50)
	public String getResHelpPath() {
		return this.resHelpPath;
	}

	public void setResHelpPath(String resHelpPath) {
		this.resHelpPath = resHelpPath;
	}

	@Column(name = "RES_ORDER", precision = 5, scale = 0)
	public Integer getResOrder() {
		return this.resOrder;
	}

	public void setResOrder(Integer resOrder) {
		this.resOrder = resOrder;
	}

	@OneToMany(cascade = CascadeType.REMOVE,fetch=FetchType.LAZY, mappedBy = "xtResource")
	public List<XtMenu> getXtMenus() {
		return this.xtMenus;
	}

	public void setXtMenus(List<XtMenu> xtMenus) {
		this.xtMenus = xtMenus;
	}

	@OneToMany(cascade = CascadeType.REMOVE,fetch=FetchType.LAZY, mappedBy = "xtResource")
	public List<XtUser> getXtUsers() {
		return this.xtUsers;
	}

	public void setXtUsers(List<XtUser> xtUsers) {
		this.xtUsers = xtUsers;
	}

	@OneToMany(cascade = CascadeType.REMOVE,fetch=FetchType.LAZY, mappedBy = "xtResource")
	public List<XtPermAssign> getXtPermAssigns() {
		return this.xtPermAssigns;
	}

	public void setXtPermAssigns(List<XtPermAssign> xtPermAssigns) {
		this.xtPermAssigns = xtPermAssigns;
	}

}
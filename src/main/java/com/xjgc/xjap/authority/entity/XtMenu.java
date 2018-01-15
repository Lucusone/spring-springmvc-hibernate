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
 * 类描�?: 菜单实体
 * XtMenu entity. @author lucus
 */
@Entity //声明当前类为hibernate映射到数据库中的实体�?
@Table(name = "xt_menu") //声明在数据库中自动生成的表名为t_user
public class XtMenu implements Serializable {

	private static final long serialVersionUID = 1L;
	// Fields
	private String menuId;
	private XtMenu xtMenu;
	private XtResource xtResource;
	private String menuName;
	private String menuHint;
	private String menuDesc;
	private String menuIcon;
	private String menuIconOpen;
	private String menuIconPath;
	private String menuIconPathOpen;
	private String menuActive;
	private Integer menuOrder;
	private String menuIsnewwindowopen;
	private List<XtMenu> xtMenus = new ArrayList<XtMenu>();

	// Constructors
	/** default constructor */
	public XtMenu() {
	}

	/** minimal constructor */
	public XtMenu(String menuId) {
		this.menuId = menuId;
	}

	/** full constructor */
	public XtMenu(String menuId, XtMenu xtMenu, XtResource xtResource, String menuName, String menuHint,
			String menuDesc, String menuIcon, String menuIconOpen, String menuIconPath, String menuIconPathOpen,
			String menuActive, Integer menuOrder, String menuIsnewwindowopen, List<XtMenu> xtMenus) {
		this.menuId = menuId;
		this.xtMenu = xtMenu;
		this.xtResource = xtResource;
		this.menuName = menuName;
		this.menuHint = menuHint;
		this.menuDesc = menuDesc;
		this.menuIcon = menuIcon;
		this.menuIconOpen = menuIconOpen;
		this.menuIconPath = menuIconPath;
		this.menuIconPathOpen = menuIconPathOpen;
		this.menuActive = menuActive;
		this.menuOrder = menuOrder;
		this.menuIsnewwindowopen = menuIsnewwindowopen;
		this.xtMenus = xtMenus;
	}

	// Property accessors
	@Id //声明此列为主�?,作为映射对象的标识符
	@Column(name = "MENU_ID", unique = true, nullable = false, length = 32)
	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	//设置主表外键,多对�?单向外键(Annotation),LAZY表示关系类被访问时才加载
	//JoinColumn表示外键
	@ManyToOne(targetEntity=XtMenu.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "PARENT_MENU_ID") 
	public XtMenu getXtMenu() {
		return this.xtMenu;
	}

	public void setXtMenu(XtMenu xtMenu) {
		this.xtMenu = xtMenu;
	}

	@ManyToOne(targetEntity=XtResource.class,fetch=FetchType.LAZY)
	@JoinColumn(name = "RES_ID")
	public XtResource getXtResource() {
		return this.xtResource;
	}

	public void setXtResource(XtResource xtResource) {
		this.xtResource = xtResource;
	}

	@Column(name = "MENU_NAME", length = 80)
	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Column(name = "MENU_HINT", length = 80)
	public String getMenuHint() {
		return this.menuHint;
	}

	public void setMenuHint(String menuHint) {
		this.menuHint = menuHint;
	}

	@Column(name = "MENU_DESC", length = 100)
	public String getMenuDesc() {
		return this.menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	@Column(name = "MENU_ICON", length = 20)
	public String getMenuIcon() {
		return this.menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	@Column(name = "MENU_ICON_OPEN", length = 20)
	public String getMenuIconOpen() {
		return this.menuIconOpen;
	}

	public void setMenuIconOpen(String menuIconOpen) {
		this.menuIconOpen = menuIconOpen;
	}

	@Column(name = "MENU_ICON_PATH", length = 50)
	public String getMenuIconPath() {
		return this.menuIconPath;
	}

	public void setMenuIconPath(String menuIconPath) {
		this.menuIconPath = menuIconPath;
	}

	@Column(name = "MENU_ICON_PATH_OPEN", length = 50)
	public String getMenuIconPathOpen() {
		return this.menuIconPathOpen;
	}

	public void setMenuIconPathOpen(String menuIconPathOpen) {
		this.menuIconPathOpen = menuIconPathOpen;
	}

	@Column(name = "MENU_ACTIVE", length = 1)
	public String getMenuActive() {
		return this.menuActive;
	}

	public void setMenuActive(String menuActive) {
		this.menuActive = menuActive;
	}

	@Column(name = "MENU_ORDER", precision = 5, scale = 0)
	public Integer getMenuOrder() {
		return this.menuOrder;
	}

	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}

	@Column(name = "MENU_ISNEWWINDOWOPEN", length = 1)
	public String getMenuIsnewwindowopen() {
		return this.menuIsnewwindowopen;
	}

	public void setMenuIsnewwindowopen(String menuIsnewwindowopen) {
		this.menuIsnewwindowopen = menuIsnewwindowopen;
	}

	@OneToMany(cascade = CascadeType.REMOVE, fetch=FetchType.LAZY, mappedBy = "xtMenu")
	public List<XtMenu> getXtMenus() {
		return this.xtMenus;
	}

	public void setXtMenus(List<XtMenu> xtMenus) {
		this.xtMenus = xtMenus;
	}
	
}
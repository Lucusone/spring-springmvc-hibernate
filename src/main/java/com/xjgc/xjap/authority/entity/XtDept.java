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
@Table(name="xt_dept")
public class XtDept implements Serializable{  

	 private static final long serialVersionUID = 1L;
	
	 private String deptId;
     private XtDept xtDept;
     private XtOrganization xtOrganization;
     private String deptName;
     private String deptTel;
     private String deptFax;
     private String deptAddr;
     private List<XtUser> xtUsers = new ArrayList<XtUser>();
     private List<XtDept> xtDepts = new ArrayList<XtDept>();

    public XtDept() {
    }

	/** minimal constructor */
    public XtDept(String deptId, XtOrganization xtOrganization) {
        this.deptId = deptId;
        this.xtOrganization = xtOrganization;
    }
    
    /** full constructor */
    public XtDept(String deptId, XtDept xtDept, XtOrganization xtOrganization, String deptName, 
    		String deptTel, String deptFax, String deptAddr, List<XtUser> xtUsers, List<XtDept> xtDepts) {
        this.deptId = deptId;
        this.xtDept = xtDept;
        this.xtOrganization = xtOrganization;
        this.deptName = deptName;
        this.deptTel = deptTel;
        this.deptFax = deptFax;
        this.deptAddr = deptAddr;
        this.xtUsers = xtUsers;
        this.xtDepts = xtDepts;
    }

    @Id 
    @Column(name="DEPT_ID", unique=true, nullable=false, length=32)
    public String getDeptId() {
        return this.deptId;
    }
    
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
    
	@ManyToOne(targetEntity=XtDept.class,fetch=FetchType.LAZY)
    @JoinColumn(name="PARENT_DEPT_ID")
    public XtDept getXtDept() {
        return this.xtDept;
    }
    
    public void setXtDept(XtDept xtDept) {
        this.xtDept = xtDept;
    }
    
	@ManyToOne(targetEntity=XtOrganization.class,fetch=FetchType.LAZY)
    @JoinColumn(name="ORG_ID", nullable=true)
    public XtOrganization getXtOrganization() {
        return this.xtOrganization;
    }
    
    public void setXtOrganization(XtOrganization xtOrganization) {
        this.xtOrganization = xtOrganization;
    }
    
    @Column(name="DEPT_NAME", length=80)
    public String getDeptName() {
        return this.deptName;
    }
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    
    @Column(name="DEPT_TEL", length=40)
    public String getDeptTel() {
        return this.deptTel;
    }
    
    public void setDeptTel(String deptTel) {
        this.deptTel = deptTel;
    }
    
    @Column(name="DEPT_FAX", length=15)
    public String getDeptFax() {
        return this.deptFax;
    }
    
    public void setDeptFax(String deptFax) {
        this.deptFax = deptFax;
    }
    
    @Column(name="DEPT_ADDR", length=100)
    public String getDeptAddr() {
        return this.deptAddr;
    }
    
    public void setDeptAddr(String deptAddr) {
        this.deptAddr = deptAddr;
    }
    
    @OneToMany(cascade=CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy="xtDept")
    public List<XtUser> getXtUsers() {
        return this.xtUsers;
    }
    
    public void setXtUsers(List<XtUser> xtUsers) {
        this.xtUsers = xtUsers;
    }
    
    @OneToMany(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY, mappedBy="xtDept")
    public List<XtDept> getXtDepts() {
        return this.xtDepts;
    }
    
    public void setXtDepts(List<XtDept> xtDepts) {
        this.xtDepts = xtDepts;
    }

}
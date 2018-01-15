package com.xjgc.xjap.authority.dao;

import java.util.List;

import com.xjgc.xjap.authority.entity.XtPermAssign;
import com.xjgc.xjap.authority.entity.XtResource;

public interface IXtPermAssignDao {

	public void addEntity(XtPermAssign xtPermAssign);
	
	public List<XtPermAssign> findAll();
	
	public List<XtResource> findAllPermByRoleId(String roleId);
	
	public void deleteEntityAllPermByRoleId(String roleId);
	
	
}

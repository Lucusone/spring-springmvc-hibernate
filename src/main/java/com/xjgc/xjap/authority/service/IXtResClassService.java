package com.xjgc.xjap.authority.service;

import java.util.List;

import com.xjgc.xjap.authority.entity.XtResClass;
import com.xjgc.xjap.authority.entity.XtRole;

public interface IXtResClassService {

	public List<XtResClass> getAll();
	
	public XtResClass getXtResClassById(String id);
	
	public List<XtResClass> getByPage(int page,int rows);
	
	public long getTotal();
	
	public void add(XtResClass resClass);
	
	public void delete(XtResClass resClass);
	
	public void update(XtResClass resClass);
	
	public String getResZTreeByRoleId(String roleId);
	
	public XtRole getRoleById(String roleId);
}
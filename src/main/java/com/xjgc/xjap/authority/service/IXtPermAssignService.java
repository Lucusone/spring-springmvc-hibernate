package com.xjgc.xjap.authority.service;

import java.util.List;

import com.xjgc.xjap.authority.entity.XtResource;

public interface IXtPermAssignService {

	public List<XtResource> getResourceByRoleId(String roleId);
	
	public void deletePermAssignByRoleId(String roleId);
	
	public boolean addPermAssignByRoleIdResId(String roleId,String resId);
	
}

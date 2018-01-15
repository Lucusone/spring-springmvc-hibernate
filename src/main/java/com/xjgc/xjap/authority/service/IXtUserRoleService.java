package com.xjgc.xjap.authority.service;

import java.util.List;

import com.xjgc.xjap.authority.entity.XtRole;
import com.xjgc.xjap.authority.entity.XtUserRole;

public interface IXtUserRoleService {

	public void save(XtUserRole xtUserRole);
	
	public List<XtRole> getRolesOfUser(String userId);
	
	public void deleteUserRoleByUserId(String userId);
	
}

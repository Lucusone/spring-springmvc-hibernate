package com.xjgc.xjap.authority.dao;

import java.util.List;

import com.xjgc.xjap.authority.entity.XtRole;
import com.xjgc.xjap.authority.entity.XtUser;
import com.xjgc.xjap.authority.entity.XtUserRole;

public interface IXtUserRoleDao {

	public XtUserRole getUserRole(XtUser xtUser,XtRole xtRole);
	public void deleteAllRoleOfUser(String userId);
	public List<XtRole> getRolesOfUser(String userId);
	
	public void save(XtUserRole xtUserRole);

	/**
	 * 批量保存
	 * 
	 * @param userRoles
	 * @return
	 */
	Object batchSave(List<XtUserRole> userRoles);
	
	public void deleteUserRoleByUserId(String userId);
	
}

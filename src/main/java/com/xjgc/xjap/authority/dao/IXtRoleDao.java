package com.xjgc.xjap.authority.dao;

import java.util.List;
import com.xjgc.xjap.authority.entity.XtRole;

public interface IXtRoleDao {

	public List<XtRole> findAllRole();
	public Long findTotal();
	public List<XtRole> findByPage(int page, int rows);
	
	//根据orgId获得所有的角色，不分页
	public List<XtRole> findRoleByOrgId(String orgId);
	
	//根据条件获得所有xtrole 列表：search，orgId，分页，sort，order
	public List<XtRole> findRolesByCondition(String orgId,String search,String sort,String order,int pageNum,int rows);
	
	//根据条件获得所有xtrole的记录数
	public Long findTotalByCondition(String orgId,String search);
	
	public Long findTotalBySql(String sql);
	
	public List<XtRole> findRoleByFixQuery(String sql,String[] arg1,Object[] arg2);
		
	/**
	 * IceWee 09-05-25
	 * 
	 * 获取指定组织和组下的角色列表
	 * 
	 * @param orgId
	 * @param groupId
	 * @return
	 */
	public List<XtRole> findRoles(String orgId, String groupId);
	
	public XtRole findRoleById(String roleId);
	
	public void addEntityRole(XtRole role);
	
	public void updateEntityRole(XtRole role);
	
	public void deleteEntityRole(XtRole role);
	
	public void deleteEntityRoleById(String roleId);
	
	public List<XtRole> findRolesByResId(String resId);
	
}

package com.xjgc.xjap.authority.service;

import java.util.List;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.entity.XtRole;

public interface IXtRoleService {

	public List<XtRole> getAllRole();
	
	public List<XtRole> getRolesByPage(int pageNum, int rows, Page page);
	
	public List<XtRole> getRolesByPageAndSql(String sql, Page page);
	
	List<XtRole> getXtRoleByPage(int page, int rows);
	
	public long getRoleTotal();
	
	public void save(XtRole role);
	
	public void update(XtRole role);
	
	public void delete(XtRole role);
	
	public void deleteById(String id);
	
	public XtRole getRoleById(String id);
	
	public List<XtRole> getRolesByResId(String resId);
	
	//根据orgId获得role列表
	public List<XtRole> getRolesByOrgId(String orgId);
	
	//根据条件获得role列表
	public List<XtRole> getRolesByCondition(String orgId, String search, String sort, String order, int pageNum,
			int rows);
	
	//根据条件获得记录总数
	public Long getTotalByCondition(String orgId, String search);
	
}

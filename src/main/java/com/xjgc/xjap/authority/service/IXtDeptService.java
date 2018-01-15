package com.xjgc.xjap.authority.service;

import java.util.List;

import com.xjgc.xjap.authority.entity.XtDept;

public interface IXtDeptService {

	public List<XtDept> getAll();
	
	public void add(XtDept xtdept);
	
	public boolean deleteById(String deptId);
	
	public XtDept getXtDeptById(String deptId);
	
	public void update(XtDept xtdept);
	
	//分页
	public Long getTotal();
	
	public Long getTotalByOrgIdOrParId(String orgId,String parId);
	
	public List<XtDept> getPagesByOrgId(String orgId,int page,int rows,String order,String sort);
	
	public List<XtDept> getPagesByParId(String parId,int page,int rows,String order,String sort);
	
	public List<XtDept> getPagesByOrgIdOrByParId(String orgId,String parId,int page,int rows,String order,String sort);
	
	public List<XtDept> getPages(int page,int rows);
	
	//根据orgId来查询公司对应的部门树
	public String getDeptTreeByOrgId(String orgId);
	
	public boolean getIsLeafDept(String deptId);
	
	public List<XtDept> getDeptsByCondition(String orgId,String search,String sort,String order,int pageNum,int rows);
	
	public Long getTotalByCondition(String orgId,String search);
	
}

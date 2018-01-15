package com.xjgc.xjap.authority.dao;

import java.util.List;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.entity.XtDept;

public interface IXtDeptDao {

	public void saveEntity(XtDept xtDept);
	
	public void deleteEntity(XtDept xtDept);
	
	public boolean deleteEntityByKey(String deptId);
	
	public void deleteEntityAll(List<XtDept> depts);
	
	public void updateEntity(XtDept xtDept);
	
	public boolean findContains(XtDept xtDept);
	
	public XtDept findDeptById(String deptId);

	//分页查询
	public List<XtDept> findByPage(int page, int rows);
	public List<XtDept> findPagesBySql(String hql, Page page);
 	
	//获取记录总数
	public Long findTotal();
	public Long findTotalBySql(String sql);
	
	//根据组织ID获取部门列表
	public List<XtDept> findDeptByOrgId(String orgId);
	
	/**
	 * 根据组织ID获取顶级部门列表
	 * 
	 * @param orgId
	 * @return
	 */
	public List<XtDept> findTopDeptByOrgId(String orgId);
	
	/**
	 * 获取下级部门列表
	 * 
	 * @param deptId
	 * @return
	 */
	public List<XtDept> findDeptByDeptId(String deptId);
	
	public boolean findIsLeafDept(String deptId);
	
	public List<XtDept> findAll();
	
	/***
	 * 根据条件来获得dept列表
	 * @param orgId
	 * @param search
	 * @param sort
	 * @param order
	 * @param pageNum
	 * @param rows
	 * @return
	 */
	public List<XtDept> findDeptsByCondition(String orgId,String search,String sort,String order,int pageNum,int rows);
	
	/***
	 * 根据条件来获得总记录数
	 * @param orgId
	 * @param search
	 * @return
	 */
	public Long findTotalByCondition(String orgId,String search);
	
}

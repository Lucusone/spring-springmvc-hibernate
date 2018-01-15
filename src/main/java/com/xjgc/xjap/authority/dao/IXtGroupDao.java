package com.xjgc.xjap.authority.dao;

import java.util.List;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.entity.XtDept;
import com.xjgc.xjap.authority.entity.XtGroup;


public interface IXtGroupDao {

	/**
	 * 添加组
	 * 
	 * @param group
	 */
	public void saveEntity(XtGroup xtgroup);
	
	/**
	 * 更新组
	 * 
	 * @param group
	 */
	public void updateEntity(XtGroup xtgroup);
	
	/**
	 * 删除组
	 * 
	 * @param group
	 */
	public void deleteEntity(XtGroup xtgroup);
	
	/**
	 * ID获取组
	 * 
	 * @param groupId
	 * @return
	 */
	public XtGroup findById(String groupId);
	
	/**
	 * 全部组列表
	 * 
	 * @return
	 */
	public List<XtGroup> findGroups();
	
	/**
	 * 所属组织下的组列表
	 * 
	 * @param orgId
	 * @return
	 */
	public List<XtGroup> findGroupByOrgId(String orgId);
	
	//分页查询
	public List<XtGroup> findByPage(int page, int rows);
	public List<XtGroup> findPagesBySql(String hql,Page page);
 		
	//获取记录总数
	public Long findTotal();
	
	public Long findTotalBySql(String sql);
	
}

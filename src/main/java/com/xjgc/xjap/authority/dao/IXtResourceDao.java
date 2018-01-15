package com.xjgc.xjap.authority.dao;

import java.util.List;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.entity.XtResource;

public interface IXtResourceDao {
	
	public List<XtResource> findAllResource();

	//分页查询
	//public List<XtResource> listEntitiesByPageCtrl(PageCtrl pageCtrl);
	public List<XtResource> findPageBySql(String hql, Page page);
	
	public Long findTotal();
	//获得总记录数
	public Long findTotalBySql(String sql);
		
	public List<XtResource> findByPage(int page, int rows);
	
	public List<XtResource> findResByFixQuery(String sql, String[] arg1, Object[] arg2);

	public List<XtResource> findRessByClassId(String classId);

	/**
	 * 根据资源分类获得资源列表，并排除无效资源。
	 * 
	 * @param classId
	 * @return
	 */
	public List<XtResource> listValidRessByClassId(String classId);

	public List<XtResource> listRessUseByMenuAndClassId(String classId);
	
	/**
	 * 根据以下条件后去资源列表
	 * 
	 * @param resClassId
	 * @param resId
	 * @param resName
	 * @param resTypeId
	 * @return
	 */
	List<XtResource> list(String resClassId, String resId, String resName, String resTypeId);
	
	void deleteEntityById(String resId);
	
	/**
	 * 返回有效的、能够挂接到菜单的资源列表，并按资源名称排序
	 * 
	 * @return
	 */
	List<XtResource> findActive();
	
	public XtResource findResById(String id);
	
	public void addEntityRes(XtResource res);
	
	public void deleteEntityRes(XtResource res);
	
	public void deleteEntityResById(String id);

	public void updateEntityRes(XtResource res);
	
	/***
	 * 根据roleId来获得资源列表
	 * @param roleId
	 * @return
	 */
	public List<XtResource>  findResByRoleId(String roleId);
}

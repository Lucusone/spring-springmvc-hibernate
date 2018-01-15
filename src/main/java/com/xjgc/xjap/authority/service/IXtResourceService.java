package com.xjgc.xjap.authority.service;

import java.util.List;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.entity.XtResource;

public interface IXtResourceService {

	public List<XtResource> getAllResource();
	
	public List<XtResource> getResourcesByPage(int pageNum, int rows, Page page);
	
	public List<XtResource> getResourcesByPageAndSql(String sql, Page page);
	
	List<XtResource> getXtResourceByPage(int page, int rows);
	
	public long getResourceTotal();
	
	public void save(XtResource res);
	
	public void update(XtResource res);
	
	public void delete(XtResource res);
	
	public void deleteById(String id);
	
	public XtResource getResourceById(String resId);
	
	//根据classId来查询xtResouce列表
	public List<XtResource> getPageResByClassId(String classId, int page, int rows, String sort, String order);
	
	//根据classId来获得记录的总个数
	public Long getTotalResByClassId(String classId);
	
	/***
	 * 根据roleId获得资源列表
	 * @param roleId
	 * @return
	 */
	public List<XtResource> getResByRoleId(String roleId);
	
	/***
	 * 根据roleId获得资源url列表
	 * @param roleId
	 * @return
	 */
	public List<String> getResUrlByRoleId(String roleId);
	
}

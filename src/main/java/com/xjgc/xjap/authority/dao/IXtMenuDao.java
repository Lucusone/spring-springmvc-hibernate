package com.xjgc.xjap.authority.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.entity.XtMenu;

public interface IXtMenuDao {
	
	public List<XtMenu> find(DetachedCriteria detachedCriteria);
	
	public List<XtMenu> findXtMenuResourceByType(String userId,String resourceTypeId);
	
	public List<XtMenu> findXtMenuByOrgId(String orgId);
	
	//分页查询
	public List<XtMenu> findByPage(int pagenum, int rows);
	public List<XtMenu> findPageBySql(String hql, Page page);
	
	//获取记录总数
	public long findTotal();
	public Long findTotalBySql(String sql);

	public List<XtMenu> findRootMenus();
	
	public List<XtMenu> findAllMenus();
	
	public void deleteEntityById(String id);
	
	public void addEntityXtMenu(XtMenu menu);
	
	public XtMenu findXtMenuById(String id);
	
	public void updateEntityXtMenu(XtMenu menu);
	
	public List<XtMenu> findMenusByRoleId(String id);
	
	public List<XtMenu> findMenusByParentId(String id);
	
	public boolean findIsLeafMenu(String id);
	
	public List<XtMenu> findMenusByResIdNULL();
	
	
	
	
	
	
	
}

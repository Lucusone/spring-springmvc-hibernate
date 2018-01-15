package com.xjgc.xjap.authority.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.BaseDao;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.dao.IXtMenuDao;
import com.xjgc.xjap.authority.entity.XtMenu;

@Repository("xtmenuDao")
@Scope(value="prototype")
public class XtMenuDao extends BaseDao implements IXtMenuDao {

	@Override
	public List<XtMenu> findRootMenus() {
		
		String hql = "from XtMenu xm where xm.xtMenu is null";
		
		return this.getHibernateDaoHelper().findByHql(hql, null);
	}

	@Override
	public List<XtMenu> findAllMenus() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtMenu.class);
		detachedCriteria.addOrder(Order.asc("menuId"));
		return this.find(detachedCriteria);
	}

	@Override
	public void deleteEntityById(String id) {
		this.getHibernateDaoHelper().deleteEntityByKey(XtMenu.class, id);
	}

	@Override
	public void addEntityXtMenu(XtMenu menu) {
		this.getHibernateDaoHelper().addEntity(menu);
	}

	@Override
	public XtMenu findXtMenuById(String id) {
		return this.getHibernateDaoHelper().getEntityByKey(XtMenu.class, id);
	}

	@Override
	public void updateEntityXtMenu(XtMenu menu) {
		this.getHibernateDaoHelper().updateEntity(menu);
	}

	@Override
	public List<XtMenu> find(DetachedCriteria detachedCriteria) {
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public List<XtMenu> findXtMenuResourceByType(String userId, String resourceTypeId) {
		return null;
	}

	@Override
	public List<XtMenu> findXtMenuByOrgId(String orgId) {
		return null;
	}

	@Override
	public List<XtMenu> findByPage(int pagenum, int rows) {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtMenu.class);
		
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, pagenum, rows);
	}

	@Override
	public long findTotal() {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtMenu.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}

	@Override
	public Long findTotalBySql(String sql) {
		 return this.getHibernateDaoHelper().getTotalBySql(sql);
	}

	@Override
	public List<XtMenu> findMenusByRoleId(String id) {
		
		//String sql = "select * from XT_MENU where RES_ID in (select RES_ID from XT_PERM_ASSIGN where ROLE_ID = '"+id+"')";
		
		
		
		String hql = "from XtMenu xm where xm.xtResource in (select xtResource from XtPermAssign xpa where xpa.xtRole.roleId = ?)";
		
		//return (List<XtMenu>)this.getJdbcDaoHelper().query(sql);
		
		
		//XtRole xtRole = this.getHibernateDaoHelper().getEntityByKey(XtRole.class, id);
		
//		List<XtMenu> list = this.getHibernateDaoHelper().findByHql(hql, id);
//		System.out.println("****" + list.size());
		
		return this.getHibernateDaoHelper().findByHql(hql, id);
		
	}

	@Override
	public List<XtMenu> findMenusByParentId(String id) {
		
		String hql = "from XtMenu xm where xm.xtMenu.menuId = ?";
		
		return this.getHibernateDaoHelper().findByHql(hql, id);
		
	}

	@Override
	public boolean findIsLeafMenu(String id) {
		
		List<XtMenu> xtmenus = findMenusByParentId(id);
		
		if(xtmenus.size() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<XtMenu> findPageBySql(String hql, Page page) {
		String sqlCount = "select count(*) " + hql;
		long total = this.findTotalBySql(sqlCount);
		page.setTotal(total);
		return this.getHibernateDaoHelper().findPageBySql(hql,page.getPageNum(), page.getRows());
	}

	@Override
	public List<XtMenu> findMenusByResIdNULL() {
		
		String hql = "from XtMenu xm where xm.xtResource is null";
		return this.getHibernateDaoHelper().findByHql(hql, null);
	}

}

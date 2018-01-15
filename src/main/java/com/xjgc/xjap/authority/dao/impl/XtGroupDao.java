package com.xjgc.xjap.authority.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.xjgc.xjap.appframe.dao.impl.BaseDao;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.dao.IXtGroupDao;
import com.xjgc.xjap.authority.entity.XtGroup;

public class XtGroupDao extends BaseDao implements IXtGroupDao {

	@Override
	public void saveEntity(XtGroup xtgroup) {
		this.getHibernateDaoHelper().addEntity(xtgroup);
	}

	@Override
	public void updateEntity(XtGroup xtgroup) {
		this.getHibernateDaoHelper().updateEntity(xtgroup);
	}

	@Override
	public void deleteEntity(XtGroup xtgroup) {
		this.getHibernateDaoHelper().deleteEntity(xtgroup);
	}

	@Override
	public XtGroup findById(String groupId) {
		return this.getHibernateDaoHelper().getEntityByKey(XtGroup.class, groupId);
	}

	@Override
	public List<XtGroup> findGroups() {
//		String hql = "from XtGroup xtGroup order by groupName";
//		return this.getHibernateDaoHelper().findByHql(hql, null);
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtGroup.class);
		detachedCriteria.addOrder(Order.asc("groupName"));
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public List<XtGroup> findGroupByOrgId(String orgId) {
		String hql = "from XtGroup g where g.xtOrganization.orgId= ?";
		return this.getHibernateDaoHelper().findByHql(hql, orgId);
	}

	@Override
	public List<XtGroup> findByPage(int page, int rows) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtGroup.class);
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, page, rows);
	}

	@Override
	public Long findTotal() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtGroup.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}

	@Override
	public List<XtGroup> findPagesBySql(String hql, Page page) {
		String sqlCount = "select count(*) " + hql;
		long total = this.findTotalBySql(sqlCount);
		page.setTotal(total);
		return this.getHibernateDaoHelper().findPageBySql(hql,page.getPageNum(), page.getRows());
	}
	
	@Override
	public Long findTotalBySql(String sql) {
		 return this.getHibernateDaoHelper().getTotalBySql(sql);
	}

}

package com.xjgc.xjap.authority.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleCreateTableStatement.Organization;
import com.xjgc.xjap.appframe.dao.impl.BaseDao;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.dao.IXtOrganizationDao;
import com.xjgc.xjap.authority.entity.XtOrgType;
import com.xjgc.xjap.authority.entity.XtOrganization;

@Repository("xtOrganizationDao")
@Scope(value="prototype")
@SuppressWarnings("all")
public class XtOrganizationDao extends BaseDao implements IXtOrganizationDao {

	@Override
	public List<XtOrganization> findByPage(int page, int rows) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtOrganization.class);
		detachedCriteria.addOrder(Order.asc("orgName"));
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, page, rows);
	}

	@Override
	public Long findTotal() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtOrganization.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}

	@Override
	public List<XtOrganization> findAllOrg() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtOrganization.class);
		detachedCriteria.addOrder(Order.asc("orgName"));
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public List<XtOrganization> findSubOrgByParentOrgId(String parentOrgId) {
		String hql="from XtOrganization where xtOrganization.orgId= ?";
		return this.getHibernateDaoHelper().findByHql(hql, parentOrgId);
	}

	@Override
	public List<XtOrganization> findAllOrgType() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtOrgType.class);
		detachedCriteria.addOrder(Order.asc("orgTypeId"));
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public List<XtOrganization> findAllValidOrg() {
		String hql = "from XtOrganization org where orgIsInvalid='N' order by orgName";
		return this.getHibernateDaoHelper().findByHql(hql, null);
	}

	@Override
	public List<XtOrganization> findValidSubOrgByParentOrgId(String parentOrgId) {
		String hql="from XtOrganization where xtOrganization.orgId= ? and orgIsInvalid='N' order by orgName";
		return this.getHibernateDaoHelper().findByHql(hql, parentOrgId);
	}

	@Override
	public List<XtOrganization> findOrgsByFixQuery(String sql, String[] arg1, Object[] arg2) {
		return null;
	}

	@Override
	public void saveEntityOrg(XtOrganization org) {
		this.getHibernateDaoHelper().addEntity(org);
	}

	@Override
	public void updateEntityOrg(XtOrganization org) {
		this.getHibernateDaoHelper().updateEntity(org);
	}

	@Override
	public void deleteEntityOrg(XtOrganization org) {
		this.getHibernateDaoHelper().deleteEntity(org);
	}

	@Override
	public void deleteEntityOrgById(String id) {
		this.getHibernateDaoHelper().deleteEntityByKey(XtOrganization.class, id);
	}

	@Override
	public XtOrganization findOrgById(String id) {
		return this.getHibernateDaoHelper().getEntityByKey(XtOrganization.class, id);
	}

	@Override
	public List<XtOrganization> findPageBySql(String hql, Page page) {
		String sqlCount = "select count(*) " + hql;
		long total = this.findTotalBySql(sqlCount);
		page.setTotal(total);
		return this.getHibernateDaoHelper().findPageBySql(hql,page.getPageNum(), page.getRows());
	}
	
	@Override
	public Long findTotalBySql(String sql) {
		 return this.getHibernateDaoHelper().getTotalBySql(sql);
	}

	@Override
	public boolean findIsLeafDept(String orgId) {
//		String hql = "from XtDept xd where xd.xtDept.deptId='"+deptId+"'";
//		if(0 == this.getTotalBySql(hql))
//		{
//			return true;
//		}
//		
//		return false;
	String sql = "select * from XT_ORGANIZATION  where PARENT_ORG_ID  ='"+orgId+"'";
		
		List<Map<String,Object>> lists = this.getJdbcDaoHelper().query(sql);
		if(0 == lists.size())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public XtOrganization findRootOrganization() {
		String hql="from XtOrganization xorg where xorg.xtOrganization is null";
		return (XtOrganization)this.getHibernateDaoHelper().findByHql(hql, null).get(0);
	}

	@Override
	public Boolean isParentOrg(String orgId) {
		List<XtOrganization> orgs = this.findSubOrgByParentOrgId(orgId);
		if(orgs.size() == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}

}

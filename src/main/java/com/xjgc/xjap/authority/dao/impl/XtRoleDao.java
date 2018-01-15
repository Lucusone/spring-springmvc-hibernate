package com.xjgc.xjap.authority.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.BaseDao;
import com.xjgc.xjap.authority.dao.IXtRoleDao;
import com.xjgc.xjap.authority.entity.XtRole;
import com.xjgc.xjap.authority.entity.XtUser;

@Repository("xtRoleDao")
@Scope(value="prototype")
@SuppressWarnings("all")
public class XtRoleDao extends BaseDao implements IXtRoleDao {

	@Override
	public List<XtRole> findAllRole() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtRole.class);
		detachedCriteria.addOrder(Order.asc("roleName"));
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public Long findTotal() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtRole.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}
	
	@Override
	public List<XtRole> findByPage(int page, int rows) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtRole.class);
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, page, rows);
	}

	@Override
	public List<XtRole> findRoleByOrgId(String orgId) {
		String hql = "from XtRole r where r.xtOrganization.orgId = ? order by roleName";
		return this.getHibernateDaoHelper().findByHql(hql, orgId);
	}

	@Override
	public List<XtRole> findRoleByFixQuery(String sql, String[] arg1, Object[] arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<XtRole> findRoles(String orgId, String groupId) {
		String hql = "from XtRole r where r.xtOrganization.orgId= ? and r.xtGroup.groupId= ? order by roleName";
		return this.getHibernateDaoHelper().findByHql(hql, new String[]{orgId,groupId});
	}

	@Override
	public XtRole findRoleById(String roleId) {
		
		return this.getHibernateDaoHelper().getEntityByKey(XtRole.class, roleId);
	}

	@Override
	public void addEntityRole(XtRole role) {
		
		this.getHibernateDaoHelper().addEntity(role);
	}

	@Override
	public void updateEntityRole(XtRole role) {
		this.getHibernateDaoHelper().updateEntity(role);
	}

	@Override
	public void deleteEntityRole(XtRole role) {
		this.getHibernateDaoHelper().deleteEntity(role);
	}

	@Override
	public void deleteEntityRoleById(String roleId) {
		this.getHibernateDaoHelper().deleteEntityByKey(XtRole.class, roleId);
	}

	@Override
	public List<XtRole> findRolesByResId(String resId) {
		String hql = "from XtRole xr where xr.roleId = (select xtRole.roleId from XtPermAssign xpa where xpa.xtResource.resId = ?)";
		return this.getHibernateDaoHelper().findByHql(hql, resId);
	}

	@Override
	public List<XtRole> findRolesByCondition(String orgId, String search, String sort, String order, int pageNum,
			int rows) {
		
		StringBuffer hql  = new StringBuffer("from XtRole xtr");
		
		//根据当前用户的orgId来查找用户，即登录用户只能看到同一公司的用户,若orgId为null或空，则返回空
		if(null == orgId  || ("".equals(orgId)))
		{
			return new ArrayList<XtRole>();			
		}
		else
		{
			hql.append(" where xtr.xtOrganization.orgId = '"+orgId+"'");
		}
		
		//根据搜索条件search来模糊匹配页面上显示的所有字段
		if(null != search && !("".equals(search)))
		{
			search = "%"+search+"%";
			hql.append(" and  xtr.roleName like '"+search+"'");
		}
		if(null != sort && !("".equals(sort)))
		{
			hql.append("order by "+sort);
			if(null != order && !("".equals(order)))
			{
				//order 只能为asc或者desc
				if("asc".equals(order))
				{
					hql.append(" "+order);
				}
				else if("desc".equals(order))
				{
					hql.append(" "+order);
				}
			}
		}
		
		return this.getHibernateDaoHelper().findPageBySql(hql.toString(), pageNum, rows);
	}

	@Override
	public Long findTotalByCondition(String orgId, String search) {

		StringBuffer hql  = new StringBuffer("from XtRole xtr");
		
		//根据当前用户的orgId来查找用户，即登录用户只能看到同一公司的用户,若orgId为null或空，则返回空
		if(null == orgId  || ("".equals(orgId)))
		{
			return 0L;			
		}
		else
		{
			hql.append(" where xtr.xtOrganization.orgId = '"+orgId+"'");
		}
		
		//根据搜索条件search来模糊匹配页面上显示的所有字段
		if(null != search && !("".equals(search)))
		{
			search = "%"+search+"%";
			hql.append(" and  xtr.roleName like '"+search+"'");
		}
		
		return this.findTotalBySql(hql.toString());
	}

	@Override
	public Long findTotalBySql(String sql) {
		return this.getHibernateDaoHelper().getTotalBySql(sql,null);
	}

}

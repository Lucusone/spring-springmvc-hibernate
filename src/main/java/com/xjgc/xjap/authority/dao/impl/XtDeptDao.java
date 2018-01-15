package com.xjgc.xjap.authority.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.BaseDao;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.dao.IXtDeptDao;
import com.xjgc.xjap.authority.entity.XtDept;

@Repository("xtDeptDao")
@Scope(value="prototype")
public class XtDeptDao extends BaseDao implements IXtDeptDao {
 
	@Override
	public void saveEntity(XtDept xtDept) {
		this.getHibernateDaoHelper().addEntity(xtDept);
	}

	@Override
	public void deleteEntity(XtDept xtDept) {
		this.getHibernateDaoHelper().deleteEntity(xtDept);
	}

	

	@Override
	public void deleteEntityAll(List<XtDept> depts) {
		this.getHibernateDaoHelper().deleteEntities(depts);
	}

	@Override
	public void updateEntity(XtDept xtDept) {
		this.getHibernateDaoHelper().updateEntity(xtDept);
	}

	@Override
	public boolean findContains(XtDept xtDept) {
		return this.getHibernateDaoHelper().contains(xtDept);
	}

	@Override
	public XtDept findDeptById(String deptId) {
		return this.getHibernateDaoHelper().getEntityByKey(XtDept.class, deptId);
	}
	
	@Override
	public List<XtDept> findByPage(int page, int rows) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtDept.class);
		
		List<XtDept> lists = this.getHibernateDaoHelper().findByPage(detachedCriteria, page, rows);
		for(XtDept dept : lists)
		{
			System.out.println(dept.getDeptId());
		}
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, page, rows);
	}

	@Override
	public Long findTotal() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtDept.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}

	@Override
	public List<XtDept> findDeptByDeptId(String deptId) {
		String hql= "from XtDept dept where dept.xtDept.deptId= ?";
		return this.getHibernateDaoHelper().findByHql(hql, deptId);
	}

	@Override
	public List<XtDept> findDeptByOrgId(String orgId) {
		String hql= " from XtDept d where d.xtOrganization.orgId= ?";
		return this.getHibernateDaoHelper().findByHql(hql, orgId);
	}

	@Override
	public List<XtDept> findTopDeptByOrgId(String orgId) {
		String hql= "from XtDept dept where dept.xtDept is null and dept.xtOrganization.orgId= ?";
		return this.getHibernateDaoHelper().findByHql(hql, orgId);
	}

	@Override
	public List<XtDept> findPagesBySql(String hql, Page page) {
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
	public boolean deleteEntityByKey(String deptId) {
		
		if(findIsLeafDept(deptId))
		{
			this.getHibernateDaoHelper().deleteEntityByKey(XtDept.class, deptId);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean findIsLeafDept(String deptId) {
		
//		String hql = "from XtDept xd where xd.xtDept.deptId='"+deptId+"'";
//		if(0 == this.getTotalBySql(hql))
//		{
//			return true;
//		}
//		
//		return false;
	String sql = "select * from XT_DEPT where PARENT_DEPT_ID  ='"+deptId+"'";
		
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
	public List<XtDept> findAll() {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtDept.class);
		detachedCriteria.addOrder(Order.asc("deptId"));
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public List<XtDept> findDeptsByCondition(String orgId, String search, String sort, String order, int pageNum,
			int rows) {
		
		StringBuffer hql  = new StringBuffer("from XtDept xtd");
		
		//根据当前用户的orgId来查找部门，若orgId为null或空，则返回空
		if(null == orgId  || ("".equals(orgId)))
		{
			return new ArrayList<XtDept>();			
		}
		else
		{
			hql.append(" where xtd.xtOrganization.orgId = '"+orgId+"'");
		}
		
		//根据搜索条件search来模糊匹配下面四个字段
		if(null != search && !("".equals(search)))
		{
			search = "%"+search+"%";
			hql.append(" and  (xtd.deptName like '"+search+"'");
			hql.append(" or  xtd.deptTel like '"+search+"'");
			hql.append(" or  xtd.deptFax like '"+search+"'");
			hql.append(" or  xtd.deptAddr like '"+search+"')");
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
		
		StringBuffer hql  = new StringBuffer("from XtDept xtd");
		
		//根据当前用户的orgId来查找部门，若orgId为null或空，则返回空
		if(null == orgId  || ("".equals(orgId)))
		{
			return 0L;		
		}
		else
		{
			hql.append(" where xtd.xtOrganization.orgId = '"+orgId+"'");
		}
		
		//根据搜索条件search来模糊匹配下面四个字段
		if(null != search && !("".equals(search)))
		{
			search = "%"+search+"%";
			hql.append(" and  (xtd.deptName like '"+search+"'");
			hql.append(" or  xtd.deptTel like '"+search+"'");
			hql.append(" or  xtd.deptFax like '"+search+"'");
			hql.append(" or  xtd.deptAddr like '"+search+"')");
		}
		
		return this.findTotalBySql(hql.toString());
	}

}

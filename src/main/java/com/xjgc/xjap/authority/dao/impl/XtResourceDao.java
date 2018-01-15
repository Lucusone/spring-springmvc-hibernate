package com.xjgc.xjap.authority.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.BaseDao;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.dao.IXtResourceDao;
import com.xjgc.xjap.authority.entity.XtMenu;
import com.xjgc.xjap.authority.entity.XtOrganization;
import com.xjgc.xjap.authority.entity.XtResource;

@Repository("xtResDao")
@Scope(value="prototype")
@SuppressWarnings("all")
public class XtResourceDao extends BaseDao implements IXtResourceDao {

	@Override
	public List<XtResource> findAllResource() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtResource.class);
		detachedCriteria.addOrder(Order.asc("resName"));
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public Long findTotal() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtResource.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}

	@Override
	public List<XtResource> findByPage(int page, int rows) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtResource.class);
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, page, rows);
	}

	//待解决
	@Override
	public List<XtResource> findResByFixQuery(String sql, String[] arg1, Object[] arg2) {
		return null;
	}

	@Override
	public List<XtResource> findRessByClassId(String classId) {
		String hql = "from XtResource r where r.xtResClass.resClassId= ? order by resName";
		return this.getHibernateDaoHelper().findByHql(hql, classId);
	}

	@Override
	public List<XtResource> listValidRessByClassId(String classId) {
		String hql = "from XtResource r where r.xtResClass.resClassId= ? and r.resActive='Y'"
					+ " order by resName";
		return this.getHibernateDaoHelper().findByHql(hql, classId);
	}

	@Override
	public List<XtResource> listRessUseByMenuAndClassId(String classId) {
		String hql = "from XtResource xtResource where resActive='Y'"
				+ " and resUsebymenu='Y' " + " and xtResClass.resClassId= ? "
				+ " order by resName ";
		return this.getHibernateDaoHelper().findByHql(hql, classId);
	}

	@Override
	public List<XtResource> list(String resClassId, String resId, String resName, String resTypeId) {
		StringBuffer buffer = new StringBuffer("from XtResource r where 1 = 1 ");
		if (StringUtils.isNotBlank(resClassId)) {
			buffer.append("and r.xtResClass.resClassId = '").append(resClassId).append("' ");
		}
		if (StringUtils.isNotBlank(resId)) {
			buffer.append("and r.resId like '%").append(resId).append("%' ");
		}
		if (StringUtils.isNotBlank(resName)) {
			buffer.append("and r.resName like '%").append(resName).append("%' ");
		}
		if (StringUtils.isNotBlank(resTypeId)) {
			buffer.append("and r.xtResType.resTypeId = '").append(resTypeId).append("' ");
		}
		return this.getHibernateDaoHelper().findByHql(buffer.toString(), null);
	}

	@Override
	public void deleteEntityById(String resId) {
		this.getHibernateDaoHelper().deleteEntityByKey(XtResource.class, resId);
	}

	@Override
	public List<XtResource> findActive() {
		String hql = "from XtResource xtResource where resActive='Y' and resUsebymenu='Y' order by resName";
		return this.getHibernateDaoHelper().findByHql(hql, null);
	}

	@Override
	public XtResource findResById(String id) {
		return this.getHibernateDaoHelper().getEntityByKey(XtResource.class, id);
	}

	@Override
	public void addEntityRes(XtResource res) {

		this.getHibernateDaoHelper().addEntity(res);
	}

	@Override
	public void deleteEntityRes(XtResource res) {
		this.getHibernateDaoHelper().deleteEntity(res);
	}

	@Override
	public void deleteEntityResById(String id) {
		this.getHibernateDaoHelper().deleteEntityByKey(XtResource.class, id);
	}

	@Override
	public void updateEntityRes(XtResource res) {
		this.getHibernateDaoHelper().updateEntity(res);
	}

	@Override
	public List<XtResource> findPageBySql(String hql, Page page) {
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
	public List<XtResource> findResByRoleId(String roleId) {
		
		String hql = "select xtResource from XtPermAssign xpa where xpa.xtRole.roleId = ?";
		return this.getHibernateDaoHelper().findByHql(hql, roleId);
	}

}

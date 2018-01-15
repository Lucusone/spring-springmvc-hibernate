package com.xjgc.xjap.powerres.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.PowerResBaseDao;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.dao.IXtDistrictDao;
import com.xjgc.xjap.powerres.entity.District;

@Repository("xtDistrictDao")
@Scope(value="prototype")

public class XtDistrictDao extends PowerResBaseDao implements IXtDistrictDao{

	@Override
	public District getDistrictById(Integer Id) {
		// TODO Auto-generated method stub
		return this.getHibernateDaoHelper().getEntityByKey(District.class, Id);
	}

	@Override
	public List<District> find(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public List<District> listAllDistrict() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria= DetachedCriteria.forClass(District.class);
		detachedCriteria.addOrder(Order.asc("id"));
		return this.find(detachedCriteria);
	}

	@Override
	public List<District> findByPage(int pagenum, int rows) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(District.class);
		
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, pagenum, rows);
	}

	@Override
	public List<District> findBySql(String hql, Page page) {
		// TODO Auto-generated method stub
		String sqlCount = "select count(*) " + hql;
		long total = this.getTotalBySql(sqlCount);
		page.setTotal(total);
		return this.getHibernateDaoHelper().findPageBySql(hql,page.getPageNum(), page.getRows());
	}

	@Override
	public long getTatal() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(District.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}

	@Override
	public long getTotalBySql(String sql, Object...values) {
		return this.getHibernateDaoHelper().getTotalBySql(sql,values);
	}

	@Override
	public List<District> listByCompanyID(Integer companyId) {
		// TODO Auto-generated method stub
		String hql = "from District where companyId = ?";
		
		return this.getHibernateDaoHelper().findByHql(hql, new Integer[]{companyId});
	
	}

	@Override
	public long getTatal(int companyId) {
		
		String hql = "select count(*) from District where companyId = '"+companyId+"'";
		
		return this.getHibernateDaoHelper().getTotalBySql(hql);
	}



}

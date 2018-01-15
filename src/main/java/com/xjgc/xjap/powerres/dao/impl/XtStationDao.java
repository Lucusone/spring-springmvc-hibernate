package com.xjgc.xjap.powerres.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.PowerResBaseDao;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.dao.IXtStationDao;
import com.xjgc.xjap.powerres.entity.Station;

@Repository("xtStationDao")
@Scope(value="prototype")

public class XtStationDao extends PowerResBaseDao implements IXtStationDao{

	@Override
	public Station getStationById(Integer Id) {
		return this.getHibernateDaoHelper().getEntityByKey(Station.class, Id);
	}

	@Override
	public List<Station> find(DetachedCriteria detachedCriteria) {
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public List<Station> listAllStation() {
		DetachedCriteria detachedCriteria= DetachedCriteria.forClass(Station.class);
		detachedCriteria.addOrder(Order.asc("id"));
		return this.find(detachedCriteria);
	}

	@Override
	public List<Station> findByPage(int pagenum, int rows) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Station.class);
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, pagenum, rows);
	}

	@Override
	public List<Station> findBySql(String hql, Page page) {
		String sqlCount = "select count(*) " + hql;
		long total = this.getTotalBySql(sqlCount);
		page.setTotal(total);
		return this.getHibernateDaoHelper().findPageBySql(hql,page.getPageNum(), page.getRows());
	}

	@Override
	public long getTatal() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Station.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}

	@Override
	public long getTotalBySql(String sql) {
		return this.getHibernateDaoHelper().getTotalBySql(sql);
	}

	@Override
	public List<Station> listByDistrictID(Integer districtid) {
		String hql = "from Station where districtid = ?";
		return this.getHibernateDaoHelper().findByHql(hql, new Integer[]{districtid});
	}

	@Override
	public long getTatal(int districtId) {
		String hql = "select count(*) from Station where districtid = '"+districtId+"'";
		return this.getHibernateDaoHelper().getTotalBySql(hql);
	}

}

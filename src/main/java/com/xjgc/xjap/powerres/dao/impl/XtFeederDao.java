package com.xjgc.xjap.powerres.dao.impl;



import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.BaseDao;
import com.xjgc.xjap.appframe.dao.impl.PowerResBaseDao;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.dao.IXtFeederDao;
import com.xjgc.xjap.powerres.entity.Feeder;


@Repository("xtFeederDao")
@Scope(value="prototype")

public class XtFeederDao extends PowerResBaseDao implements IXtFeederDao{

	@Override
	public Feeder getFeederById(Integer Id) {
		// TODO Auto-generated method stub
		return this.getHibernateDaoHelper().getEntityByKey(Feeder.class, Id);
	}

	@Override
	public List<Feeder> find(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public List<Feeder> listAllFeeder() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Feeder.class);
		detachedCriteria.addOrder(Order.asc("id"));
		return this.find(detachedCriteria);
	}

	@Override
	public List<Feeder> findByPage(int pagenum, int rows) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Feeder.class);
		
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, pagenum, rows);
	}

	@Override
	public List<Feeder> findBySql(String hql, Page page) {
		// TODO Auto-generated method stub
		String sqlCount = "select count(*) " + hql;
		long total = this.getTotalBySql(sqlCount);
		page.setTotal(total);
		return this.getHibernateDaoHelper().findPageBySql(hql,page.getPageNum(), page.getRows());
	}

	@Override
	public long getTatal() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Feeder.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}

	@Override
	public long getTotalBySql(String sql) {
		// TODO Auto-generated method stub
		return this.getHibernateDaoHelper().getTotalBySql(sql);
	}

	@Override
	public List<Feeder> listByDistrictID(Integer districtId) {
		// TODO Auto-generated method stub
		String hql = "from Feeder where districtId = ?";
		
		return this.getHibernateDaoHelper().findByHql(hql, new Integer[]{districtId});
	}

	@Override
	public List<Feeder> listByStationID(Integer stationId) {
		// TODO Auto-generated method stub
		String hql = "from Feeder where stationId = ?";
		
		return this.getHibernateDaoHelper().findByHql(hql, new Integer[]{stationId});
	}

	@Override
	public long getTatal(int stationId) {
		
		String hql = "select count(*) from Feeder where stationId = '"+stationId+"'";
		
		return this.getHibernateDaoHelper().getTotalBySql(hql);
	}
	

}

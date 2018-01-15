package com.xjgc.xjap.powerres.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.PowerResBaseDao;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.dao.IXtBreakerDao;
import com.xjgc.xjap.powerres.entity.Breaker;

@Repository("xtBreakerDao")
@Scope(value="prototype")


public class XtBreakerDao extends PowerResBaseDao implements IXtBreakerDao{

	@Override
	public Breaker getBreakerById(Integer Id) {
		// TODO Auto-generated method stub
		return this.getHibernateDaoHelper().getEntityByKey(Breaker.class, Id);
	}

	@Override
	public List<Breaker> find(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public List<Breaker> listAllBreaker() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Breaker.class);
		detachedCriteria.addOrder(Order.asc("id"));
		return this.find(detachedCriteria);
	}

	@Override
	public List<Breaker> findByPage(int pagenum, int rows) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Breaker.class);
		
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, pagenum, rows);
	}

	@Override
	public List<Breaker> findBySql(String hql, Page page) {
		// TODO Auto-generated method stub
		String sqlCount = "select count(*) " + hql;
		long total = this.getTotalBySql(sqlCount);
		page.setTotal(total);
		return this.getHibernateDaoHelper().findPageBySql(hql,page.getPageNum(), page.getRows());
	}

	@Override
	public long getTatal() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Breaker.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}

	@Override
	public long getTotalBySql(String sql) {
		// TODO Auto-generated method stub
		return this.getHibernateDaoHelper().getTotalBySql(sql);
	}

	@Override
	public List<Breaker> listByFeederID(Integer feederId) {
		// TODO Auto-generated method stub
		String hql = "from Breaker where feederId = ?";
		
		return this.getHibernateDaoHelper().findByHql(hql, new Integer[]{feederId});
	}

	@Override
	public long getTatal(int feederId) {
		
		String hql = "select count(*) from Breaker where feederId = '"+feederId+"'";
		
		return this.getHibernateDaoHelper().getTotalBySql(hql);
	}

}

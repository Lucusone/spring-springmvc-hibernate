package com.xjgc.xjap.powerres.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.entity.Breaker;
import com.xjgc.xjap.powerres.entity.Feeder;

public interface IXtBreakerDao {
	
	public Breaker getBreakerById(Integer Id);
	
	public List<Breaker> find(DetachedCriteria detachedCriteria);
	
	public List<Breaker> listAllBreaker();
	
	public List<Breaker> findByPage(int pagenum, int rows);
	
	public List<Breaker> findBySql(String hql, Page page);
	
	public long getTatal(int feederId);
	
	public long getTatal();
	
	public long getTotalBySql(String sql);
	
	public List<Breaker> listByFeederID(Integer feederId);
	
	
	
	
	
	
	
}

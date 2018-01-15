package com.xjgc.xjap.powerres.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.entity.Breaker;
import com.xjgc.xjap.powerres.entity.Feeder;
import com.xjgc.xjap.powerres.entity.Station;

public interface IXtBreakerService {
	
	
	public Breaker getBreakerById(Integer Id);
	
	public List<Breaker> find(DetachedCriteria detachedCriteria);
	
	public List<Breaker> listAllBreaker();
	
	public List<Breaker> findByPage(int pagenum, int rows);
	
	public List<Breaker> findBySql(String hql, Page page);
	
	
	public long getTatal(Integer Id);
	public long getTatal();
	
	public long getTotalBySql(String sql);
	
	public List<Breaker> listByFeederID(Integer feederId);
	
	public List<Breaker> listPagesByFeederID(Integer feederId,int page,int rows,String order,String sort);

}

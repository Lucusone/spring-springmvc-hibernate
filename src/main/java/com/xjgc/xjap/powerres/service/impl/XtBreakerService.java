package com.xjgc.xjap.powerres.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.entity.Breaker;
import com.xjgc.xjap.powerres.service.IXtBreakerService;

@Service("xtBreakerService")
@Scope(value="prototype")
@Transactional
public class XtBreakerService extends BaseService implements IXtBreakerService{

	@Override
	public Breaker getBreakerById(Integer Id) {
		// TODO Auto-generated method stub
		return xtBreakerDao.getBreakerById(Id);
	}

	@Override
	public List<Breaker> find(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return xtBreakerDao.find(detachedCriteria);
	}

	@Override
	public List<Breaker> listAllBreaker() {
		// TODO Auto-generated method stub
		return xtBreakerDao.listAllBreaker();
	}

	@Override
	public List<Breaker> findByPage(int pagenum, int rows) {
		// TODO Auto-generated method stub
		return xtBreakerDao.findByPage(pagenum, rows);
	}

	@Override
	public List<Breaker> findBySql(String hql, Page page) {
		// TODO Auto-generated method stub
		return xtBreakerDao.findBySql(hql, page);
	}

	@Override
	public long getTatal() {
		// TODO Auto-generated method stub
		return xtBreakerDao.getTatal();
	}

	@Override
	public long getTotalBySql(String sql) {
		// TODO Auto-generated method stub
		return xtBreakerDao.getTotalBySql(sql);
	}

	@Override
	public List<Breaker> listByFeederID(Integer feederId) {
		// TODO Auto-generated method stub
		return xtBreakerDao.listByFeederID(feederId);
	}

	@Override
	public List<Breaker> listPagesByFeederID(Integer feederId, int page, int rows, String order, String sort) {
		// TODO Auto-generated method stub
		StringBuffer hql  = new StringBuffer("from Breaker where  feederId = '"+feederId+"' ");
		if(null != sort)
		{
			hql.append("order by "+sort);
			if(null != order)
			{
				hql.append(" "+order);
			}
		}
		
		return xtBreakerDao.findBySql(hql.toString(), new Page(page,rows));
	}

	@Override
	public long getTatal(Integer Id) {
		// TODO Auto-generated method stub
		return xtBreakerDao.getTatal(Id);
	}

}

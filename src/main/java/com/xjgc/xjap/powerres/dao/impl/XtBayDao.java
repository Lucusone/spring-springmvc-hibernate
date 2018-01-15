package com.xjgc.xjap.powerres.dao.impl;



import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.PowerResBaseDao;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.dao.IXtBayDao;
import com.xjgc.xjap.powerres.entity.Bay;


@Repository("xtBayDao")
@Scope(value="prototype")

public class XtBayDao extends PowerResBaseDao implements IXtBayDao{

	@Override
	public Bay getBayById(Integer Id) {
		// TODO Auto-generated method stub
		return this.getHibernateDaoHelper().getEntityByKey(Bay.class, Id);
	}

	@Override
	public List<Bay> find(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public List<Bay> listAllBay() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Bay.class);
		detachedCriteria.addOrder(Order.asc("id"));
		return this.find(detachedCriteria);
	}

	@Override
	public List<Bay> findByPage(int pagenum, int rows) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Bay.class);
		
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, pagenum, rows);
	}

	@Override
	public List<Bay> findBySql(String hql, Page page) {
		// TODO Auto-generated method stub
		String sqlCount = "select count(*) " + hql;
		long total = this.getTotalBySql(sqlCount);
		page.setTotal(total);
		return this.getHibernateDaoHelper().findPageBySql(hql,page.getPageNum(), page.getRows());
	}

	@Override
	public long getTatal() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Bay.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}

	@Override
	public long getTotalBySql(String sql) {
		// TODO Auto-generated method stub
		return this.getHibernateDaoHelper().getTotalBySql(sql);
	}

	@Override
	public List<Bay> listByDistrictID(Integer districtId) {
		// TODO Auto-generated method stub
		String hql = "from Bay where districtId = ?";
		
		return this.getHibernateDaoHelper().findByHql(hql, new Integer[]{districtId});
	}

	@Override
	public List<Bay> listByStationID(Integer stationId) {
		// TODO Auto-generated method stub
		String hql = "from Bay where stationId = ?";
		
		return this.getHibernateDaoHelper().findByHql(hql, new Integer[]{stationId});
	}

	@Override
	public long getTatal(int stationId) {
		
		String hql = "select count(*) from Bay where stationId = '"+stationId+"'";
		
		return this.getHibernateDaoHelper().getTotalBySql(hql);
	}
	

}

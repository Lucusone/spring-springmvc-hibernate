package com.xjgc.xjap.powerres.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.entity.Feeder;
import com.xjgc.xjap.powerres.service.IXtFeederService;


@Service("xtFeederService")
@Scope(value="prototype")
@Transactional
public class XtFeederService extends BaseService implements IXtFeederService{

	@Override
	public Feeder getFeederById(Integer Id) {
		// TODO Auto-generated method stub
		return xtFeederDao.getFeederById(Id);
	}

	@Override
	public List<Feeder> find(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return xtFeederDao.find(detachedCriteria);
	}

	@Override
	public List<Feeder> listAllFeeder() {
		// TODO Auto-generated method stub
		return xtFeederDao.listAllFeeder();
	}

	@Override
	public List<Feeder> findByPage(int pagenum, int rows) {
		// TODO Auto-generated method stub
		return xtFeederDao.findByPage(pagenum, rows);
	}

	@Override
	public List<Feeder> findBySql(String hql, Page page) {
		// TODO Auto-generated method stub
		return xtFeederDao.findBySql(hql, page);
	}

	@Override
	public long getTatal() {
		// TODO Auto-generated method stub
		return xtFeederDao.getTatal();
	}

	@Override
	public long getTotalBySql(String sql) {
		// TODO Auto-generated method stub
		return xtFeederDao.getTotalBySql(sql);
	}

	@Override
	public List<Feeder> listByDistrictID(Integer districtId) {
		// TODO Auto-generated method stub
		return xtFeederDao.listByDistrictID(districtId);
	}

	@Override
	public List<Feeder> listByStationID(Integer stationId) {
		// TODO Auto-generated method stub
		return xtFeederDao.listByStationID(stationId);
	}

	@Override
	public List<Feeder> listPagesByStationID(Integer stationId, int page, int rows, String order, String sort) {
		// TODO Auto-generated method stub
		StringBuffer hql  = new StringBuffer("from Feeder where  stationId = '"+stationId+"' ");
		if(null != sort)
		{
			hql.append("order by "+sort);
			if(null != order)
			{
				hql.append(" "+order);
			}
		}
		
		return xtFeederDao.findBySql(hql.toString(), new Page(page,rows));

	}

	@Override
	public long getTatal(Integer Id) {
		// TODO Auto-generated method stub
		return xtFeederDao.getTatal(Id);
	}

}

package com.xjgc.xjap.powerres.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.entity.Station;
import com.xjgc.xjap.powerres.service.IXtStationService;

@Service("xtStationService")
@Scope(value="prototype")
@Transactional

public class XtStationService extends BaseService implements IXtStationService{

	@Override
	public Station getStationById(Integer Id) {
		// TODO Auto-generated method stub
		return xtStationDao.getStationById(Id);
	}

	@Override
	public List<Station> find(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return xtStationDao.find(detachedCriteria);
	}

	@Override
	public List<Station> listAllStation() {
		// TODO Auto-generated method stub
		return xtStationDao.listAllStation();
	}

	@Override
	public List<Station> findByPage(int pagenum, int rows) {
		// TODO Auto-generated method stub
		return xtStationDao.findByPage(pagenum, rows);
	}

	@Override
	public List<Station> findBySql(String hql, Page page) {
		// TODO Auto-generated method stub
		return xtStationDao.findBySql(hql, page);
	}

	@Override
	public long getTatal() {
		// TODO Auto-generated method stub
		return xtStationDao.getTatal();
	}

	@Override
	public long getTotalBySql(String sql) {
		// TODO Auto-generated method stub
		return xtStationDao.getTotalBySql(sql);
	}

	@Override
	public List<Station> listByDistrictID(Integer districtId) {
		// TODO Auto-generated method stub
		return xtStationDao.listByDistrictID(districtId);
	}

	@Override
	public List<Station> listPagesByDistrictID(Integer districtId, int page, int rows, String order, String sort) {
		// TODO Auto-generated method stub
		StringBuffer hql  = new StringBuffer("from Station where  districtId = '"+districtId+"' ");
		if(null != sort)
		{
			hql.append("order by "+sort);
			if(null != order)
			{
				hql.append(" "+order);
			}
		}
		
		return xtStationDao.findBySql(hql.toString(), new Page(page,rows));
	}

	@Override
	public long getTatal(Integer id) {
		// TODO Auto-generated method stub
		return xtStationDao.getTatal(id);
	}

}

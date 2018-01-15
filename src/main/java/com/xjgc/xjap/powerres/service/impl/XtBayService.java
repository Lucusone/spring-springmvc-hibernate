package com.xjgc.xjap.powerres.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.entity.Bay;
import com.xjgc.xjap.powerres.entity.Feeder;
import com.xjgc.xjap.powerres.service.IXtBayService;
import com.xjgc.xjap.powerres.service.IXtFeederService;


@Service("xtBayService")
@Scope(value="prototype")
@Transactional
public class XtBayService extends BaseService implements IXtBayService{

	@Override
	public Bay getBayById(Integer Id) {
		// TODO Auto-generated method stub
		return xtBayDao.getBayById(Id);
	}

	@Override
	public List<Bay> find(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return xtBayDao.find(detachedCriteria);
	}

	@Override
	public List<Bay> listAllBay() {
		// TODO Auto-generated method stub
		return xtBayDao.listAllBay();
	}

	@Override
	public List<Bay> findByPage(int pagenum, int rows) {
		// TODO Auto-generated method stub
		return xtBayDao.findByPage(pagenum, rows);
	}

	@Override
	public List<Bay> findBySql(String hql, Page page) {
		// TODO Auto-generated method stub
		return xtBayDao.findBySql(hql, page);
	}

	@Override
	public long getTatal() {
		// TODO Auto-generated method stub
		return xtBayDao.getTatal();
	}

	@Override
	public long getTotalBySql(String sql) {
		// TODO Auto-generated method stub
		return xtBayDao.getTotalBySql(sql);
	}

	@Override
	public List<Bay> listByDistrictID(Integer districtId) {
		// TODO Auto-generated method stub
		return xtBayDao.listByDistrictID(districtId);
	}

	@Override
	public List<Bay> listByStationID(Integer stationId) {
		// TODO Auto-generated method stub
		return xtBayDao.listByStationID(stationId);
	}

	@Override
	public List<Bay> listPagesByStationID(Integer stationId, int page, int rows, String order, String sort) {
		// TODO Auto-generated method stub
		StringBuffer hql  = new StringBuffer("from Bay where  stationId = '"+stationId+"' ");
		if(null != sort)
		{
			hql.append("order by "+sort);
			if(null != order)
			{
				hql.append(" "+order);
			}
		}
		
		return xtBayDao.findBySql(hql.toString(), new Page(page,rows));

	}

	@Override
	public long getTatal(Integer Id) {
		// TODO Auto-generated method stub
		return xtBayDao.getTatal(Id);
	}

}

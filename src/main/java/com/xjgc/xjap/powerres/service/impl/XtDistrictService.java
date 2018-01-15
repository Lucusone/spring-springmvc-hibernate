package com.xjgc.xjap.powerres.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.entity.District;
import com.xjgc.xjap.powerres.service.IXtDistrictService;

@Service("xtDistrictService")
@Scope(value="prototype")
@Transactional

public class XtDistrictService extends BaseService implements IXtDistrictService{

	@Override
	public District getDistrictById(Integer Id) {
		// TODO Auto-generated method stub
		return xtDistrictDao.getDistrictById(Id);
	}

	@Override
	public List<District> find(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return xtDistrictDao.find(detachedCriteria);
	}

	@Override
	public List<District> listAllDistrict() {
		// TODO Auto-generated method stub
		return xtDistrictDao.listAllDistrict();
	}

	@Override
	public List<District> findByPage(int pagenum, int rows) {
		// TODO Auto-generated method stub
		return xtDistrictDao.findByPage(pagenum, rows);
	}

	@Override
	public List<District> findBySql(String hql, Page page) {
		// TODO Auto-generated method stub
		return xtDistrictDao.findBySql(hql, page);
	}

	@Override
	public long getTatal() {
		// TODO Auto-generated method stub
		return xtDistrictDao.getTatal();
	}

	@Override
	public long getTotalBySql(String sql, Object...values) {
		
		return xtDistrictDao.getTotalBySql(sql,values);
	}
	
	@Override
	public long getTotalBySql(String sql) {
		
		return xtDistrictDao.getTotalBySql(sql);
	}

	@Override
	public List<District> listByCompanyID(Integer companyId) {
		// TODO Auto-generated method stub
		return xtDistrictDao.listByCompanyID(companyId);
	}

	@Override
	public List<District> listPagesByCompanyID(Integer companyId, int page, int rows, String order, String sort) {
		// TODO Auto-generated method stub
		
		StringBuffer hql  = new StringBuffer("from District where  companyid = '"+companyId+"' ");
		if(null != sort)
		{
			hql.append("order by "+sort);
			if(null != order)
			{
				hql.append(" "+order);
			}
		}
		
		return xtDistrictDao.findBySql(hql.toString(), new Page(page,rows));
	}

	@Override
	public long getTatal(Integer companyId) {
		// TODO Auto-generated method stub
		return xtDistrictDao.getTatal(companyId);
	}

}

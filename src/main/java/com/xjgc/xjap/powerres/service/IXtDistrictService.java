package com.xjgc.xjap.powerres.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.entity.District;
import com.xjgc.xjap.powerres.entity.Station;

public interface IXtDistrictService {

	public District getDistrictById(Integer Id);
	
	public List<District> find(DetachedCriteria detachedCriteria);
	
	public List<District> listAllDistrict();
	
	public List<District> findByPage(int pagenum, int rows);
	
	public List<District> findBySql(String hql, Page page);
	
	public long getTatal(Integer companyId);
	
	public long getTatal();
	
	public long getTotalBySql(String sql, Object...values);
	
	public long getTotalBySql(String sql);
	
	public List<District> listByCompanyID(Integer companyId);
	
	public List<District> listPagesByCompanyID(Integer companyId,int page,int rows,String order,String sort);
	
}

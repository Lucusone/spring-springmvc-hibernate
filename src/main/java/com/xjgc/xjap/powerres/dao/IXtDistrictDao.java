package com.xjgc.xjap.powerres.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.entity.District;
import com.xjgc.xjap.powerres.entity.Station;

public interface IXtDistrictDao {

	public District getDistrictById(Integer Id);
	
	public List<District> find(DetachedCriteria detachedCriteria);
	
	public List<District> listAllDistrict();
	
	public List<District> findByPage(int pagenum, int rows);
	
	public List<District> findBySql(String hql, Page page);
	
	public long getTatal(int companyId);
	
	public long getTatal();
	
	public long getTotalBySql(String sql, Object...values);
	
	public List<District> listByCompanyID(Integer companyId);
	
	
	
	
	
}

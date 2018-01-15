package com.xjgc.xjap.powerres.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.entity.Feeder;
import com.xjgc.xjap.powerres.entity.Station;

public interface IXtStationService {

	public Station getStationById(Integer Id);
	
	public List<Station> find(DetachedCriteria detachedCriteria);
	
	public List<Station> listAllStation();
	
	public List<Station> findByPage(int pagenum, int rows);
	
	public List<Station> findBySql(String hql, Page page);
	
	public long getTatal(Integer id);
	
	public long getTatal();
	
	public long getTotalBySql(String sql);
	
	public List<Station> listByDistrictID(Integer districtId);
	
	public List<Station> listPagesByDistrictID(Integer districtId,int page,int rows,String order,String sort);
	
}

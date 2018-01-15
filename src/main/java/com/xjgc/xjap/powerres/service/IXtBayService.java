package com.xjgc.xjap.powerres.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.entity.Bay;
import com.xjgc.xjap.powerres.entity.Feeder;
import com.xjgc.xjap.powerres.entity.Station;

public interface IXtBayService {
	
	public Bay getBayById(Integer Id);
	
	public List<Bay> find(DetachedCriteria detachedCriteria);
	
	public List<Bay> listAllBay();
	
	public List<Bay> findByPage(int pagenum, int rows);
	
	public List<Bay> findBySql(String hql, Page page);
	
	public long getTatal(Integer Id);
	public long getTatal();
	
	public long getTotalBySql(String sql);
	
	public List<Bay> listByDistrictID(Integer districtId);
	
	public List<Bay> listByStationID(Integer stationId);
	
	public List<Bay> listPagesByStationID(Integer stationId,int page,int rows,String order,String sort);	
	
	
	
	
	
	
}

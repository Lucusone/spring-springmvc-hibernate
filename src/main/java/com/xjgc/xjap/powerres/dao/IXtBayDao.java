package com.xjgc.xjap.powerres.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.entity.Bay;
import com.xjgc.xjap.powerres.entity.Feeder;

public interface IXtBayDao {
	
	public Bay getBayById(Integer Id);
	
	public List<Bay> find(DetachedCriteria detachedCriteria);
	
	public List<Bay> listAllBay();
	
	public List<Bay> findByPage(int pagenum, int rows);
	
	public List<Bay> findBySql(String hql, Page page);
	
	public long getTatal(int stationId);
	
	public long getTatal();
	
	public long getTotalBySql(String sql);
	
	public List<Bay> listByDistrictID(Integer districtId);
	
	public List<Bay> listByStationID(Integer stationId);
	
	
	
	
	
	
	
}

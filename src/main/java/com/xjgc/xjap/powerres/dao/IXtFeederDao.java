package com.xjgc.xjap.powerres.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.powerres.entity.Feeder;

public interface IXtFeederDao {
	
	public Feeder getFeederById(Integer Id);
	
	public List<Feeder> find(DetachedCriteria detachedCriteria);
	
	public List<Feeder> listAllFeeder();
	
	public List<Feeder> findByPage(int pagenum, int rows);
	
	public List<Feeder> findBySql(String hql, Page page);
	
	public long getTatal(int stationId);
	
	public long getTatal();
	
	public long getTotalBySql(String sql);
	
	public List<Feeder> listByDistrictID(Integer districtId);
	
	public List<Feeder> listByStationID(Integer stationId);
	
	
	
	
	
	
	
}

package com.xjgc.xjap.authority.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xjgc.xjap.authority.entity.XtLogClass;

public interface IXtLogClassDao {

	public List<XtLogClass> findAll();
	
	public List<XtLogClass> find(DetachedCriteria detachedCriteria);
	
	public List<XtLogClass> findByPage(int pageNum, int rows);
	
	public long findTotal();
	
	public XtLogClass findXtLogClassById(String id);
	
	public void addEntity(XtLogClass logClass);
	
	public void deleteEntity(XtLogClass logClass);
	
	public void updateEntity(XtLogClass logClass);
	
}

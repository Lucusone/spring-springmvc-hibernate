package com.xjgc.xjap.authority.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xjgc.xjap.authority.entity.XtResClass;

public interface IXtResClassDao {

	public List<XtResClass> findAll();
	
	public List<XtResClass> find(DetachedCriteria detachedCriteria);
	
	public List<XtResClass> findByPage(int pageNum, int rows);
	
	public long findTotal();
	
	public XtResClass findXtResClassById(String id);
	
	public void addEntity(XtResClass resClass);
	
	public void deleteEntity(XtResClass resClass);
	
	public void updateEntity(XtResClass resClass);
	
}
 
package com.xjgc.xjap.authority.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xjgc.xjap.authority.entity.XtResType;

public interface IXtResTypeDao {

	public List<XtResType> findAll();
	
	public List<XtResType> find(DetachedCriteria detachedCriteria);
	
	public XtResType findXtResTypeById(String id);

	public List<XtResType> findByPage(int page, int rows);

	public long findTotal();

	public void addEntity(XtResType xtResType);

	public void updateEntity(XtResType restype);

	public void deleteEntity(XtResType resType);

}

package com.xjgc.xjap.authority.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xjgc.xjap.authority.entity.XtOperation;

public interface IXtOperationDao {

	public List<XtOperation> findAll();
	
	public List<XtOperation> find(DetachedCriteria detachedCriteria);
	
	public List<XtOperation> findByPage(int pageNum, int rows);
	
	public long findTotal();
	
	public XtOperation findXtOperationById(String id);
	
	public void addEntity(XtOperation operation);
	
	public void deleteEntity(XtOperation operation);
	
	public void updateEntity(XtOperation operation);
	
}
 
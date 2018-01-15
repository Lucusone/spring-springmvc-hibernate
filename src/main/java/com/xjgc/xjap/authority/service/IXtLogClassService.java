package com.xjgc.xjap.authority.service;

import java.util.List;

import com.xjgc.xjap.authority.entity.XtLogClass;

public interface IXtLogClassService {

	public List<XtLogClass> getAll();
	
	public XtLogClass getXtLogClassById(String id);
	
	public List<XtLogClass> getByPage(int page,int rows);
	
	public long getTotal();
	
	public void add(XtLogClass logClass);
	
	public void delete(XtLogClass logClass);
	
	public void update(XtLogClass logClass);
}

package com.xjgc.xjap.authority.service;

import java.util.List;

import com.xjgc.xjap.authority.entity.XtOperation;

public interface IXtOperationService {

	public List<XtOperation> getAll();
	
	public XtOperation getXtOperationById(String id);
	
	public List<XtOperation> getByPage(int page,int rows);
	
	public long getTotal();
	
	public void add(XtOperation operation);
	
	public void delete(XtOperation operation);
	
	public void update(XtOperation operation);
}
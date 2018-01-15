package com.xjgc.xjap.authority.service;

import java.util.List;

import com.xjgc.xjap.authority.entity.XtResType;

public interface IXtResTypeService {
	
	public List<XtResType> getAll();
	
	public XtResType getXtResTypeById(String id);

	public List<XtResType> getByPage(int offset, int limit);

	public Long getTotal();

	public void add(XtResType xtResType);

	public void update(XtResType restype);

	public void delete(XtResType resType);
	
}

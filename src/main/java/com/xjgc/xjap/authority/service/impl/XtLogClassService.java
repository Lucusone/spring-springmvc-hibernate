package com.xjgc.xjap.authority.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.authority.entity.XtLogClass;
import com.xjgc.xjap.authority.service.IXtLogClassService;

@Service("xtLogClassService")
@Scope(value="prototype")
@Transactional
public class XtLogClassService  extends BaseService implements IXtLogClassService{
	
	@Override
	public List<XtLogClass> getAll() {
		return xtLogClassDao.findAll();
	}

	@Override
	public XtLogClass getXtLogClassById(String id) {
		
		return xtLogClassDao.findXtLogClassById(id);
	}

	@Override
	public List<XtLogClass> getByPage(int page, int rows) {
		return xtLogClassDao.findByPage(page, rows);
	}

	@Override
	public long getTotal() {
		return xtLogClassDao.findTotal();
	}

	@Override
	public void add(XtLogClass logClass) {
		xtLogClassDao.addEntity(logClass);
	}

	@Override
	public void delete(XtLogClass logClass) {
		xtLogClassDao.deleteEntity(logClass);
	}

	@Override
	public void update(XtLogClass logClass) {
		xtLogClassDao.updateEntity(logClass);
	}
}

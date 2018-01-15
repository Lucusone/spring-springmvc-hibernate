package com.xjgc.xjap.authority.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.authority.entity.XtResType;
import com.xjgc.xjap.authority.service.IXtResTypeService;

@Service("xtResTypeService")
@Scope(value="prototype")
@Transactional
public class XtResTypeService  extends BaseService implements IXtResTypeService{

	@Override
	public List<XtResType> getAll() {
		return xtResTypeDao.findAll();
	}

	@Override
	public XtResType getXtResTypeById(String id) {
		
		return xtResTypeDao.findXtResTypeById(id);
	}

	@Override
	public List<XtResType> getByPage(int page, int rows) {
		return xtResTypeDao.findByPage(page, rows);
	}

	@Override
	public Long getTotal() {
		return xtResTypeDao.findTotal();
	}

	@Override
	public void add(XtResType xtResType) {
		xtResTypeDao.addEntity(xtResType);
		
	}

	@Override
	public void update(XtResType restype) {
		xtResTypeDao.updateEntity(restype);
		
	}

	@Override
	public void delete(XtResType resType) {
		xtResTypeDao.deleteEntity(resType);
	}

}

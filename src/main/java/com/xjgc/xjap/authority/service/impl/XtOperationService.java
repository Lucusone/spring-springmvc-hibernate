package com.xjgc.xjap.authority.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.authority.entity.XtOperation;
import com.xjgc.xjap.authority.service.IXtOperationService;

@Service("xtOperationService")
@Scope(value="prototype")
@Transactional
public class XtOperationService  extends BaseService implements IXtOperationService{

	@Override
	public List<XtOperation> getAll() {
		return xtOperationDao.findAll();
	}

	@Override
	public XtOperation getXtOperationById(String id) {
		
		return xtOperationDao.findXtOperationById(id);
	}

	@Override
	public List<XtOperation> getByPage(int page, int rows) {
		return xtOperationDao.findByPage(page, rows);
	}

	@Override
	public long getTotal() {
		return xtOperationDao.findTotal();
	}

	@Override
	public void add(XtOperation operation) {
		xtOperationDao.addEntity(operation);
	}

	@Override
	public void delete(XtOperation operation) {
		xtOperationDao.deleteEntity(operation);
	}

	@Override
	public void update(XtOperation operation) {
		xtOperationDao.updateEntity(operation);
	}

}

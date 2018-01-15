package com.xjgc.xjap.authority.dao.impl;

import java.rmi.server.Operation;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.BaseDao;
import com.xjgc.xjap.authority.dao.IXtOperationDao;
import com.xjgc.xjap.authority.entity.XtOperation;
import com.xjgc.xjap.authority.entity.XtUser;

@Repository("xtOperationDao")
@Scope(value="prototype")
@SuppressWarnings("all")
public class XtOperationDao extends BaseDao implements IXtOperationDao {

	@Override
	public List<XtOperation> findAll() {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtOperation.class);
		detachedCriteria.addOrder(Order.asc("operId"));
		return this.find(detachedCriteria);
		
	}
	
	@Override
	public List<XtOperation> find(DetachedCriteria detachedCriteria) {
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public XtOperation findXtOperationById(String id) {
		
		return this.getHibernateDaoHelper().getEntityByKey(XtOperation.class, id);
	}

	@Override
	public List<XtOperation> findByPage(int pageNum, int rows) {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtOperation.class);
		
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, pageNum, rows);
		
	}

	@Override
	public long findTotal() {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtOperation.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}

	@Override
	public void addEntity(XtOperation operation) {
		this.getHibernateDaoHelper().addEntity(operation);
	}

	@Override
	public void deleteEntity(XtOperation operation) {
		this.getHibernateDaoHelper().deleteEntity(operation);
	}

	@Override
	public void updateEntity(XtOperation operation) {
		this.getHibernateDaoHelper().updateEntity(operation);
	}

}

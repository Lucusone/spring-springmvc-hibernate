package com.xjgc.xjap.authority.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.BaseDao;
import com.xjgc.xjap.authority.dao.IXtLogClassDao;
import com.xjgc.xjap.authority.entity.XtLogClass;

@Repository("xtLogClassDao")
@Scope(value="prototype")
@SuppressWarnings("all")
public class XtLogClassDao extends BaseDao implements IXtLogClassDao {

	@Override
	public List<XtLogClass> findAll() {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtLogClass.class);
		detachedCriteria.addOrder(Order.asc("logClassId"));
		return this.find(detachedCriteria);
		
	}
	
	@Override
	public List<XtLogClass> find(DetachedCriteria detachedCriteria) {
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public XtLogClass findXtLogClassById(String id) {
		
		return this.getHibernateDaoHelper().getEntityByKey(XtLogClass.class, id);
	}

	@Override
	public List<XtLogClass> findByPage(int pageNum, int rows) {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtLogClass.class);
		
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, pageNum, rows);
		
	}

	@Override
	public long findTotal() {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtLogClass.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}

	@Override
	public void addEntity(XtLogClass logClass) {
		this.getHibernateDaoHelper().addEntity(logClass);
	}

	@Override
	public void deleteEntity(XtLogClass logClass) {
		this.getHibernateDaoHelper().deleteEntity(logClass);
	}

	@Override
	public void updateEntity(XtLogClass logClass) {
		this.getHibernateDaoHelper().updateEntity(logClass);
	}

}

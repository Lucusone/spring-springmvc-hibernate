package com.xjgc.xjap.authority.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.BaseDao;
import com.xjgc.xjap.authority.dao.IXtResClassDao;
import com.xjgc.xjap.authority.entity.XtResClass;
import com.xjgc.xjap.authority.entity.XtUser;

@Repository("xtResClassDao")
@Scope(value="prototype")
@SuppressWarnings("all")
public class XtResClassDao extends BaseDao implements IXtResClassDao {

	@Override
	public List<XtResClass> findAll() {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtResClass.class);
		detachedCriteria.addOrder(Order.asc("resClassId"));
		return this.find(detachedCriteria);
		
	}
	
	@Override
	public List<XtResClass> find(DetachedCriteria detachedCriteria) {
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public XtResClass findXtResClassById(String id) {
		
		return this.getHibernateDaoHelper().getEntityByKey(XtResClass.class, id);
	}

	@Override
	public List<XtResClass> findByPage(int pageNum, int rows) {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtResClass.class);
		
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, pageNum, rows);
		
	}

	@Override
	public long findTotal() {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtResClass.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}

	@Override
	public void addEntity(XtResClass resClass) {
		this.getHibernateDaoHelper().addEntity(resClass);
	}

	@Override
	public void deleteEntity(XtResClass resClass) {
		this.getHibernateDaoHelper().deleteEntity(resClass);
	}

	@Override
	public void updateEntity(XtResClass resClass) {
		this.getHibernateDaoHelper().updateEntity(resClass);
	}

}

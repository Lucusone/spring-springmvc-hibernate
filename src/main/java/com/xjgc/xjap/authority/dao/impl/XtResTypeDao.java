package com.xjgc.xjap.authority.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.BaseDao;
import com.xjgc.xjap.authority.dao.IXtResTypeDao;
import com.xjgc.xjap.authority.entity.XtResClass;
import com.xjgc.xjap.authority.entity.XtResType;

@Repository("xtResTypeDao")
@Scope(value="prototype")
@SuppressWarnings("all")
public class XtResTypeDao extends BaseDao implements IXtResTypeDao {

	@Override
	public List<XtResType> findAll() {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtResType.class);
		detachedCriteria.addOrder(Order.asc("resTypeId"));		
		return this.find(detachedCriteria);
	}

	@Override
	public List<XtResType> find(DetachedCriteria detachedCriteria) {
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public XtResType findXtResTypeById(String id) {
		return this.getHibernateDaoHelper().getEntityByKey(XtResType.class, id);
	}

	@Override
	public List<XtResType> findByPage(int pageNum, int rows) {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtResType.class);
		
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, pageNum, rows);
		
	}

	@Override
	public long findTotal() {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtResType.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}

	@Override
	public void addEntity(XtResType xtResType) {
		this.getHibernateDaoHelper().addEntity(xtResType);
	}

	@Override
	public void updateEntity(XtResType restype) {
		this.getHibernateDaoHelper().updateEntity(restype);
	}

	@Override
	public void deleteEntity(XtResType resType) {
		this.getHibernateDaoHelper().deleteEntity(resType);
	}

}

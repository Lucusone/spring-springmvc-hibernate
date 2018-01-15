package com.xjgc.xjap.authority.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.BaseDao;
import com.xjgc.xjap.authority.dao.IXtLogDao;
import com.xjgc.xjap.authority.entity.XtLog;

@Repository("xtLogDao")
@Scope(value="prototype")
@SuppressWarnings("all")
public class XtLogDao extends BaseDao implements IXtLogDao {
	
	@Override
	public List<XtLog> findAll() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtLog.class);
		detachedCriteria.addOrder(Order.asc("xtOplogid"));
		return this.find(detachedCriteria);	
	}
	
	@Override
	public List<XtLog> find(DetachedCriteria detachedCriteria) {
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}
	
	@Override
	public XtLog findXtLogById(String id) {
		
		return this.getHibernateDaoHelper().getEntityByKey(XtLog.class, id);
	}
	
	@Override
	public List<XtLog> findByPage(int pageNum, int rows) {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtLog.class);
		
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, pageNum, rows);
	
	}
	
	@Override
	public long findTotal() {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtLog.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}
	
	@Override
	public void saveEntity(XtLog log) {
		this.getHibernateDaoHelper().addEntity(log);
	}

	@Override
	public void deleteEntityById(String logId) {
		this.getHibernateDaoHelper().deleteEntityByKey(XtLog.class, logId);
	}

	@Override
	public void deleteEntityByUser(String userId) {
		String hql = "delete XtLog log where log.xtUser.userId = '"+userId+"'";
		this.getHibernateDaoHelper().executeHQL(hql);
	}

	@Override
	public List<XtLog> findForBatch(Date beginDate, Date endDate, String userId, String logClassId, int firstResult,
			int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEntityBatch(List<XtLog> logs) {
		this.getHibernateDaoHelper().deleteEntities(logs);
	}

	@Override
	public void deleteEntity(XtLog log) {
		this.getHibernateDaoHelper().deleteEntity(log);
	}
	
}

package com.xjgc.xjap.authority.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xjgc.xjap.authority.entity.XtLog;

public interface IXtLogDao {
	
	public List<XtLog> findAll();
	
	public List<XtLog> find(DetachedCriteria detachedCriteria);
	
	public List<XtLog> findByPage(int pageNum, int rows);
	
	public long findTotal();
	
	public void deleteEntity(XtLog log);

	public void saveEntity(XtLog log);
	
	public XtLog findXtLogById(String id);
	
	public void deleteEntityById(String logId);
	
	/**
	 * 清空指定用户的系统日志
	 * 
	 * @param userId
	 */
	public void deleteEntityByUser(String userId);
	
	/**
	 * 可选是否分页
	 * 
	 * @param beginDate
	 * @param endDate
	 * @param userId
	 * @param logClassId
	 * @return
	 */
	//List<XtLog> list(Date beginDate, Date endDate, String userId,
			//String logClassId, PageSortModel psm);
	
	/**
	 * 分批获取数据，用于批量删除
	 * 
	 * @param beginDate
	 * @param endDate
	 * @param userId
	 * @param logClassId
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<XtLog> findForBatch(Date beginDate, Date endDate, String userId,
			String logClassId, int firstResult, int maxResults);
	
	/**
	 * 批量删除
	 * 
	 * @param logs
	 */
	public void deleteEntityBatch(List<XtLog> logs);
	
}

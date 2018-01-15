package com.xjgc.xjap.authority.service;

import java.util.Date;
import java.util.List;

import com.xjgc.xjap.authority.entity.XtLog;
import com.xjgc.xjap.authority.entity.XtUser;

public interface IXtLogService {

	public List<XtLog> getAll();
	
	public XtLog getXtLogById(String id);
	
	public List<XtLog> getByPage(int page,int rows);
	
	public long getTotal();
	
	public void delete(XtLog log);
	
	public void save(XtLog log);
	
	public void deleteById(String logId);
	
	public void deleteByUser(String userId);
	
	public List<XtLog> listForBatch(Date beginDate, Date endDate, String userId,
			String logClassId, int firstResult, int maxResults);
	
	public void deleteBatch(List<XtLog> logs);
	
	public void addLog(XtUser xtUser, String clientIp, String description,String clientHostName);
}

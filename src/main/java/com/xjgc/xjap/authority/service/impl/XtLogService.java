package com.xjgc.xjap.authority.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.authority.entity.XtLog;
import com.xjgc.xjap.authority.entity.XtUser;
import com.xjgc.xjap.authority.service.IXtLogService;
import com.xjgc.xjap.utils.UUIDTool;

@Service("xtLogService")
@Scope(value="prototype")
@Transactional
public class XtLogService  extends BaseService implements IXtLogService{

	public List<XtLog> getAll(){
		return xtLogDao.findAll();
	}
	
	public XtLog getXtLogById(String id){
		
		return xtLogDao.findXtLogById(id);
	}
	
	public List<XtLog> getByPage(int page,int rows){
		return xtLogDao.findByPage(page, rows);
	}
	
	public long getTotal(){
		return xtLogDao.findTotal();
	}
	
	@Override
	public void delete(XtLog log) {
		xtLogDao.deleteEntity(log);
	}
	
	public void save(XtLog log){
		xtLogDao.saveEntity(log);
	}
	
	public void deleteById(String logId){
		xtLogDao.deleteEntityById(logId);
	}
	
	public void deleteByUser(String userId){
		xtLogDao.deleteEntityByUser(userId);
	}
	
	public List<XtLog> listForBatch(Date beginDate, Date endDate, String userId,
			String logClassId, int firstResult, int maxResults){
		return null;
	}
	
	public void deleteBatch(List<XtLog> logs){
		xtLogDao.deleteEntityBatch(logs);
	}

	@Override
	public void addLog(XtUser xtUser, String clientIp, String description, String clientHostName) {
		
		XtLog log = new XtLog();
		
		log.setXtOplogid(UUIDTool.getUUID());
		log.setXtOplogipaddress(clientIp);
		log.setXtOplogcomputer(clientHostName);
		log.setXtOplogtime(new Timestamp(new Date().getTime()));
		
		//操作类型
		//log.setXtLogClass(new XtLogClass());
		
		//操作描述
		log.setXtOplogdescribe(description);
		
		log.setXtUser(xtUser);
		
		this.save(log);
	}
}

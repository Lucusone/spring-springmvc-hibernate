package com.xjgc.xjap.authority.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.entity.XtResource;
import com.xjgc.xjap.authority.service.IXtResourceService;

@Service("xtResourceService")
@Scope(value="prototype")
@Transactional
public class XtResourceService extends BaseService implements IXtResourceService {

	@Override
	public List<XtResource> getAllResource() {
		return xtResDao.findAllResource();
	}

	@Override
	public List<XtResource> getResourcesByPage(int pageNum, int rows, Page page) {
		return xtResDao.findByPage(pageNum, rows);
	}

	@Override
	public List<XtResource> getResourcesByPageAndSql(String sql, Page page) {
		return null;
	}

	@Override
	public List<XtResource> getXtResourceByPage(int page, int rows) {
		return xtResDao.findByPage(page, rows);
	}

	@Override
	public long getResourceTotal() {
		return xtResDao.findTotal();
	}

	@Override
	public void save(XtResource res) {
		
		xtResDao.addEntityRes(res);
	
	}

	@Override
	public void update(XtResource res) {
		xtResDao.updateEntityRes(res);
	}

	@Override
	public void delete(XtResource res) {
		xtResDao.deleteEntityRes(res);
	}

	@Override
	public XtResource getResourceById(String resId) {
		return xtResDao.findResById(resId);
	}

	@Override
	public void deleteById(String id) {
		
		xtResDao.deleteEntityById(id);
		
	}

	@Override
	public Long getTotalResByClassId(String classId) {
		
		String hql = "select count(*) from XtResource xr where xr.xtResClass.resClassId ='"+classId+"' ";
		
		return xtMenuDao.findTotalBySql(hql);
	}

	@Override
	public List<XtResource> getPageResByClassId(String classId, int page, int rows, String sort, String order) {
		
		StringBuffer hql  = new StringBuffer("from XtResource xr where xr.xtResClass.resClassId = '"+classId+"' ");
		if(null != sort)
		{
			hql.append("order by "+sort);
			if(null != order)
			{
				hql.append(" "+order);
			}
		}
		
		return xtResDao.findPageBySql(hql.toString(),  new Page(page,rows) );
	}

	@Override
	public List<XtResource> getResByRoleId(String roleId) {
		return xtResDao.findResByRoleId(roleId);
	}
	
	@Override
	public List<String> getResUrlByRoleId(String roleId) {
		
		List<String> resUrlList = new ArrayList<String>();
		List<XtResource> res = this.getResByRoleId(roleId);
		
		for (XtResource xtResource : res) {
			resUrlList.add(xtResource.getResUrl());
		}
		
		return resUrlList;
	} 

}

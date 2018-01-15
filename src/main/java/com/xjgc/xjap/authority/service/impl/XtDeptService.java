package com.xjgc.xjap.authority.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.entity.XtDept;
import com.xjgc.xjap.authority.service.IXtDeptService;
import com.xjgc.xjap.utils.JsonTool;

@Service("xtDeptService")
@Scope(value="prototype")
@Transactional
public class XtDeptService extends BaseService implements IXtDeptService{

	@Override
	public void add(XtDept xtdept) {
		xtDeptDao.saveEntity(xtdept);
	}

	@Override
	public boolean deleteById(String deptId) {
		return xtDeptDao.deleteEntityByKey(deptId);
	}

	@Override
	public XtDept getXtDeptById(String deptId) {
		return xtDeptDao.findDeptById(deptId);
	}

	@Override
	public void update(XtDept xtdept) {
		xtDeptDao.updateEntity(xtdept);
	}

	@Override
	public Long getTotal() {
		return xtDeptDao.findTotal();
	}
	
	@Override
	public Long getTotalByOrgIdOrParId(String orgId, String parId) {
		
		String hql = null;
		System.out.println(orgId);
		System.out.println(parId);
		if(parId.equals("null") || parId.equals("") || parId.equals("01root"))
		{
			hql = "select count(*) from XtDept xd where  xd.xtOrganization.orgId = '"+orgId+"' ";
		}
		else
		{
			hql = "select count(*) from XtDept xd where  xd.xtDept.deptId = '"+parId+"' ";
		}
		 
		
		return xtDeptDao.findTotalBySql(hql);
	}
	
	@Override
	public List<XtDept> getPagesByOrgId(String orgId, int page, int rows, String order, String sort) {
		
		StringBuffer hql  = new StringBuffer("from XtDept xd where  xd.xtOrganization.orgId = '"+orgId+"' ");
		if(null != sort)
		{
			hql.append("order by "+sort);
			if(null != order)
			{
				hql.append(" "+order);
			}
		}
		
		return xtDeptDao.findPagesBySql(hql.toString(), new Page(page,rows));
	}

	@Override
	public List<XtDept> getPagesByParId(String parId, int page, int rows, String order, String sort) {
		StringBuffer hql  = new StringBuffer("from XtDept xd where xd.xtDept.deptId = '"+parId+"' ");
		if(null != sort)
		{
			hql.append("order by "+sort);
			if(null != order)
			{
				hql.append(" "+order);
			}
		}
		
		return xtDeptDao.findPagesBySql(hql.toString(), new Page(page,rows));
	}

	@Override
	public List<XtDept> getPagesByOrgIdOrByParId(String orgId, String deptId, int page, int rows, String order,
			String sort) {
		
		XtDept dept = this.getXtDeptById(deptId);
		
		if(null == dept || dept.getXtDept() == null)
		{
			return this.getPagesByOrgId(orgId, page, rows, order, sort);
		}
		
		return this.getPagesByParId(deptId, page, rows, order, sort);
	}

	@Override
	public List<XtDept> getPages(int page, int rows) {
		return null;
	}

	@Override
	public String getDeptTreeByOrgId(String orgId) {
		
		List<XtDept> depts = xtDeptDao.findDeptByOrgId(orgId);
		List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
		
		for(XtDept dept : depts)
		{
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", dept.getDeptId());
			if(dept.getXtDept() == null)
			{
				map.put("pId", null);
			}
			else
			{
				map.put("pId", dept.getXtDept().getDeptId());
			}
			
			if(dept.getXtOrganization() == null)
			{
				map.put("orgId", null);
			}
			else
			{
				map.put("orgId", dept.getXtOrganization().getOrgId());
			}
			
			map.put("name",  dept.getDeptName());
			map.put("open", true);
			
			lists.add(map);
			
		}
		return JsonTool.Obj2Json(lists);
	}

	@Override
	public List<XtDept> getAll() {
		
		return xtDeptDao.findAll();
	}

	@Override
	public boolean getIsLeafDept(String deptId) {
		return xtDeptDao.findIsLeafDept(deptId);
	}

	@Override
	public List<XtDept> getDeptsByCondition(String orgId, String search, String sort, String order, int pageNum,
			int rows) {
		return xtDeptDao.findDeptsByCondition(orgId, search, sort, order, pageNum, rows);
	}

	@Override
	public Long getTotalByCondition(String orgId, String search) {
		
		return xtDeptDao.findTotalByCondition(orgId, search);
	}

}

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
import com.xjgc.xjap.authority.entity.XtOrganization;
import com.xjgc.xjap.authority.service.IXtOrgService;
import com.xjgc.xjap.utils.JsonTool;

@Service("xtOrgService")
@Scope(value="prototype")
@Transactional
public class XtOrgService extends BaseService implements IXtOrgService {

	@Override
	public List<XtOrganization> getAllOrganization() {
		
		return xtOrgDao.findAllOrg();
	}

	@Override
	public List<XtOrganization> getOrgsByPage(int pageNum, int rows, Page page) {
		
		return xtOrgDao.findByPage(pageNum, rows);
	}

	@Override
	public List<XtOrganization> getOrgsByPageAndSql(String sql, Page page) {
		return null;
	}

	@Override
	public List<XtOrganization> getOrgsByPage(int page, int rows) {

		return xtOrgDao.findByPage(page, rows);
	}

	@Override
	public long getOrgTotal() {

		return xtOrgDao.findTotal();
	}

	@Override
	public void save(XtOrganization org) {
		
		xtOrgDao.saveEntityOrg(org);
	}

	@Override
	public void update(XtOrganization org) {
		xtOrgDao.updateEntityOrg(org);
	}

	@Override
	public void delete(XtOrganization org) {
		xtOrgDao.deleteEntityOrg(org);
	}

	@Override
	public void deleteById(String id) {
		
		xtOrgDao.deleteEntityOrgById(id);
	}

	@Override
	public XtOrganization getOrganizationById(String orgId) {
		
		return xtOrgDao.findOrgById(orgId);
	}
	
	//查询公司树
		@Override
		public String getOrgTree() {
			
			List<XtOrganization> orgs = xtOrgDao.findAllOrg();
			List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
			
			for(XtOrganization org : orgs)
			{
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("id", org.getOrgId());
				if(org.getXtOrganization() == null)
				{
					map.put("pId", null);
				}
				else
				{
					map.put("pId", org.getXtOrganization().getOrgId());
				}
				
				map.put("name",  org.getOrgName());
				map.put("open", true);
				
				lists.add(map);
				
			}
			return JsonTool.Obj2Json(lists);
		}
		
		@Override
		public List<XtOrganization> getPageOrgs(String pId,int page, int rows, String sort,String order) {
			
			StringBuffer hql  = new StringBuffer("from XtOrganization xo where xo.xtOrganization.orgId = '"+pId+"' ");
			if(null != sort)
			{
				hql.append("order by "+sort);
				if(null != order)
				{
					hql.append(" "+order);
				}
			}
			
			return xtOrgDao.findPageBySql(hql.toString(), new Page(page,rows));
		}

		@Override
		public Long getTotalOrgs(String orgId) {
			
			String hql = "select count(*) from XtOrganization xo where  xo.xtOrganization.orgId = '"+orgId+"' ";
			
			return xtOrgDao.findTotalBySql(hql);
		}

		@Override
		public boolean getIsLeafDept(String orgId) {
			return xtOrgDao.findIsLeafDept(orgId);
		}

		@Override
		public XtOrganization getXtOrgById(String orgId) {
			
			return xtOrgDao.findOrgById(orgId);
		}

		@Override
		public void add(XtOrganization xtorg) {
			xtOrgDao.saveEntityOrg(xtorg);
		}

		@Override
		public XtOrganization getRootOrganization() {
			
			return xtOrgDao.findRootOrganization();
		}

		@Override
		public List<XtOrganization> getTopChildrenByOrgId(String orgId) {
			
			return xtOrgDao.findSubOrgByParentOrgId(orgId);
		}

		@Override
		public String getAsyncTreeByOrgId(String orgId) {
			
			List<XtOrganization> orgs = this.getTopChildrenByOrgId(orgId);
			//将orgId对应的公司,加入到公司树中。
			//orgs.add(xtOrgDao.findOrgById(orgId));
			
			List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();
			
			for(XtOrganization org : orgs)
			{
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("id", org.getOrgId());
				if(org.getXtOrganization() == null)
				{
					map.put("pId", null);
				}
				else
				{
					map.put("pId", org.getXtOrganization().getOrgId());
				}
				map.put("isParent", this.isParentOrg(org.getOrgId()));
				map.put("name",  org.getOrgName());
				map.put("open", true);
				
				lists.add(map);
				
			}
			
			
			return JsonTool.Obj2Json(lists);
		}

		@Override
		public Boolean isParentOrg(String orgId) {
			return xtOrgDao.isParentOrg(orgId);
		}		

}

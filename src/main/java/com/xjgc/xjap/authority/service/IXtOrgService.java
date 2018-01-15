package com.xjgc.xjap.authority.service;

import java.util.List;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.entity.XtOrganization;

public interface IXtOrgService {

	public List<XtOrganization> getAllOrganization();
	
	public List<XtOrganization> getOrgsByPage(int pageNum, int rows, Page page);
	
	public List<XtOrganization> getOrgsByPageAndSql(String sql, Page page);
	
	List<XtOrganization> getOrgsByPage(int page, int rows);
	
	public long getOrgTotal();
	
	public void save(XtOrganization org);
	
	public void update(XtOrganization org);
	
	public void delete(XtOrganization org);
	
	public void deleteById(String id);
	
	public XtOrganization getOrganizationById(String orgId);
	
	//查询公司树
	public String getOrgTree();
	
	//根据parentId,来获得分页查询的结果
	public List<XtOrganization> getPageOrgs(String orgId ,int page, int rows,String order,String sort);
	
	//根据parentId,获得记录的总数
	public Long getTotalOrgs(String orgId);

	public boolean getIsLeafDept(String orgId);

	public XtOrganization getXtOrgById(String orgId);
	
	public XtOrganization getRootOrganization();

	public void add(XtOrganization xtorg);
	
	//根据orgId来获得以该orgId为根的第一代孩子
	public List<XtOrganization> getTopChildrenByOrgId(String orgId);
	
	//获得以orgId为根的公司异步树,返回的结果适合ztree
	public String getAsyncTreeByOrgId(String orgId);
	
	//判断公司是否有子公司
	public Boolean isParentOrg(String orgId);
}

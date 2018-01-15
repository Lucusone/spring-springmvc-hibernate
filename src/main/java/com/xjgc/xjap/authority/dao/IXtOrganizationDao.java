package com.xjgc.xjap.authority.dao;

import java.util.List;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.entity.XtOrganization;

public interface IXtOrganizationDao {

	public List<XtOrganization> findByPage(int page, int rows);
	public Long findTotal();
	public List<XtOrganization> findAllOrg();
	
	/**
	 * 返回子级组织
	 * @param parentOrgId
	 * @return
	 */
	public List<XtOrganization> findSubOrgByParentOrgId(String parentOrgId);
	
	public List<XtOrganization> findAllOrgType();
	
	public List<XtOrganization> findAllValidOrg();
	
	public List<XtOrganization> findValidSubOrgByParentOrgId(String parentOrgId);
	
	public List<XtOrganization> findOrgsByFixQuery(String sql,String[] arg1,Object[] arg2 );
	
	public void saveEntityOrg(XtOrganization org);
	
	public void updateEntityOrg(XtOrganization org);
	
	public void deleteEntityOrg(XtOrganization org);
	
	public void deleteEntityOrgById(String id);
	
	public XtOrganization findOrgById(String id);
	
	//分页
	public List<XtOrganization> findPageBySql(String sql ,Page page);
	
	public Long findTotalBySql(String orgId);
	
	public boolean findIsLeafDept(String orgId);
	
	public XtOrganization findRootOrganization();
	
	public Boolean isParentOrg(String orgId);
	
}

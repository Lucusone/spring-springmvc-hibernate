package com.xjgc.xjap.authority.service;

import java.util.List;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.entity.XtUser;

public interface IXtUserService {

	public List<XtUser> getAllUser();
	
	public XtUser getLogin(String username,String password);
	
	public List<XtUser> getUsersByPage(int pageNum, int rows, Page page);
	
	public List<XtUser> getUsersByPageAndSql(String sql, Page page);
	
	List<XtUser> getUserByPage(int page, int rows);
	
	public long getUserTotal();
	
	public void save(XtUser xtUser);
	
	public void update(XtUser xtUser);
	
	public void delete(XtUser xtUser);
	
	public XtUser getUserById(String userId);
	
	public List<XtUser> getUsersByRoleId(String roleId,String sort,String order,int pageNum,int rows);
	
	public Long getTotalByRoleId(String roleId);
	
	//根据条件来获得分页查询的结果,条件有:
	public List<XtUser> getUsersByCondition(String orgId,String search,String sort,String order,int pageNum,int rows);
	
	//根据条件来获得总的记录数
	public Long getTotalsByCondition(String orgId,String search);
	
}

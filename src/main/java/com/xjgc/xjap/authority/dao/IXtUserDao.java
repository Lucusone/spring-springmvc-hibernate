package com.xjgc.xjap.authority.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.entity.XtUser;

public interface IXtUserDao {
	
	public void saveEntity(XtUser xtUser);
	
	public void deleteEntity(XtUser xUser);
	
	public void deleteEntityByKey(String userId);
	
	public void deleteEntityAll(List<XtUser> users);
	
	public void updateEntity(XtUser xtUser);
	
	public boolean findContains(XtUser xtUser);
	
	public XtUser findUserById(String userId);
	
	public List<XtUser> find(DetachedCriteria detachedCriteria);
	
	public List<XtUser> findUserResourceByType(String userId,String resourceTypeId);
	
	public List<XtUser> findUserByOrgId(String orgId);
	
	//check用户是否存在
	public boolean findCheckUser(String userId, String password);
	
	//查询所有用户
	public List<XtUser> findAllUser();
	
	//分页查询
	public List<XtUser> findByPage(int pagenum, int rows);
	public List<XtUser> findPageBySql(String hql, Page page);
	
	//获取记录总数
	public long findTotal();
	public Long findTotalBySql(String sql);
	
	//登录，根据用户名来查询
	public XtUser findUserByName(String username);
	
	//根据roleId来获得用户列表
	public List<XtUser> findUsersByRoleId(String roleId,String sort,String order,int pageNum,int rows);
	
	//根据条件来获得user列表，条件有：查询条件，排序，分页,当前登录用户的orgId
	public List<XtUser> findUsersByCondition(String orgId,String search,String sort,String order,int pageNum,int rows);
	
	//根据条件获得总记录数
	public Long findTotalByCondition(String orgId,String search);
	
}

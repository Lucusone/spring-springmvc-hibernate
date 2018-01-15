package com.xjgc.xjap.authority.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.dao.impl.BaseDao;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.dao.IXtUserDao;
import com.xjgc.xjap.authority.entity.XtUser;
import com.xjgc.xjap.utils.DateTool;
import com.xjgc.xjap.utils.ObjectTool;

@Repository("xtuserDao")
@Scope(value="prototype")
@SuppressWarnings("all")
public class XtUserDao extends BaseDao implements IXtUserDao {

	@Override
	public void saveEntity(XtUser xtUser) {
		this.getHibernateDaoHelper().addEntity(xtUser);
	}

	@Override
	public void deleteEntity(XtUser xtUser) {
		this.getHibernateDaoHelper().deleteEntity(xtUser);
	}

	@Override
	public void deleteEntityByKey(String userId) {
		this.getHibernateDaoHelper().deleteEntityByKey(XtUser.class, userId);
	}

	@Override
	public void deleteEntityAll(List<XtUser> users) {
		this.getHibernateDaoHelper().deleteEntities(users);
	}
	
	@Override
	public void updateEntity(XtUser xtUser) {
		this.getHibernateDaoHelper().updateEntity(xtUser);
	}
	
	@Override
	public boolean findContains(XtUser xtUser) {
		return this.getHibernateDaoHelper().contains(xtUser);
	}

	@Override
	public XtUser findUserById(String userId) {
		return this.getHibernateDaoHelper().getEntityByKey(XtUser.class, userId);
	}
	
	@Override
	public List<XtUser> find(DetachedCriteria detachedCriteria) {
		return this.getHibernateDaoHelper().findByCriteria(detachedCriteria);
	}

	@Override
	public List<XtUser> findAllUser() {
		
		/*
		List<XtUser> lists = new ArrayList<XtUser>();
		this.getJdbcDaoHelper().query("select * from xt_user;");
		
		return lists;
		*/
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtUser.class);
		detachedCriteria.addOrder(Order.asc("userId"));
		return this.find(detachedCriteria);
		
	}

	@Override
	public List<XtUser> findByPage(int page, int rows) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtUser.class);
		//return this.getHibernateDaoHelper().findByPage(detachedCriteria, (page-1)*rows, rows);
		return this.getHibernateDaoHelper().findByPage(detachedCriteria, page, rows);
	}
	
	@Override
	public long findTotal() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtUser.class);
		return this.getHibernateDaoHelper().getTotal(detachedCriteria);
	}

	@Override
	public List<XtUser> findPageBySql(String hql, Page page) {
		String sqlCount = "select count(*) " + hql;
		long total = this.findTotalBySql(sqlCount);
		page.setTotal(total);
		return this.getHibernateDaoHelper().findPageBySql(hql,page.getPageNum(), page.getRows());
	}

	@Override
	public Long findTotalBySql(String sql) {
		return this.getHibernateDaoHelper().getTotalBySql(sql,null);
	}
	
	@Override
	public List<XtUser> findUserResourceByType(String userId, String resourceTypeId) {
		String hql = "select distinct res from XtResource res,"
				+ "XtPermAssign permAssign,XtUserRole userRole"
				+ " where userRole.xtUser.userId = ?"
				+ " and permAssign.xtRole.roleId=userRole.xtRole.roleId"
				+ " and res.resId=permAssign.xtResource.resId"
				+ " and res.xtResType.resTypeId= ?";
		return this.getHibernateDaoHelper().findByHql(hql, new String[]{userId, resourceTypeId});
	}

	@Override
	public List<XtUser> findUserByOrgId(String orgId) {
		String sql = "from XtUser u where u.xtOrganization.orgId = ? order by userName";
		return this.getHibernateDaoHelper().findByHql(sql, orgId);
	}
	
	public List<XtUser> getResByUser(String userId) {
		String hql = "select distinct res from XtResource res,"
				+ "XtPermAssign permAssign,XtUserRole userRole"
				+ " where userRole.xtUser.userId = ?"
				+ " and permAssign.xtRole.roleId=userRole.xtRole.roleId"
				+ " and res.resId=permAssign.xtResource.resId";
		return this.getHibernateDaoHelper().findByHql(hql, userId);
	}

	/**
	 * 验证用户的帐号和口令
	 */
	@Override
	public boolean findCheckUser(String userId, String password) {
		if (userId.indexOf("'") >= 0 || password.indexOf("'") >= 0)
			return false;
		String hql = "select userId, userName from XtUser xtUser where userId= ? and userPassword= ?";
		List<XtUser> users = this.getHibernateDaoHelper().findByHql(hql, new String[]{userId,password});
		if (users.size() <= 0) 
			return false;
		return true;
	}
	
	public List<XtUser> getResByUserAndResClass(String userId,String resClassId ) {
		String hql = "select distinct res from XtResource res,"
				+ "XtPermAssign permAssign,XtUserRole userRole"
				+ " where userRole.xtUser.userId = ?"
				+ " and permAssign.xtRole.roleId=userRole.xtRole.roleId"
				+ " and res.resId=permAssign.xtResource.resId"
				+ " and res.xtResClass.resClassId= ?";
		List<XtUser> users = this.getHibernateDaoHelper().findByHql(hql, new String[]{userId, resClassId});
		if(users.size() <= 0)
			return null;
		return users;
	}
	
	public List<XtUser> getValidResByUserAndResClass(String userId, String resClassId) {
		String hql = "select distinct res from XtResource res,"
				+ "XtPermAssign permAssign,XtUserRole userRole"
				+ " where userRole.xtUser.userId = ?"
				+ " and permAssign.xtRole.roleId=userRole.xtRole.roleId"
				+ " and res.resId=permAssign.xtResource.resId"
				+ " and res.xtResClass.resClassId= ?" 
				+ " and res.resActive='Y'" ;
		List<XtUser> users = this.getHibernateDaoHelper().findByHql(hql, new String[]{userId, resClassId});
		return users;
	}
	
	public List<XtUser> listUsers(String orgId, String groupId) {
		String hql = "from XtUser u where u.xtOrganization.orgId= ? and u.xtGroup.groupId= ? order by userName";
		return this.getHibernateDaoHelper().findByHql(hql, new String[]{orgId, groupId});
	}

	@Override
	public XtUser findUserByName(String username) {
		
		String hql = "from XtUser xu where xu.userName=?";
		
		int size = this.getHibernateDaoHelper().findByHql(hql, username).size();
		
		if(0 == size)
			return null;
		else{
			return (XtUser)this.getHibernateDaoHelper().findByHql(hql, username).get(0);
		}
				
		
		
		/*
		List<Map<String,Object>> lists = this.getJdbcDaoHelper().query("select * from xt_user where USER_NAME='"+username+"';");
		
		if(lists == null || lists.size()==0)
			return null;
		else{
			
			XtUser xtuser = new XtUser();
			
			xtuser.setUserId(ObjectTool.Obj2Str(lists.get(0).get("USER_ID")));
			xtuser.setUserAddr(ObjectTool.Obj2Str(lists.get(0).get("USER_ADDR")));
			xtuser.setUserEmail(ObjectTool.Obj2Str(lists.get(0).get("USER_EMAIL")));
			xtuser.setUserFax(ObjectTool.Obj2Str(lists.get(0).get("USER_FAX")));
			
			xtuser.setUserInvalid(ObjectTool.Obj2Str(lists.get(0).get("USER_INVALID")));
			xtuser.setUserMobile(ObjectTool.Obj2Str(lists.get(0).get("USER_MOBILE")));
			xtuser.setUserName(ObjectTool.Obj2Str(lists.get(0).get("USER_NAME")));
			xtuser.setUserNote(ObjectTool.Obj2Str(lists.get(0).get("USER_NOTE")));
			xtuser.setUserPassword(ObjectTool.Obj2Str(lists.get(0).get("USER_PASSWORD")));
			
			xtuser.setUserPswEndDate(DateTool.StrToDate(ObjectTool.Obj2Str(lists.get(0).get("USER_PSW_END_DATE"))));
			
			xtuser.setUserPswInvalid(ObjectTool.Obj2Str(lists.get(0).get("USER_PSW_INVALID")));
			xtuser.setUserTel(ObjectTool.Obj2Str(lists.get(0).get("USER_TEL")));
//			xtuser.setDeptId(ObjectTool.Obj2Str(lists.get(0).get("DEPT_ID")));
//			xtuser.setGroupId(ObjectTool.Obj2Str(lists.get(0).get("GROUP_ID")));
			
			return xtuser;
		}
		*/
	}

	//根据roleId来获得用户列表
	@Override
	public List<XtUser> findUsersByRoleId(String roleId,String sort,String order,int pageNum,int rows) {
		
		StringBuffer hql  = new StringBuffer(
				"from XtUser xt where xt.userId in (select xtUser.userId from XtUserRole xur where xur.xtRole.roleId = '"+roleId+"' )");
		if(null != sort)
		{
			hql.append("order by "+sort);
			if(null != order)
			{
				hql.append(" "+order);
			}
		}
		
		return this.getHibernateDaoHelper().findPageBySql(hql.toString(), pageNum, rows);
	}

	@Override
	public List<XtUser> findUsersByCondition(String orgId, String search, String sort, String order, int pageNum, int rows) {
		
		StringBuffer hql  = new StringBuffer("from XtUser xu");
		
		//根据当前用户的orgId来查找用户，即登录用户只能看到同一公司的用户,若orgId为null或空，则返回空
		if(null == orgId  || ("".equals(orgId)))
		{
			return new ArrayList<XtUser>();			
		}
		else
		{
			hql.append(" where xu.xtOrganization.orgId = '"+orgId+"'");
		}
		
		//根据搜索条件search来模糊匹配页面上显示的所有字段
		if(null != search && !("null".equals(search)))
		{
			search = "%"+search+"%";
			
			hql.append(" and ( xu.userId like '"+search+"'");
			hql.append(" or xu.userName like '"+search+"'");
			hql.append(" or xu.userEmail like '"+search+"'");
			hql.append(" or xu.userAddr like '"+search+"'");
			hql.append(" or xu.userTel like '"+search+"')");
			
		}
			
		if(null != sort && !("".equals(sort)))
		{
			hql.append("order by "+sort);
			if(null != order && !("".equals(order)))
			{
				//order 只能为asc或者desc
				if("asc".equals(order))
				{
					hql.append(" "+order);
				}
				else if("desc".equals(order))
				{
					hql.append(" "+order);
				}
			}
		}
		
		return this.getHibernateDaoHelper().findPageBySql(hql.toString(), pageNum, rows);
	}

	@Override
	public Long findTotalByCondition(String orgId,String search) {
		
		StringBuffer hql  = new StringBuffer("from XtUser xu");
		
		//根据当前用户的orgId来查找用户,若orgId为空或者null，直接返回0
		if(null == orgId  || ("".equals(orgId)))
		{
			return 0L;			
		}
		else
		{
			hql.append(" where xu.xtOrganization.orgId = '"+orgId+"'");
		}
		
		//根据搜索条件search来模糊匹配页面上显示的所有字段
		if(null != search && !("null".equals(search)))
		{
			search = "%"+search+"%";
			
			hql.append(" and ( xu.userId like '"+search+"'");
			hql.append(" or xu.userName like '"+search+"'");
			hql.append(" or xu.userEmail like '"+search+"'");
			hql.append(" or xu.userAddr like '"+search+"'");
			hql.append(" or xu.userTel like '"+search+"')");
		}
		System.out.println(hql.toString());	
		//return this.findTotalBySql(hql.toString());
		
		return this.findTotalBySql(hql.toString());
	}

}

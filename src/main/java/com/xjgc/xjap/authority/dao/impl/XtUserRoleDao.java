package com.xjgc.xjap.authority.dao.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.BaseDao;
import com.xjgc.xjap.authority.dao.IXtUserRoleDao;
import com.xjgc.xjap.authority.entity.XtRole;
import com.xjgc.xjap.authority.entity.XtUser;
import com.xjgc.xjap.authority.entity.XtUserRole;

@Repository("xtUserRoleDao")
@Scope(value="prototype")
@SuppressWarnings("all")
public class XtUserRoleDao extends BaseDao implements IXtUserRoleDao {

	@Override
	public XtUserRole getUserRole(XtUser xtUser, XtRole xtRole) {
		return null;
	}

	@Override
	public void deleteAllRoleOfUser(String userId) {
		String hql="delete XtUserRole userRole where userRole.xtUser.userId=:userId";
		this.getHibernateDaoHelper().executeHQL(hql);
	}

	@Override
	public List<XtRole> getRolesOfUser(String userId) {
		String sql = "select r from XtRole r,XtUserRole ur where ur.xtUser.userId = ? and ur.xtRole.roleId = r.roleId order by r.roleName";
		return this.getHibernateDaoHelper().findByHql(sql, userId);
	}

	@Override
	public Object batchSave(List<XtUserRole> userRoles) {
		return null;
	}

	@Override
	public void save(XtUserRole xtUserRole) {
		this.getHibernateDaoHelper().addEntity(xtUserRole);
	}
	
	@Override
	public void deleteUserRoleByUserId(String userId) {
		
		String sql = "delete from XT_USER_ROLE where USER_ID= ?";
		this.getJdbcDaoHelper().update(sql, userId);
	}

}

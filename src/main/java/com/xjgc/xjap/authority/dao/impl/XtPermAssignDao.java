package com.xjgc.xjap.authority.dao.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.xjgc.xjap.appframe.dao.impl.BaseDao;
import com.xjgc.xjap.authority.dao.IXtPermAssignDao;
import com.xjgc.xjap.authority.entity.XtPermAssign;
import com.xjgc.xjap.authority.entity.XtResource;

@Repository("xtPermAssignDao")
@Scope(value="prototype")
@SuppressWarnings("all")
public class XtPermAssignDao extends BaseDao implements IXtPermAssignDao {

	@Override
	public void addEntity(XtPermAssign xtPermAssign) {
		this.getHibernateDaoHelper().addEntity(xtPermAssign);
	}

	@Override
	public List<XtPermAssign> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<XtResource> findAllPermByRoleId(String roleId) {
		
		String sql = "select * from XT_RESOURCE where RES_ID in (select RES_ID from XT_PERM_ASSIGN where ROLE_ID=?)";
		
		return this.getJdbcDaoHelper().query(sql,roleId);
	}

	@Override
	public void deleteEntityAllPermByRoleId(String roleId) {
		
		String sql = "delete from XT_PERM_ASSIGN where ROLE_ID=?";
		
		this.getJdbcDaoHelper().update(sql, roleId);
	}
	
}

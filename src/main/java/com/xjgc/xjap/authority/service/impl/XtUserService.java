package com.xjgc.xjap.authority.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.entity.XtUser;
import com.xjgc.xjap.authority.service.IXtUserService;

@Service("xtuserService")
@Scope(value="prototype")
@Transactional
public class XtUserService extends BaseService implements IXtUserService { 

	@Override
	public List<XtUser> getAllUser() {
		return xtUserDao.findAllUser();
	}

	@Override
	public List<XtUser> getUserByPage(int page, int rows) {
		return xtUserDao.findByPage(page, rows);
	}

	@Override
	public long getUserTotal() {
		return xtUserDao.findTotal();
	}
	
	@Override
	public List<XtUser> getUsersByPage(int pageNum, int rows , Page page) {
		return xtUserDao.findByPage(pageNum, rows);
	}
	
	public List<XtUser> getUsersByPageAndSql(String sql, Page page) {
		return xtUserDao.findPageBySql(sql,page);
	}
//	
//
//	@Override
//	public Long getUserTotal() {
//		return xtUserDao.getTotal();
//	}

	@Override
	public XtUser getLogin(String username, String password) {
		XtUser xtUser = xtUserDao.findUserByName(username);
		
		if(xtUser != null)
		{
			//这里仅判断了密码是否正确,而且密码直接采用明文
			if(!password.equals(xtUser.getUserPassword()))
				return null;
		}

		return xtUser;
	}

	@Override
	public void save(XtUser xtUser) {
		xtUserDao.saveEntity(xtUser);
	}

	@Override
	public void update(XtUser xtUser) {
		xtUserDao.updateEntity(xtUser);
	}

	@Override
	public void delete(XtUser xtUser) {
		xtUserDao.deleteEntity(xtUser);
	}

	@Override
	public XtUser getUserById(String userId) {
		return xtUserDao.findUserById(userId);
	}

	@Override
	public List<XtUser> getUsersByRoleId(String roleId,String sort,String order,int pageNum,int rows) {
		return xtUserDao.findUsersByRoleId(roleId,sort,order,pageNum,rows);
	}

	@Override
	public Long getTotalByRoleId(String roleId) {
		
		String sql = "select count(*) from XtUser xt where xt.userId in (select xtUser.userId from XtUserRole xur where xur.xtRole.roleId = '"+roleId+"') ";
		
		return xtUserDao.findTotalBySql(sql);
	}

	@Override
	public List<XtUser> getUsersByCondition(String orgId, String search, String sort, String order, int pageNum,
			int rows) {
		return xtUserDao.findUsersByCondition(orgId, search, sort, order, pageNum, rows);
	}

	@Override
	public Long getTotalsByCondition(String orgId, String search) {
		return xtUserDao.findTotalByCondition(orgId, search);
	}

}

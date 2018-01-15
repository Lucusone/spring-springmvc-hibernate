package com.xjgc.xjap.authority.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.authority.entity.XtRole;
import com.xjgc.xjap.authority.entity.XtUserRole;
import com.xjgc.xjap.authority.service.IXtUserRoleService;

@Service("xtUserRoleService")
@Scope(value="prototype")
@Transactional
public class XtUserRoleService extends BaseService implements IXtUserRoleService {

	@Override
	public void save(XtUserRole xtUserRole) {
		xtUserRoleDao.save(xtUserRole);
	}

	@Override
	public List<XtRole> getRolesOfUser(String userId) {
		return xtUserRoleDao.getRolesOfUser(userId);
	}
	
	@Override
	public void deleteUserRoleByUserId(String userId) {
		xtUserRoleDao.deleteUserRoleByUserId(userId);
	}

}

package com.xjgc.xjap.authority.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjgc.xjap.appframe.service.impl.BaseService;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.entity.XtRole;
import com.xjgc.xjap.authority.service.IXtRoleService;

@Service("xtRoleService")
@Scope(value="prototype")
@Transactional
public class XtRoleService extends BaseService implements IXtRoleService {

	@Override
	public List<XtRole> getAllRole() {
		return xtRoleDao.findAllRole();
	}

	@Override
	public List<XtRole> getRolesByPage(int pageNum, int rows, Page page) {
	
		return xtRoleDao.findByPage(pageNum, rows);
	}

	@Override
	public List<XtRole> getRolesByPageAndSql(String sql, Page page) {
		return null;
	}

	@Override
	public List<XtRole> getXtRoleByPage(int page, int rows) {
		
		return xtRoleDao.findByPage(page, rows);
	}

	@Override
	public long getRoleTotal() {
		return xtRoleDao.findTotal();
	}

	@Override
	public void save(XtRole role) {
		xtRoleDao.addEntityRole(role);
	}

	@Override
	public void update(XtRole role) {

		xtRoleDao.updateEntityRole(role);
	}

	@Override
	public void delete(XtRole role) {

		xtRoleDao.deleteEntityRole(role);
	}

	@Override
	public void deleteById(String id) {
		xtRoleDao.deleteEntityRoleById(id);
	}

	@Override
	public XtRole getRoleById(String id) {
		return xtRoleDao.findRoleById(id);
	}

	@Override
	public List<XtRole> getRolesByResId(String resId) {
		return xtRoleDao.findRolesByResId(resId);
	}

	@Override
	public List<XtRole> getRolesByOrgId(String orgId) {
		
		return xtRoleDao.findRoleByOrgId(orgId);
	}

	@Override
	public List<XtRole> getRolesByCondition(String orgId, String search, String sort, String order, int pageNum,
			int rows) {
		return xtRoleDao.findRolesByCondition(orgId, search, sort, order, pageNum, rows);
	}

	@Override
	public Long getTotalByCondition(String orgId, String search) {
		return xtRoleDao.findTotalByCondition(orgId, search);
	}


	
	
}

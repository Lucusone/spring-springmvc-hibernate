package com.xjgc.xjap.appframe.service.impl;

import javax.annotation.Resource;

import com.xjgc.xjap.authority.dao.IXtDeptDao;
import com.xjgc.xjap.authority.dao.IXtLogClassDao;
import com.xjgc.xjap.authority.dao.IXtLogDao;
import com.xjgc.xjap.authority.dao.IXtMenuDao;
import com.xjgc.xjap.authority.dao.IXtOperationDao;
import com.xjgc.xjap.authority.dao.IXtOrganizationDao;
import com.xjgc.xjap.authority.dao.IXtPermAssignDao;
import com.xjgc.xjap.authority.dao.IXtResClassDao;
import com.xjgc.xjap.authority.dao.IXtResTypeDao;
import com.xjgc.xjap.authority.dao.IXtResourceDao;
import com.xjgc.xjap.authority.dao.IXtRoleDao;
import com.xjgc.xjap.authority.dao.IXtUserDao;
import com.xjgc.xjap.authority.dao.IXtUserRoleDao;
import com.xjgc.xjap.powerres.dao.IXtAnalogDao;
import com.xjgc.xjap.powerres.dao.IXtBayDao;
import com.xjgc.xjap.powerres.dao.IXtBreakerDao;
import com.xjgc.xjap.powerres.dao.IXtCompanyDao;
import com.xjgc.xjap.powerres.dao.IXtDistrictDao;
import com.xjgc.xjap.powerres.dao.IXtFeederDao;
import com.xjgc.xjap.powerres.dao.IXtStationDao;

public class BaseService {
	
	@Resource(name="xtuserDao")
	protected IXtUserDao xtUserDao;
	
	@Resource(name="xtmenuDao")
	protected IXtMenuDao xtMenuDao;
	
	
	@Resource(name="xtOrganizationDao")
	protected IXtOrganizationDao xtOrgDao;
	
	@Resource(name="xtResDao")
	protected IXtResourceDao xtResDao;
	
	@Resource(name="xtRoleDao")
	protected IXtRoleDao xtRoleDao;
	
	@Resource(name="xtUserRoleDao")
	protected IXtUserRoleDao xtUserRoleDao;
	
	@Resource(name="xtPermAssignDao")
	protected IXtPermAssignDao xtPermAssignDao;
	
	@Resource(name="xtResTypeDao")
	protected IXtResTypeDao xtResTypeDao;
	
	@Resource(name="xtResClassDao")
	protected IXtResClassDao xtResClassDao;
	
	@Resource(name="xtDeptDao")
	protected IXtDeptDao xtDeptDao;
	
	@Resource(name="xtOperationDao")
	protected IXtOperationDao xtOperationDao;
	
	@Resource(name="xtLogDao")
	protected IXtLogDao xtLogDao;
	
	@Resource(name="xtLogClassDao")
	protected IXtLogClassDao xtLogClassDao;
	
	@Resource(name="xtFeederDao")
	protected IXtFeederDao xtFeederDao;
	
	@Resource(name="xtBreakerDao")
	protected IXtBreakerDao xtBreakerDao;
	
	@Resource(name="xtStationDao")
	protected IXtStationDao xtStationDao;
	
	@Resource(name="xtDistrictDao")
	protected IXtDistrictDao xtDistrictDao;
	
	@Resource(name="xtCompanyDao")
	protected IXtCompanyDao xtCompanyDao;
	
	@Resource(name="xtBayDao")
	protected IXtBayDao xtBayDao;
	
	@Resource(name="xtAnalogDao")
	protected IXtAnalogDao xtAnalogDao;
}

package com.xjgc.xjap.appframe.dao;

import org.junit.Test;

import com.xjgc.xjap.appframe.util.BaseTransactionalTest;
import com.xjgc.xjap.authority.dao.IXtDeptDao;
import com.xjgc.xjap.authority.dao.IXtOrganizationDao;
import com.xjgc.xjap.authority.entity.XtDept;
import com.xjgc.xjap.authority.entity.XtOrganization;

@SuppressWarnings("all")
public class XtDeptDaoTest extends BaseTransactionalTest {
	
	public IXtDeptDao getXtDeptDao() {
		return (IXtDeptDao) this.getBean("xtDeptDao");
	}
	
	public IXtOrganizationDao getXtOrganizationDao() {
		return (IXtOrganizationDao) this.getBean("xtOrganizationDao");
	}

	@Test
	public void testGetById() {
		String deptId = "2011";
//		XtDept xtDept = getXtDeptDao().getById(deptId);
//		System.out.println("用户ID = " +deptId+ " 用户名 = "+xtDept.getDeptName());
	}
	
	@Test
	public void testSave() {
		XtDept xtDept = new XtDept();
		xtDept.setDeptId("2012");
		xtDept.setDeptAddr("Beijing");
		xtDept.setDeptFax("0375-33339999");
		xtDept.setDeptName("Development");
		xtDept.setDeptTel("0375-44443333");
//		XtOrganization xtOrganization = getXtOrganizationDao().getById("1011");
//		xtDept.setXtOrganization(xtOrganization);
//		getXtDeptDao().save(xtDept);
	}
	
}

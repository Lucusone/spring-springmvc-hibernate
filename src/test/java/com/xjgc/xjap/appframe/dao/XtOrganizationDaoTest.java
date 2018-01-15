package com.xjgc.xjap.appframe.dao;

import org.junit.Test;

import com.xjgc.xjap.appframe.util.BaseTransactionalTest;
import com.xjgc.xjap.authority.dao.IXtOrganizationDao;
import com.xjgc.xjap.authority.entity.XtOrganization;

@SuppressWarnings("all")
public class XtOrganizationDaoTest extends BaseTransactionalTest {

	public IXtOrganizationDao getXtOrganizationDao() {
		return (IXtOrganizationDao) this.getBean("xtOrganizationDao");
	}
	
	@Test
	public void testGetById() {
		String orgId = "1010";
//		XtOrganization xtOrganization = getXtOrganizationDao().getById(orgId);
//		System.out.println("用户ID = " +orgId+ " 用户名 = "+xtOrganization.getOrgName());
	}
	
	@Test
	public void testSave() {
		XtOrganization xtOrganization = new XtOrganization();
		xtOrganization.setOrgId("1011");
		xtOrganization.setOrgAddress("YanAn Raod");
		xtOrganization.setOrgCode("0374");
		xtOrganization.setOrgEmail("xxcc@163.com");
		xtOrganization.setOrgFax("0374-78789900");
		xtOrganization.setOrgName("CC");
//		getXtOrganizationDao().save(xtOrganization);
	}
	
}

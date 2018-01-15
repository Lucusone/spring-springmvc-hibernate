package com.xjgc.xjap.appframe.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.junit.Test;

import com.xjgc.xjap.appframe.entity.User;
import com.xjgc.xjap.appframe.util.BaseTransactionalTest;
import com.xjgc.xjap.appframe.utils.Page;
import com.xjgc.xjap.authority.dao.IXtDeptDao;
import com.xjgc.xjap.authority.dao.IXtOrganizationDao;
import com.xjgc.xjap.authority.dao.IXtUserDao;
import com.xjgc.xjap.authority.entity.XtDept;
import com.xjgc.xjap.authority.entity.XtOrganization;
import com.xjgc.xjap.authority.entity.XtUser;

@SuppressWarnings("all")
public class XtUserDaoTest extends BaseTransactionalTest {
	
	public IXtUserDao getXtUserDao() {
		return (IXtUserDao) this.getBean("xtuserDao");
	}
	
	public IXtDeptDao getXtDeptDao() {
		return (IXtDeptDao) this.getBean("xtDeptDao");
	}
	
	public IXtOrganizationDao getXtOrganizationDao() {
		return (IXtOrganizationDao) this.getBean("xtOrganizationDao");
	}

	@Test
	public void testSave() {
		XtUser xtUser = new XtUser();
		xtUser.setUserId("admin11");
		xtUser.setUserAddr("Nanjing Road");
		xtUser.setUserEmail("admin01@qq.com");
		xtUser.setUserFax("0376-88875556");
		xtUser.setUserMobile("17644439900");
		xtUser.setUserName("admin11");
		xtUser.setUserPassword("123456");
//		XtDept xtDept = getXtDeptDao().getById("2011");
//		xtUser.setXtDept(xtDept);
//		XtOrganization xtOrganization = getXtOrganizationDao().getById("1011");
//		xtUser.setXtOrganization(xtOrganization);
		
		this.getXtUserDao().saveEntity(xtUser);
	}
	
	@Test
	public void testGetUserByid(){
		String userId = "admin";
		XtUser user = getXtUserDao().findUserById(userId);
		System.out.println("用户ID = " +userId+ " 用户名 = "+user.getUserName());
	}
	
	@Test
	public void testFind() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(XtUser.class);
		detachedCriteria.addOrder(Order.asc("userId"));
		List<XtUser> list = getXtUserDao().find(detachedCriteria);
		System.out.println(list.get(2).getUserId());
	}
	
	@Test
	public void testFindByPage() {
//		System.out.println(getXtDeptDao().getTotalBySql("select count(*) from XtDept")+"------------");
//		System.out.println(getXtDeptDao().getTotal() +"****");
		
		String hql = "from XtDept";
		
		List<XtDept> listSql0 = getXtDeptDao().findPagesBySql(hql, new Page(0,4));
		List<XtDept> listSql10 = getXtDeptDao().findPagesBySql(hql, new Page(4,4));
		List<XtDept> listSq20 = getXtDeptDao().findPagesBySql(hql, new Page(8,4));
		List<XtDept> lists0 = getXtDeptDao().findByPage(0, 4);
		List<XtDept> lists10 = getXtDeptDao().findByPage(4, 4);
		List<XtDept> lists20 = getXtDeptDao().findByPage(8, 4);
		
		System.out.println(listSql0.size()+"^^^^^0000");
		for(XtDept dept : listSql0 )
		{
			System.out.println(dept.getDeptId());
		}
		System.out.println(lists0.size()+"****0000");
		for(XtDept dept : lists0)
		{
			System.out.println(dept.getDeptId());
		}
		
		System.out.println(listSql10.size()+"^^^^^10101010");
		for(XtDept dept : listSql10 )
		{
			System.out.println(dept.getDeptId());
		}
		
		System.out.println(lists10.size()+"****1010101010");
		for(XtDept dept : lists10)
		{
			System.out.println(dept.getDeptId());
		}

		System.out.println(listSq20.size()+"^^^^^20202020");
		for(XtDept dept : listSq20)
		{
			System.out.println(dept.getDeptId());
		}
		
		
		System.out.println(lists20.size()+"****202020");
		for(XtDept dept : lists20)
		{
			System.out.println(dept.getDeptId());
		}
	}
	
	@Test
	public void testlistUserByOrgId() {
		System.out.println(getXtUserDao().findUserByOrgId("1010").size());
	}
	
}

package com.xjgc.xjap.appframe.service;

import org.junit.Test;
import com.xjgc.xjap.appframe.entity.User;
import com.xjgc.xjap.appframe.util.BaseTransactionalTest;
import com.xjgc.xjap.authority.entity.XtUser;
import com.xjgc.xjap.authority.service.IXtUserService;
import com.xjgc.xjap.powerres.service.impl.RestfulService;

public class UserServiceTest extends BaseTransactionalTest {
	
	public IXtUserService getUserService() {
		return (IXtUserService) this.getBean("xtuserService");
	}
	
	public RestfulService getRestfulService() {
		return (RestfulService) this.getBean("restfulService");
	}
	
	@Test
	public void getRestData() {
		RestfulService restfulService = this.getRestfulService();
		
		String string  = restfulService.getValues();
		
		System.out.println(string);
	}
	
	
	@Test
	public void testSave() {
		XtUser user = new XtUser();
		user.setUserId("111111");
		this.getUserService().save(user);
		logger.debug("UserService��void save(User user)��ȷ��");
	}
	
	
}

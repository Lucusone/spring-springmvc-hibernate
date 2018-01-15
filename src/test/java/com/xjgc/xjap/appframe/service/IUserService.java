package com.xjgc.xjap.appframe.service;

import java.util.List;

import com.xjgc.xjap.appframe.entity.User;

public interface IUserService {

	public void insertUser(User user);
	
	public List<User> listAllUsers();
		
}

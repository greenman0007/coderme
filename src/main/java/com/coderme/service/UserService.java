package com.coderme.service;

import com.coderme.bean.User;

public interface UserService {

	public void register(User user) throws Exception;
	
	public User findByName(String userName);
	
	public boolean login(User user) throws Exception;
}

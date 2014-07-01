package com.coderme.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderme.bean.User;
import com.coderme.dao.UserDAO;
import com.coderme.mapper.UserMapper;
import com.coderme.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDAO userDAO;
	@Autowired
	private UserMapper userMapper;
	@Override
	public void register(User user) throws Exception {
		validate(user);
		userMapper.save(user);
	}
	private void validate(User user) throws Exception {
		if (null != userMapper.findUserByName(user.getUserName())) {
			throw new Exception("userName: "+user.getUserName()+" is exist !");
		}
	}
	@Override
	public User findByName(String userName) {
		return userMapper.findUserByName(userName);
	}
	@Override
	public boolean login(User user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}

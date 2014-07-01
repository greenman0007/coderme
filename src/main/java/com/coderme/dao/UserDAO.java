package com.coderme.dao;


import org.springframework.stereotype.Repository;

import com.coderme.bean.User;
import com.coderme.bean.mapper.UserMapper;
import com.coderme.core.util.BaseDAO;
import com.coderme.core.util.Query;

@Repository("userDAO")
public class UserDAO extends BaseDAO<UserMapper, User> {

	public void register(User user) {
		String sql = "insert into blog_user (userName, password) values (?,?)";
		Query query = new Query(sql);
		query.setStringValue(user.getUserName());
		query.setStringValue(user.getPassWord());
		saveOrUpdate(query);
	}
	
	public User findUserByName(String userName) {
		String sql = "select * from blog_user where userName=?";
		Query query = new Query(sql);
		query.setStringValue(userName);
		User user = (User)query(query);
		return user;
	}
	
	public boolean login(User user) {
		String sql = "select password from blog_user where userName=? and password=?";
		Query query = new Query(sql);
		query.setStringValue(user.getUserName());
		query.setStringValue(user.getPassWord());
		User existUser = query(query);
		if (null == existUser) {
			return false;
		}
		return true;
	}
}

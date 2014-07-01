package com.coderme.bean;

import com.coderme.core.annotation.MyColumn;
import com.coderme.core.annotation.MyTable;

@MyTable(name = "blog_user")
public class User {

	@MyColumn(name = "id")
	private Long id;
	@MyColumn(name = "userName")
	private String userName;
	@MyColumn(name = "password")
	private String passWord;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}

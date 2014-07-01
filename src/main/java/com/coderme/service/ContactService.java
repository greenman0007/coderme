package com.coderme.service;

import java.util.List;

import com.coderme.bean.Contact;

public interface ContactService {
	
	public void save(Contact contact);
	
	public List<Contact> findAll();
	
	public Contact findByName(String name);
	
	public void update(Contact contact);
}

package com.coderme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderme.bean.Contact;
import com.coderme.mapper.ContactMapper;
import com.coderme.service.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactMapper contactMapper;
	@Override
	public void save(Contact contact) {
		contactMapper.save(contact);
	}

	@Override
	public List<Contact> findAll() {
		return contactMapper.findAll();
	}

	@Override
	public Contact findByName(String name) {
		return contactMapper.findByName(name);
	}

	public void update(Contact contact){
		contactMapper.update(contact);
	}
}

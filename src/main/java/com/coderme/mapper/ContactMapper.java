package com.coderme.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderme.bean.Contact;

/**
 * 联系人 mybatis map接口
 * <pre>
 * @author zhangtengfei
 *
 *
 * 创建日期: 2014-5-29
 * 修改人 :  
 * 修改说明: 
 * 评审人 ：
 * </pre>
 */
@Repository
public interface ContactMapper {

	public void save(Contact contact);
	
	public List<Contact> findAll();

	public Contact findByName(String name);
	
	public void update(Contact contact);
}

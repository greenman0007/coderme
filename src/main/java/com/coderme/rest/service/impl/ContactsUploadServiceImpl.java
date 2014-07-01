package com.coderme.rest.service.impl;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.coderme.bean.Contact;
import com.coderme.core.jms.JMSUtil;
import com.coderme.dto.ContactsDto;
import com.coderme.rest.service.ContactsUploadService;
import com.coderme.service.ContactService;

/**
 * 
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
@Path("/contacts")
@Component
public class ContactsUploadServiceImpl implements ContactsUploadService {

	
	@Path("/upload")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public void upload(ContactsDto contactsDto) throws Exception {
		JMSUtil.sendObjectMQ(contactsDto);
//		BeanUtils.copyProperties(contact, contactsDto);
		
	}
	
}

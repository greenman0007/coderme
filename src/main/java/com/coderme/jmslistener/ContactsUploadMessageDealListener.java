package com.coderme.jmslistener;

import javax.annotation.Resource;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.stereotype.Component;

import com.coderme.bean.Contact;
import com.coderme.core.jms.JMSUtil;
import com.coderme.dto.ContactsDto;
import com.coderme.service.ContactService;

/**
 * 联系人上传消息处理
 * <pre>
 * @author zhangtengfei
 *
 *
 * 创建日期: 2014-5-30
 * 修改人 :  
 * 修改说明: 
 * 评审人 ：
 * </pre>
 */
@Component
public class ContactsUploadMessageDealListener implements MessageListener {

	@Resource
	private ContactService contactService;
	
	public void dealMessage(Message arg0) {
//		ObjectMessage objMsg = (ObjectMessage) JMSUtil.receive();
		ContactsDto contactsDto = null;
		if (arg0 instanceof ObjectMessage) {
			ObjectMessage objMsg = (ObjectMessage)arg0;
			try {
				contactsDto = (ContactsDto) objMsg.getObject();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else {
			return;
		}
		Contact contact = contactService.findByName(contactsDto.getName());
		if (null != contact) {
			copyProperties(contactsDto, contact);
			contactService.update(contact);
		} else {
			contact = new Contact();
			copyProperties(contactsDto, contact);
			contactService.save(contact);
		}
	}
	
	private void copyProperties(ContactsDto contactsDto, Contact contact) {
		contact.setName(contactsDto.getName());
		contact.setEmail(contactsDto.getEmail());
		contact.setGroup(contactsDto.getGroup());
		contact.setMobileNumber(contactsDto.getMobileNumber());
		contact.setTelephoneNumber(contactsDto.getTelephoneNumber());
	}

	@Override
	public void onMessage(Message arg0) {
		dealMessage(arg0);
	}
}

package com.coderme.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderme.dto.ContactsDto;
import com.coderme.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactAction {

	@Resource
	private ContactService contactService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        contactService.findAll();
        return "login";
    }
	@RequestMapping(value="/restTest" , method = RequestMethod.POST)
	@ResponseBody
	public ContactsDto testRest(ContactsDto contactsDto) {
		System.out.println("receive rest request:"+contactsDto);
		return contactsDto;
	}
}

package com.coderme.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coderme.bean.User;
import com.coderme.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterAction {
    Logger logger = Logger.getLogger(RegisterAction.class);
    
    @Resource
    private UserService userService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        return "register";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute User user) {
    	try {
            userService.register(user);
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			logger.error(e);
			return "register";
		}
        return "login";
    }
}

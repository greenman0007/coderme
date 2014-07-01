package com.coderme.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/welcome")
public class TestAction {

//	@RequestMapping(method=RequestMethod.GET)
//	public ModelAndView welcome(HttpServletRequest request) {
//		 //welcome就是视图的名称（welcome.ftl）
//        ModelAndView mv = new ModelAndView("welcome");
//        mv.addObject("name", "My First Spring Mvc");
//        return mv;
//	}
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
		Runtime rt = Runtime.getRuntime();
		double freeMem = rt.freeMemory()/1024/1024;
		double maxMem = rt.maxMemory()/1024/1024;
		double totleMem = rt.totalMemory()/1024/1024;
		int availPros = rt.availableProcessors();
		model.addAttribute("freeMem",String.valueOf(freeMem)+"M");
		model.addAttribute("maxMem",String.valueOf(maxMem)+"M");
		model.addAttribute("totleMem",String.valueOf(totleMem)+"M");
		model.addAttribute("availPros",String.valueOf(availPros));
        return "test";
    }
}

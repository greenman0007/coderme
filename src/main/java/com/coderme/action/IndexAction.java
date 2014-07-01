package com.coderme.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coderme.bean.Article;
import com.coderme.service.ArticleService;

@Controller
@RequestMapping("/index")
public class IndexAction {
	@Resource
	private ArticleService articleService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
		List<Article> texts = null;
		try {
			texts = articleService.findAllArticle();
		} catch (Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
		}
		System.out.println(texts);
		
		model.addAttribute("textList", texts);
		return "mainPage";
    }
}

package com.coderme.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.coderme.bean.Article;
import com.coderme.dao.ArticleDAO;
import com.coderme.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleDAO articleDAO;
	@Override
	public List<Article> findAllArticle() throws Exception {
		return articleDAO.queryAll();
	}

}

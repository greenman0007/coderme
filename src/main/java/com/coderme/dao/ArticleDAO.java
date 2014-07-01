package com.coderme.dao;

import org.springframework.stereotype.Repository;

import com.coderme.bean.Article;
import com.coderme.bean.mapper.ArticleMapper;
import com.coderme.core.util.BaseDAO;

@Repository("articleDAO")
public class ArticleDAO extends BaseDAO<ArticleMapper, Article>{

	public void findArticle() {
//		getJdbcTemplate().query("", ge);
	}
}

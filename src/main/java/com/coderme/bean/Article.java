package com.coderme.bean;

import java.util.Date;

import com.coderme.core.annotation.MyColumn;
import com.coderme.core.annotation.MyTable;

/**
 * 文章实体
 * @author Administrator
 *
 */
@MyTable(name = "article")
public class Article {

	@MyColumn(name="id")
	private Long id;
	@MyColumn(name="tag")
	private String tag;
	@MyColumn(name="writer")
	private String writer;
	@MyColumn(name="title")
	private String title;
	@MyColumn(name="keyWord")
	private String keyWord;
	@MyColumn(name="createTime")
	private Date createTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", tag=" + tag + ", writer=" + writer
				+ ", title=" + title + ", keyWord=" + keyWord + ", createTime="
				+ createTime + "]";
	}
	
}

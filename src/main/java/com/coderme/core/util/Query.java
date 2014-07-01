package com.coderme.core.util;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class Query {
	private String sql;
	private List<Object> paramValues = new ArrayList<Object>();
	private List<Integer> paramTypes = new ArrayList<Integer>();
	
	public String getSql() {
		return sql;
	}
	
	public void setSql(String sql) {
		this.sql = sql;
	}
	
	public Query(String sql){
		this.sql = sql;
	}
	
	public Object[] getParamValues() {
		if(CollectionUtils.isEmpty(paramValues)){
			return null;
		}
		Object[] returnValue = new Object[paramValues.size()];
		for (int i = 0; i < paramValues.size(); i++) {
			returnValue[i] = paramValues.get(i);
		}
		return returnValue;
	}
	
	public int[] getParamTypes() {
		if(CollectionUtils.isEmpty(paramTypes)){
			return null;
		}
		int[] returnValue = new int[paramTypes.size()];
		for (int i = 0; i < paramTypes.size(); i++) {
			returnValue[i] = paramTypes.get(i);
		}
		return returnValue;
	}
	
	public void setStringValue(String paramValue){
		paramValues.add(paramValue);
		paramTypes.add(Types.VARCHAR);
	}
	
	public void setNumberValue(Number paramValue){
		paramValues.add(paramValue);
		paramTypes.add(Types.NUMERIC);
	}
}

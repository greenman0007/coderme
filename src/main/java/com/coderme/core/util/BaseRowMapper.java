package com.coderme.core.util;

import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.coderme.core.annotation.MyTable;

public class BaseRowMapper<T> implements RowMapper<T> {

	@Override
	public T mapRow(ResultSet rs, int rowNum) throws SQLException {
		T t = null;
		try {
			t = getMapperClass().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		EntityConvertUtil.setValues(t, rs);
		return t;
	}

	
	@SuppressWarnings("unchecked")
    public Class<T> getMapperClass() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        return (Class<T>) pt.getActualTypeArguments()[0];
    }
	public String getTable() throws Exception {
		String table = null;
		Class clazz = getMapperClass();
		MyTable annotation = (MyTable) clazz.getAnnotation(MyTable.class);
		return annotation.name();
	}
	
}

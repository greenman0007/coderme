package com.coderme.core.util;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BaseDAO<T extends BaseRowMapper, S> extends JdbcDaoSupport {
	Logger logger = Logger.getLogger(BaseDAO.class);
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unchecked")
	public List<S> queryAll() throws Exception {
		try {
			T t = getMapperClass().newInstance();
			List<S> result = (List<S>)jdbcTemplate.query("select *  from "+t.getTable(), t);
//			List<S> result = (List<S>)jdbcTemplate.query("select *  from "+t.getTable(), new BeanPropertyRowMapper(getMapperClass()));
			
			return result;
		} catch (Exception e) {
			logger.error("query result is null");
			throw new Exception(e);
		}
		
	}
	
	public void saveOrUpdate(Query query) {
		if (query.getParamValues() != null) {
            jdbcTemplate.update(query.getSql(), query.getParamValues(), query.getParamTypes());
        } else {
            jdbcTemplate.update(query.getSql());
        }
		
	}
	
	public S query(Query query) {
		try {
            T t = getMapperClass().newInstance();
            if (query.getParamValues() != null) {
            	S s = (S) jdbcTemplate.query(query.getSql(), query.getParamValues(), query.getParamTypes(), t).get(0);
                return (S) jdbcTemplate.query(query.getSql(), query.getParamValues(), query.getParamTypes(), t).get(0);
            } else {
                return (S) jdbcTemplate.query(query.getSql(), t).get(0);
            }
        }
        catch (Exception e) {
            return null;
        }
	}
	@SuppressWarnings("unchecked")
    private Class<T> getMapperClass() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        return (Class<T>) pt.getActualTypeArguments()[0];
    }
}

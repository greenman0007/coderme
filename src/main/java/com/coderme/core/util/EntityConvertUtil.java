package com.coderme.core.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;

import com.coderme.core.annotation.MyColumn;


public class EntityConvertUtil {
	//private static final Logger logger = LoggerFactory.getLogger(EntityConvertUtil.class);
	
	private EntityConvertUtil(){};
	
	@SuppressWarnings("rawtypes")
	public static void setValues(Object object, ResultSet resultset){
		Class clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			MyColumn annotation = field.getAnnotation(MyColumn.class);
			if (annotation != null) {
				try {
				    Object value = resultset.getObject(annotation.name());
				    if(value == null)
				        continue;
				    
					BeanUtil.setValue(object, field.getName(), value);
				} catch (Exception e) {
					//logger.error("setValues failed", e);
				}
			}
		}
	}
}

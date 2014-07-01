package com.coderme.core.util;

import java.util.HashMap;
import java.util.Map;

import org.mvel2.MVEL;

public class BeanUtil {
	
	public static Object getValue(Object object, String property){
		return MVEL.eval(property, object);
	}

	public static void setValue(Object object, String property, Object value){
		String expression = "object." + property + "=value";
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("object", object);
		vars.put("value", value);
		MVEL.eval(expression, vars);
	}
}

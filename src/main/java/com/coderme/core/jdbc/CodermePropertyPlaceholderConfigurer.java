/*
 * @(#)CodermePropertyPlaceholderConfigurer.java 2014-7-2
 * 
 * Copy Right@ 纽海信息技术有限公司
 */ 

package com.coderme.core.jdbc;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * <pre>
 * @author zhangtengfei
 *
 *
 * 创建日期: 2014-7-2
 * 修改人 :  
 * 修改说明: 
 * 评审人 ：
 * </pre>
 */
public class CodermePropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {

	@Override
	public void setLocation(Resource location) {
		String configPath = System.getProperty("global.config.path");
//		InputStream is = null;
		String configFilePath = null;
		if (configPath != null) {
//			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(configPath);
			configFilePath = configPath + "/" + "jdbc.properties";
		} else {
			configFilePath = "classpath:jdbc.properties";
		}
		location = new ClassPathResource(configFilePath);
		super.setLocation(location);
	}

}

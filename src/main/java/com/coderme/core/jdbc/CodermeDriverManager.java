/*
 * @(#)CodermeDriverManager.java 2014-7-1
 * 
 * Copy Right@ 纽海信息技术有限公司
 */ 

package com.coderme.core.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * @author zhangtengfei
 * 
 * 使用-Dglobal.config.path配置的jdbc配置文件，
 * 如果（开发环境）没有该配置，则读取classpath:jdbc.properties
 *
 * 创建日期: 2014-7-1
 * 修改人 :  
 * 修改说明: 
 * 评审人 ：
 * </pre>
 */
@Service("dataSource")
public class CodermeDriverManager extends DriverManagerDataSource {

	@Override
	protected Connection getConnectionFromDriver(Properties props)
			throws SQLException {
		getProperties(props);
		return super.getConnectionFromDriver(props);
	}

	@Override
	protected Connection getConnectionFromDriverManager(String url,
			Properties props) throws SQLException {
		getProperties(props);
		return super.getConnectionFromDriverManager(url, props);
	}

	private void getProperties(Properties props) {
		String configPath = System.getProperty("global.config.path");
//		InputStream is = null;
		String configFilePath = null;
		if (configPath != null) {
//			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(configPath);
			configFilePath = configPath + "/" + "jdbc.properties";
			File pFile = new File(configFilePath);
			FileInputStream pInStream=null;
			try {
			    pInStream = new FileInputStream(pFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace(); 
		    }
			try {
				props.load(pInStream);//Properties 对象已生成，包括文件中的数据
			} catch (IOException e) {
				e.printStackTrace(); 
			}
		}
	}
}

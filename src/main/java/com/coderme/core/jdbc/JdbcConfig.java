package com.coderme.core.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 使用-Dglobal.config.path配置的jdbc配置文件，
 * 如果（开发环境）没有该配置，则读取classpath:jdbc.properties
 * <pre>
 * @author zhangtengfei
 *
 * 创建日期: 2014-7-2
 * 修改人 :  
 * 修改说明: 
 * 评审人 ：
 * </pre>
 */
public class JdbcConfig {
	private final Logger logger = LoggerFactory.getLogger(JdbcConfig.class);
    private String propertyFileName;

    public JdbcConfig() {
        this.propertyFileName = "jdbc.properties";
        processProperties();
    }

    public void processProperties() {
    	String configPath = System.getProperty("global.config.path");
//		InputStream is = null;
		String configFilePath = null;
		if (configPath != null) {
//			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(configPath);
			configFilePath = configPath + propertyFileName;
		} else {
			configFilePath = "classpath:" + propertyFileName;
		}
		
		File pFile = new File(configFilePath);
		InputStream pInStream=null;
		try {
		    pInStream = new FileInputStream(pFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
	    }
//        InputStream input = getClass().getResourceAsStream(configFilePath);
//
//        if (input == null) {
//            input = getClass().getResourceAsStream("/" + propertyFileName);
//            if (input == null) {
//                input = Thread.currentThread().getContextClassLoader().getResourceAsStream(configFilePath);
//            }
//        }
        register(pInStream);
    }

    private void register(InputStream input) {
        if (input != null) {
            try {
                System.getProperties().load(input);
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        } else {
            logger.error(propertyFileName + " can not exits;");
        }
    }

    public static void main(String[] args) {

    	JdbcConfig jc = new JdbcConfig();
    	
    }
}

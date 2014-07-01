package com.coderme.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;



/**
 * 得到Spring ApplicationContext的引用，根据类名查找实例时
 */
public final class SpringContextUtil implements ApplicationContextAware  {
    private static ApplicationContext context;
    
    @SuppressWarnings("static-access")
    @Override
    public void setApplicationContext(ApplicationContext contex)
            throws BeansException {
        this.context = contex;
    }
    
    public static Object getBean(String beanName){
        return context.getBean(beanName);
    }
}
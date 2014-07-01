package com.coderme.core.jms.test;

import javax.jms.Destination;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * 接收方
 * <pre>
 * @author zhangtengfei
 *
 *
 * 创建日期: 2014-5-27
 * 修改人 :  
 * 修改说明: 
 * 评审人 ：
 * </pre>
 */
public class HelloWorldReciver {

	public static void main(String args[]) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:applicationContext-jms.xml" });
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		Destination destination = (Destination) context.getBean("destination");
		System.out.println("will wait:" + jmsTemplate.getReceiveTimeout()
				+ " seconds for message");
		TextMessage msg = (TextMessage) jmsTemplate.receive(destination);
		System.out.println("reviced msg is:" + msg.getText());
	}

}
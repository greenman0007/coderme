package com.coderme.core.jms.test;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * 发送方
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
public class HelloWorldSender {
	public static void main(String args[]) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:applicationContext-jms.xml" });
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		Destination destination = (Destination) context.getBean("destination");
		//在没有使用MessageConverter的时候我们需要new一个MessageCreator接口对象，
		//然后在其抽象方法createMessage内部使用session创建一个对应的消息。
		//在使用了MessageConverter的时候我们在使用JmsTemplate进行消息发送时只需要调用其对应的convertAndSend方法即可
//		jmsTemplate.convertAndSend(Object o);
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
//				session.createObjectMessage(arg0);
				return session.createTextMessage("大家好这个是测试！");
			}
		});
	}

}
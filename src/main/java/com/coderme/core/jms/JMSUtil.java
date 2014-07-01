package com.coderme.core.jms;

import java.io.Serializable;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.coderme.core.util.SpringContextUtil;

/**
 * 消息操作类
 * <pre>
 * @author zhangtengfei
 *
 *
 * 创建日期: 2014-5-28
 * 修改人 :  
 * 修改说明: 
 * 评审人 ：
 * </pre>
 */
public class JMSUtil {

	public static JmsTemplate getJmsTemplate() {
		return (JmsTemplate) SpringContextUtil.getBean("jmsTemplate");
	}
	
	public static Destination getDestination() {
		return (Destination) SpringContextUtil.getBean("destination");
	}
	/**
	 * send Text message
	 */
	public static void sendTextMQ(final String msg) {
		getJmsTemplate().send(getDestination(), new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}
	/**
	 * <p>send Text message
	 * <p>Using your queue
	 */
	public static void sendTextMQFromDest(final String msg, Destination destination) {
		getJmsTemplate().send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}
	
	/**
	 * send Object message
	 */
	public static void sendObjectMQ(final Object o) {
		getJmsTemplate().send(getDestination(), new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage((Serializable) o);
			}
		});
	}
	/**
	 * <p>send Object message
	 * <p>Using your queue
	 */
	public static void sendObjectMQFromDest(final Object o, Destination destination) {
		getJmsTemplate().send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage((Serializable) o);
			}
		});
	}
	
	/**
	 * 接收消息
	 * @return
	 */
	public static Message receive() {
		return getJmsTemplate().receive(getDestination());
	}
	
	/**
	 * 接收消息(自定义目的点)
	 * @return
	 */
	public static Message receiveYourDest(Destination destination) {
		return getJmsTemplate().receive(destination);
	}
}

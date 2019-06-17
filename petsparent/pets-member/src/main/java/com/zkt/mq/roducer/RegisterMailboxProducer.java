
package com.zkt.mq.roducer;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * @classDesc: 功能描述:(往消息服务 推送 邮件信息)
 */
@Service("registerMailboxProducer")
public class RegisterMailboxProducer {
	@Autowired
    private JmsMessagingTemplate jmsMessagingTemplate ; 
	
	public void send(Destination destination,String json){
		jmsMessagingTemplate.convertAndSend(destination, json);
	}
}

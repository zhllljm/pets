
package com.zkt.mq.distribute;

import com.zkt.adapter.MessageAdapter;
import com.zkt.constants.MQInterfaceType;
import com.zkt.service.SMSMailboxService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @classDesc: 功能描述:(消费消息 mq 从队列获取最新消息)
 */
@Slf4j
@Component
public class ConsumerDistribute {
	@Autowired
	private SMSMailboxService smsMailboxService;

	@JmsListener(destination = "email_queue")
	public void distribute(String json) {
		log.info("###消息服务###收到消息,消息内容 json:{}", json);
		System.out.println(json);
		if (StringUtils.isEmpty(json)) {
			return;
		}
		JSONObject jsonObject = new JSONObject().parseObject(json);
		JSONObject header = jsonObject.getJSONObject("header");
		String interfaceType = header.getString("interfaceType");
		MessageAdapter messageAdapter = null;
		switch (interfaceType) {
		// 发送邮件
		case MQInterfaceType.SMS_MAIL:
			messageAdapter=smsMailboxService;
			break;

		default:
			break;
		}
		JSONObject content=jsonObject.getJSONObject("content");
		messageAdapter.distribute(content);

	}

}

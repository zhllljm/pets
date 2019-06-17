
package com.zkt.service;

import com.zkt.adapter.MessageAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SMSMailboxService  implements MessageAdapter {
	@Autowired
	private JavaMailSender mailSender; // 自动注入的Bean

	@Override
	public void distribute(JSONObject jsonObject) {
		String mail=jsonObject.getString("mail");
		String userName=jsonObject.getString("userName");
		log.info("###消费者收到消息... mail:{},userName:{}",mail,userName);
		// 发送邮件
		// 开始发送邮件
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mail);
		message.setTo(mail); // 自己给自己发送邮件
		message.setSubject("蚂蚁课堂第一期结业项目微信商城会员注册成功");
		message.setText("恭喜您"+userName+",成为微信商城的新用户!谢谢您的光临!www.itmayiedu.com");
		log.info("###发送短信邮箱 mail:{}", mail);
		mailSender.send(message);

	}

}

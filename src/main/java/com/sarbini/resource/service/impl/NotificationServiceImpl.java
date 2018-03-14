package com.sarbini.resource.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.sarbini.resource.model.NotificationData;
import com.sarbini.resource.service.NotificationService;

@Component
public class NotificationServiceImpl implements NotificationService {

	private final static Logger LOGGER = LoggerFactory.getLogger(NotificationServiceImpl.class);

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmail(NotificationData notificationData) {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message);
		try {
			messageHelper.setFrom(notificationData.getSource());
			messageHelper.setTo(notificationData.getDestination());
			messageHelper.setText(notificationData.getBodyText());
			messageHelper.setSubject(notificationData.getSubject());
			messageHelper.setCc(notificationData.getCopyList());
			mailSender.send(message);
		} catch (MessagingException e) {
			LOGGER.error("Error in sending message : ", e);
		}
	}

	@Override
	public void sendSms(NotificationData notificationData) {
		// TODO Auto-generated method stub
		
	}

}

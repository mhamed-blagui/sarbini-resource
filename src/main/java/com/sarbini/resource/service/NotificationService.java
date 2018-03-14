package com.sarbini.resource.service;

import com.sarbini.resource.model.NotificationData;

public interface NotificationService {
		
	void sendEmail(NotificationData notificationData);
	
	void sendSms(NotificationData notificationData);
}

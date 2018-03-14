package com.sarbini.resource.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationData {

	private String source;
	private String destination;
	private String bodyText;
	private String subject;
	private String[] copyList;
	private String phoneNumber;
}

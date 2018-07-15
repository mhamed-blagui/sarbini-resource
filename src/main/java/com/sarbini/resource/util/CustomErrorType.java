package com.sarbini.resource.util;

import lombok.Getter;

@Getter
public class CustomErrorType {

	private String errorMessage;

	public CustomErrorType(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}

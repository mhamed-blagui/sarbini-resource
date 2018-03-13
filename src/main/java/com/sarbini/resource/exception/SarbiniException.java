package com.sarbini.resource.exception;

import com.sarbini.resource.enums.ExceptionsCodesEnum;

public class SarbiniException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1247899681094996383L;

	private ExceptionsCodesEnum errorCode;

	private String detailMessage;

	public SarbiniException(String message, ExceptionsCodesEnum errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public SarbiniException(String message) {
		super(message);
	}

	public ExceptionsCodesEnum getErrorCode() {
		return errorCode;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

}

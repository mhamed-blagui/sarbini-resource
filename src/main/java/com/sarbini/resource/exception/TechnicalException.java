package com.sarbini.resource.exception;

import com.sarbini.resource.enums.ExceptionsCodesEnum;

public class TechnicalException extends SarbiniException {

	private static final long serialVersionUID = 1583017078694225249L;

	public TechnicalException(String message, ExceptionsCodesEnum errorCode) {
		super(message, errorCode);
	}

	public TechnicalException(String message) {
		super(message);
	}

}

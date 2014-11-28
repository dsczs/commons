package com.penglecode.common.web.interceptor;

import com.penglecode.common.exception.CustomException;

public class RepeatSubmitException extends CustomException {

	private static final long serialVersionUID = 1L;

	public RepeatSubmitException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepeatSubmitException(String message) {
		super(message);
	}

}

package com.penglecode.common.exception;

/**
 * 用于数据校验的Exception
 * 
 * @author	  	pengpeng
 * @date	  	2014年7月28日 下午2:53:59
 * @version  	1.0
 */
public class CustomDataValidationException extends CustomException {

	private static final long serialVersionUID = 1L;

	public CustomDataValidationException(String message) {
		super(message);
	}

	public CustomDataValidationException(String message, Throwable cause) {
		super(message, cause);
	}
	
}

package com.penglecode.common.exception;

/**
 * 用于业务校验的Exception
 * 
 * 
 * @author	  	pengpeng
 * @date	  	2014年7月28日 下午2:53:59
 * @version  	1.0
 */
public class CustomBusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomBusinessException(String message) {
		super(message);
	}

	public CustomBusinessException(String message, Throwable cause) {
		super(message, cause);
	}
	
}

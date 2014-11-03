package com.penglecode.common.exception;

/**
 * 自定义的运行时Exception
 * 
 * @author	  	pengpeng
 * @date	  	2014年11月3日 上午11:26:00
 * @version  	1.0
 */
public abstract class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomException(String message) {
		super(message);
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}
	
}

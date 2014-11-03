package com.penglecode.common.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * 自定义的app运行时异常
 * 
 * @author	  	pengpeng
 * @date	  	2014年7月19日 下午3:35:50
 * @version  	1.0
 */
public class NestedAppRuntimeException extends NestedRuntimeException {

	private static final long serialVersionUID = 1L;

	public NestedAppRuntimeException(String msg) {
		super(msg);
	}
	
	public NestedAppRuntimeException(String msg, Throwable cause) {
		super(msg, cause);
	}

}

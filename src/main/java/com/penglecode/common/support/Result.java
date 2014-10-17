package com.penglecode.common.support;

/**
 * 通用返回结果类
 *
 * @param <T>
 * @author pengpeng
 * @version 1.0
 * @date 2014年6月13日 上午8:59:37
 */
public class Result<T> {

    private boolean success;

    private String code;

    private String message;

    private T value;

	public Result() {
		super();
	}

	public Result(boolean success, String code, String message, T value) {
		super();
		this.success = success;
		this.code = code;
		this.message = message;
		this.value = value;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}

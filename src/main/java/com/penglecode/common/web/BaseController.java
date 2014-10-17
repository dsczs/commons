package com.penglecode.common.web;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {

	@SuppressWarnings("unchecked")
	public <T> T getRequestAttribute(HttpServletRequest request, String key) {
		return (T) request.getAttribute(key);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getSessionAttribute(HttpServletRequest request, String key) {
		return (T) request.getSession().getAttribute(key);
	}
	
	public void setRequestAttribute(HttpServletRequest request, String key, Object value) {
		request.setAttribute(key, value);
	}
	
	public void setSessionAttribute(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);
	}
	
}

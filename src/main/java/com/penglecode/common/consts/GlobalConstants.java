package com.penglecode.common.consts;

import java.util.Locale;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;

/**
 * 应用的全局常量,其中包括：Spring上下文对象、Servlet上下文对象、应用的上下文路径、应用系统默认字符集、默认Locale、默认日期格式等常量
 * 
 * @author	  	pengpeng
 * @date	  	2014年10月16日 上午11:02:27
 * @version  	1.0
 */
public abstract class GlobalConstants extends AbstractConstants {

	/**
	 * Spring的ROOT上下文,由@{link org.springframework.web.context.ContextLoaderListener}加载出来的spring上下文
	 */
	public static final ApplicationContext APPLICATION_CONTEXT = valueOf(null);
	
	/**
	 * Spring的MVC上下文,由@{link org.springframework.web.servlet.DispatcherServlet}加载出来的Spring MVC上下文
	 */
	public static final ApplicationContext MVC_APPLICATION_CONTEXT = valueOf(null);
	
	/**
	 * 应用中的Servlet上下文
	 */
	public static final ServletContext SERVLET_CONTEXT = valueOf(null); 
	
	/**
	 * 应用的上下文路径, e.g. /myapp
	 */
	public static final String CONTEXT_PATH = valueOf(null);
	
	/**
	 * 应用的上下文的实际路径, e.g. D:/Program Files/apache-tomcat-7.0.54-/webapps/myapp
	 */
	public static final String CONTEXT_REAL_PATH = valueOf(null);

	/**
	 * 系统默认字符编码
	 */
	public static final String SYSTEM_DEFAULT_ENCODING = valueOf("UTF-8");
	
	/**
	 * 系统默认Locale
	 */
	public static final Locale SYSTEM_DEFAULT_LOCALE = valueOf(new Locale("zh", "CN"));
	
	/**
	 * 返回结果之成功
	 */
	public static final String RESULT_RET_CODE_SUCCESS = valueOf("1");

	/**
	 * 返回结果之失败
	 */
	public static final String RESULT_RET_CODE_FAILURE = valueOf("0");

	/**
	 * 针对数据库字段,诸如:'是','真','已删除',...等等由数字"1"代表的真值
	 */
	public static final String DEFAULT_YES_TRUE_FLAG = valueOf("1");

	/**
	 * 针对数据库字段,诸如:'否','假','未删除',...等等由数字"0"代表的假值
	 */
	public static final String DEFAULT_NO_FALSE_FLAG = valueOf("0");
	
}

package com.penglecode.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 有关HTTP请求的工具类
 * 
 * @author	  	pengpeng
 * @date	  	2014年10月17日 下午7:27:18
 * @version  	1.0
 */
public class HttpUtils {

	/**
	 * 判断来的请求是否是异步请求
	 * @param request
	 * @return
	 */
    public static boolean isAsynRequest(HttpServletRequest request) {
    	return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

}

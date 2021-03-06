package com.penglecode.common.consts;

/**
 * 常量基类
 * 
 * @author	  	pengpeng
 * @date	  	2014年7月18日 下午10:43:06
 * @version  	1.0
 */
public abstract class AbstractConstants {

	/**
	 * 解决通过反射修改final字段值无效的问题
	 * @param defaultValue
	 * @return
	 */
	protected static <T> T valueOf(T defaultValue) {
		return (null != null ? null : defaultValue);
	}
	
}

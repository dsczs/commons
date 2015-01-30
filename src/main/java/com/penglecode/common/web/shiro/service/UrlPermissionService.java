package com.penglecode.common.web.shiro.service;

import java.util.Map;
/**
 * 获取系统中定义的全部url=perm配置
 * 
 * @author	  	pengpeng
 * @date	  	2015年1月28日 下午5:20:41
 * @version  	1.0
 */
public interface UrlPermissionService {

	/**
	 * 获取系统中定义的全部url=perm配置
	 * @return
	 */
	public Map<String,String> getAllUrlPermissions();
	
}

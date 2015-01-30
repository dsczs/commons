package com.penglecode.common.web.shiro.service;

import java.util.Set;

/**
 * 针对Principal当事人的一些方法(例如获取用户[当事人]的角色集合、获取用户[当事人]的权限结合等..)
 * @param <T>	- 一般指用户账户
 * @author	  	pengpeng
 * @date	  	2015年1月30日 上午10:39:49
 * @version  	1.0
 */
public interface PrincipalService<T> {

	/**
	 * 根据principal获取当事人的角色代码集
	 * @param principal			- 当事人
	 * @return
	 */
	public Set<String> getRoles(T principal);
	
	/**
	 * 根据principal获取当事人权限代码集
	 * @param principal			- 当事人
	 * @return
	 */
	public Set<String> getPermissions(T principal);
	
	/**
	 * 根据principal获取当事人的信息(用户名、密码啥的)
	 * @param principal			- 当事人
	 * @return
	 */
	public T getPrincipalObject(String principal);

	/**
	 * 清除用户授权缓存
	 * @param principal
	 */
	public void clearCachedAuthorizationInfo(String principal);

	/**
	 * 清除用户认证缓存
	 * @param principal
	 */
    public void clearCachedAuthenticationInfo(String principal);
	
}

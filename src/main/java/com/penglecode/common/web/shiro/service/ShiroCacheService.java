package com.penglecode.common.web.shiro.service;
/**
 * Shiro认证、授权缓存信息服务
 * 
 * @author	  	pengpeng
 * @date	  	2015年3月19日 上午10:31:48
 * @version  	1.0
 */
public interface ShiroCacheService {

	/**
	 * 清除用户授权信息缓存
	 * @param principal
	 */
	public void clearCachedAuthorizationInfo(String principal);

	/**
	 * 清除用户认证信息缓存
	 * @param principal
	 */
    public void clearCachedAuthenticationInfo(String principal);
    
    /**
     * 清除所有用户的授权信息缓存
     */
    public void clearAllCachedAuthorizationInfo();
    
    /**
     * 清除所有用户的认证信息缓存
     */
    public void clearAllCachedAuthenticationInfo();
	
}

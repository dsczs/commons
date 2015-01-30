package com.penglecode.common.web.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.penglecode.common.web.shiro.service.PrincipalService;
/**
 * 抽象的当事人Realm
 * 
 * @author	  	pengpeng
 * @date	  	2015年1月30日 上午9:38:46
 * @version  	1.0
 */
public abstract class AbstractPrincipalRealm<T> extends AuthorizingRealm {

	private PrincipalService<T> principalService;
	
	public PrincipalService<T> getPrincipalService() {
		return principalService;
	}

	public void setPrincipalService(PrincipalService<T> principalService) {
		this.principalService = principalService;
	}

	protected abstract AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals);

	protected abstract AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException;

    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
	
}

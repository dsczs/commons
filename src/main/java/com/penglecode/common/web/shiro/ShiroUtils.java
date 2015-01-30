package com.penglecode.common.web.shiro;

import java.util.Iterator;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.Realm;

import com.penglecode.common.util.CollectionUtils;

public class ShiroUtils {

	@SuppressWarnings("unchecked")
	public static <T> T getRealm(Class<? extends Realm> realmType){
		RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
		if(!CollectionUtils.isEmpty(securityManager.getRealms())){
			for(Iterator<Realm> it = securityManager.getRealms().iterator(); it.hasNext();){
				Realm realm = it.next();
				if(realm.getClass().equals(realmType)){
					return (T) realm;
				}
			}
		}
		return null;
	}
	
}

package com.penglecode.common.support;

/**
 * 全局唯一主键id生成器(分布式环境下)
 * 
 * @author	  	pengpeng
 * @date	  	2014年10月17日 下午8:09:05
 * @version  	1.0
 */
public abstract class AbstractDistributedIdGenerator implements IdGenerator {

	private String serverId;
	
	public String getServerId() {
		return serverId;
	}
	
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

}

package com.penglecode.common.consts;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public class RpcConstants extends AbstractConstants {
	
	@Value("${rpc.usercenter.url}")
	public static final String USER_CENTER_URL = valueOf(null);
	
	@Value("${rpc.usercenter.url}")
	public static final List<String> USER_CENTER_URLS = valueOf(null);
	
	@Value("${rpc.timeout}")
	public static final Integer RPC_TIMEOUT = valueOf(3000);
	
}

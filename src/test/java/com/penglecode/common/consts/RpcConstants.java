package com.penglecode.common.consts;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public class RpcConstants extends AbstractConstants {
	
	@Value("${rpc.usercenter.url}")
	public static final Constant<String> USER_CENTER_URL = valueOf(null);
	
	@Value("${rpc.usercenter.url}")
	public static final Constant<List<String>> USER_CENTER_URLS = valueOf(null);
	
	@Value("${rpc.timeout}")
	public static final Constant<Integer> RPC_TIMEOUT = valueOf(3000);
	
}

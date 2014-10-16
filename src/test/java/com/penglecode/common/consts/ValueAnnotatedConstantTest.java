package com.penglecode.common.consts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-base.xml"})
public class ValueAnnotatedConstantTest {

	@Test
	public void test1(){
		System.out.println(GlobalConstants.APPLICATION_CONTEXT.VALUE());
		System.out.println(RpcConstants.USER_CENTER_URL.VALUE());
		System.out.println(RpcConstants.USER_CENTER_URLS.VALUE());
		System.out.println(RpcConstants.RPC_TIMEOUT.VALUE());
	}
	
}

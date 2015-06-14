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
		System.out.println(CommonConstants.APPLICATION_CONTEXT);
		System.out.println(RpcConstants.USER_CENTER_URL);
		System.out.println(RpcConstants.USER_CENTER_URLS);
		System.out.println(RpcConstants.RPC_TIMEOUT);
		System.out.println(PaymentEnum.PAYMENT_ALIPAY.getVendor() + " , " + PaymentEnum.PAYMENT_ALIPAY.getPayUrl());
	}
	
}

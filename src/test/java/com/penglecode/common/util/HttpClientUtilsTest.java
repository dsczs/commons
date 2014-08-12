package com.penglecode.common.util;

import org.junit.Test;

public class HttpClientUtilsTest {

	@Test
	public void testDoGet(){
		String html = HttpClientUtils.doGet("http://www.baidu.com");
		System.out.println(html);
	}
	
	@Test
	public void testDoPost(){
		String html = HttpClientUtils.doPost("http://www.baidu.com", null);
		System.out.println(html);
	}
	
}

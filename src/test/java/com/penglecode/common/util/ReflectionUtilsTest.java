package com.penglecode.common.util;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

public class ReflectionUtilsTest {

	private Url url;
	
	@Before
	public void setUp(){
		url = new Url("127.0.0.1", 8080, "/index.html");
	}
	
	@Test
	public void testFindField(){
		System.out.println(">>> " + url);
		Field hostField = ReflectionUtils.findField(url.getClass(), "host");
		System.out.println(">>> field[host] = " + hostField);
	}
	
	@Test
	public void testSetFieldValue(){
		System.out.println(">>> " + url);
		Field hostField = ReflectionUtils.findField(url.getClass(), "host");
		System.out.println(">>> field[host] = " + hostField);
		ReflectionUtils.setFieldValue(hostField, url, "192.168.1.101");
		System.out.println(">>> " + url);
	}
	
	@Test
	public void testGetFieldValue(){
		System.out.println(">>> " + url);
		Field hostField = ReflectionUtils.findField(url.getClass(), "host");
		System.out.println(">>> host value = " + ReflectionUtils.getFieldValue(hostField, url));
	}
	
}

class Url {
	
	public static final String DEFAULT_PROTOCOL = "http://".toLowerCase();
	
	private String host;
	
	private int port;
	
	private String path;

	public Url() {
		super();
	}

	public Url(String host, int port, String path) {
		super();
		this.host = host;
		this.port = port;
		this.path = path;
	}

	public String buildUrl(){
		return DEFAULT_PROTOCOL + host + port + path;
	}

	public String toString() {
		return "Url [host=" + host + ", port=" + port + ", path=" + path + "]";
	}
	
}
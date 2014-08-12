package com.penglecode.common.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

public class ObjectUtilsTest {

	@Test
	public void testIsEmpty(){
		Object[] objects = new Object[] { null, "", " ", "null", new String[0],
				new ArrayList<Object>(), new HashMap<String, Object>(),
				new HashSet<Object>(), new Object() };
		for(Object obj : objects){
			System.out.println(">>> isEmpty = " + ObjectUtils.isEmpty(obj));
		}
	}
	
	@Test
	public void testIsArray(){
		System.out.println(">>> isArray = " + ObjectUtils.isArray(new String[0]));
	}
	
	@Test
	public void testDefaultIfNull(){
		Object d = null;
		System.out.println(">>> defaultIfNull = " + ObjectUtils.defaultIfNull(d, new Date()));
	}
	
	@Test
	public void testEquals(){
		System.out.println(">>> equals = " + ObjectUtils.equals(null, null));
		System.out.println(">>> equals = " + ObjectUtils.equals(null, "123"));
		System.out.println(">>> equals = " + ObjectUtils.equals("123", null));
		System.out.println(">>> equals = " + ObjectUtils.equals("123", "123"));
	}
	
	@Test
	public void testMin(){
		System.out.println(ObjectUtils.min(null, 1, 2, 3, 4, 5));
	}
	
	@Test
	public void testMax(){
		System.out.println(ObjectUtils.max(null, 1, 2, 3, 4, 5));
	}
	
}

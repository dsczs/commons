package com.penglecode.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class CollectionUtilsTest {

	@Test
	public void testIsEmpty(){
		System.out.println(">>> isEmpty = " + CollectionUtils.isEmpty(new ArrayList<Object>()));
		System.out.println(">>> isEmpty = " + CollectionUtils.isEmpty(new HashMap<String, Object>()));
		System.out.println(">>> isEmpty = " + CollectionUtils.isEmpty(new HashSet<Object>()));
	}
	
	@Test
	public void testContainsNull(){
		List<Object> list = new ArrayList<Object>();
		list.add("123");
		list.add(3.14);
		list.add(new Object());
		System.out.println(">>> containsNull = " + CollectionUtils.containsNull(list));
		list.add(null);
		System.out.println(">>> containsNull = " + CollectionUtils.containsNull(list));
	}
	
	@Test
	public void testFilterNull(){
		List<Object> list = new ArrayList<Object>();
		list.add("123");
		list.add(null);
		list.add(3.14);
		list.add(null);
		list.add(new Object());
		System.out.println(">>> list before filter null element = " + list);
		CollectionUtils.filterNull(list);
		System.out.println(">>> list after filter null element = " + list);
	}
	
}

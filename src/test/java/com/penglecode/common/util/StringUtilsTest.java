package com.penglecode.common.util;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testIsEmpty(){
		String[] elements = new String[]{null, "", " ", "null", "abc", " abc "};
		for(String s : elements){
			System.out.println(">>> isEmpty = " + StringUtils.isEmpty(s));
		}
	}
	
	@Test
	public void testHasLength(){
		String[] elements = new String[]{null, "", " ", "abc", " abc "};
		for(String s : elements){
			System.out.println(">>> hasLength = " + StringUtils.hasLength(s));
		}
	}
	
	@Test
	public void testTrim(){
		String[] elements = new String[]{null, "", " ", "abc", " abc "};
		for(String s : elements){
			System.out.println(">>> trim = " + StringUtils.trim(s));
		}
	}
	
	@Test
	public void testTrimAll(){
		String[] elements = new String[]{null, "", " ", "abc", " a b c "};
		for(String s : elements){
			System.out.println(">>> trimAll = " + StringUtils.trimAll(s));
		}
	}
	
	@Test
	public void testTrimToNull(){
		String[] elements = new String[]{null, "", " ", "abc", " a b c "};
		for(String s : elements){
			System.out.println(">>> trimToNull = " + StringUtils.trimToNull(s));
		}
	}
	
	@Test
	public void testTrimToEmpty(){
		String[] elements = new String[]{null, "", " ", "abc", " a b c "};
		for(String s : elements){
			System.out.println(">>> trimToEmpty = " + StringUtils.trimToEmpty(s));
		}
	}
	
	@Test
	public void testDefaultIfNull(){
		String[] elements = new String[]{null, "", " ", "abc"};
		for(String s : elements){
			System.out.println(">>> defaultIfNull = " + StringUtils.defaultIfNull(s));
		}
	}
	
	@Test
	public void testDefaultIfNull2(){
		String[] elements = new String[]{null, "", " ", "abc"};
		for(String s : elements){
			System.out.println(">>> defaultIfNull = " + StringUtils.defaultIfNull(s, "my-default"));
		}
	}
	
	@Test
	public void testDefaultIfEmpty(){
		String[] elements = new String[]{null, "", " ", "abc"};
		for(String s : elements){
			System.out.println(">>> defaultIfEmpty = " + StringUtils.defaultIfEmpty(s));
		}
	}
	
	@Test
	public void testDefaultIfEmpty2(){
		String[] elements = new String[]{null, "", " ", "abc"};
		for(String s : elements){
			System.out.println(">>> defaultIfEmpty = " + StringUtils.defaultIfEmpty(s, "my-default"));
		}
	}
	
	@Test
	public void testEquals(){
		System.out.println(">>> StringUtils.equals(null, null) = " + StringUtils.equals(null, null));
		System.out.println(">>> StringUtils.equals('', null) = " + StringUtils.equals("", null));
		System.out.println(">>> StringUtils.equals(abc, null) = " + StringUtils.equals("abc", null));
		System.out.println(">>> StringUtils.equals(abc, abc) = " + StringUtils.equals("abc", "abc"));
		System.out.println(">>> StringUtils.equals(abc, ABC) = " + StringUtils.equals("abc", "ABC"));
	}
	
	@Test
	public void testEqualsIgnoreCase(){
		System.out.println(">>> StringUtils.equalsIgnoreCase(null, null) = " + StringUtils.equalsIgnoreCase(null, null));
		System.out.println(">>> StringUtils.equalsIgnoreCase('', null) = " + StringUtils.equalsIgnoreCase("", null));
		System.out.println(">>> StringUtils.equalsIgnoreCase(abc, null) = " + StringUtils.equalsIgnoreCase("abc", null));
		System.out.println(">>> StringUtils.equalsIgnoreCase(abc, abc) = " + StringUtils.equalsIgnoreCase("abc", "abc"));
		System.out.println(">>> StringUtils.equalsIgnoreCase(abc, ABC) = " + StringUtils.equalsIgnoreCase("abc", "ABC"));
	}
	
	@Test
	public void testTrimEquals(){
		System.out.println(">>> StringUtils.trimEquals(null, null) = " + StringUtils.trimEquals(null, null));
		System.out.println(">>> StringUtils.trimEquals('', null) = " + StringUtils.trimEquals("", null));
		System.out.println(">>> StringUtils.trimEquals(abc, null) = " + StringUtils.trimEquals("abc", null));
		System.out.println(">>> StringUtils.trimEquals(' abc ', abc) = " + StringUtils.trimEquals(" abc ", "abc"));
		System.out.println(">>> StringUtils.trimEquals(abc, ABC) = " + StringUtils.trimEquals("abc", "ABC"));
	}
	
	@Test
	public void testTrimEqualsIgnoreCase(){
		System.out.println(">>> StringUtils.trimEqualsIgnoreCase(null, null) = " + StringUtils.trimEqualsIgnoreCase(null, null));
		System.out.println(">>> StringUtils.trimEqualsIgnoreCase('', null) = " + StringUtils.trimEqualsIgnoreCase("", null));
		System.out.println(">>> StringUtils.trimEqualsIgnoreCase(abc, null) = " + StringUtils.trimEqualsIgnoreCase("abc", null));
		System.out.println(">>> StringUtils.trimEqualsIgnoreCase(' abc ', abc) = " + StringUtils.trimEqualsIgnoreCase(" abc ", "abc"));
		System.out.println(">>> StringUtils.trimEqualsIgnoreCase(abc, ' ABC  ') = " + StringUtils.trimEqualsIgnoreCase("abc", " ABC  "));
	}
	
	@Test
	public void testStrip(){
		String[] elements = new String[]{null, "", "   ", "   abc   "};
		for(String s : elements){
			System.out.println(">>> strip = " + StringUtils.strip(s, null));
		}
	}
	
	@Test
	public void testStripStart(){
		String[] elements = new String[]{null, "", "   ", "   abc   "};
		for(String s : elements){
			System.out.println(">>> stripStart = " + StringUtils.stripStart(s, null));
		}
	}
	
	@Test
	public void testStripEnd(){
		String[] elements = new String[]{null, "", "   ", "   abc   "};
		for(String s : elements){
			System.out.println(">>> stripEnd = " + StringUtils.stripEnd(s, null));
		}
	}
	
	@Test
	public void testLeftPad(){
		String[] elements = new String[]{ "1", "11", "111", " 1111 ", "8888888888888888"};
		for(String s : elements){
			System.out.println(">>> leftPad = " + StringUtils.leftPad(s, '0', 8));
		}
	}
	
	@Test
	public void testRightPad(){
		String[] elements = new String[]{ "1", "11", "111", " 1111 ", "8888888888888888"};
		for(String s : elements){
			System.out.println(">>> rightPad = " + StringUtils.rightPad(s, '0', 8));
		}
	}
	
	@Test
	public void testIsAlpha(){
		String[] elements = new String[]{ "", "  ", "ab12", " abc ", "abcd"};
		for(String s : elements){
			System.out.println(">>> isAlpha = " + StringUtils.isAlpha(s));
		}
	}
	
	@Test
	public void testIsNumeric(){
		String[] elements = new String[]{ "", "  ", "ab12", " 123 ", "3.14", "123"};
		for(String s : elements){
			System.out.println(">>> isNumeric = " + StringUtils.isNumeric(s));
		}
	}
	
	@Test
	public void testReverse(){
		System.out.println(">>> reverse = " + StringUtils.reverse("abcdefg"));
	}
	
}

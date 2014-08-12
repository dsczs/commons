package com.penglecode.common.util;

import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;

public class DateTimeUtilsTest {

	@Test
	public void testFormat(){
		Date date = new Date();
		String[] patterns = new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss", "HH:mm:ss"};
		for(String pattern : patterns){
			System.out.println(DateTimeUtils.format(date, pattern));
		}
	}
	
	@Test
	public void testFormatNow(){
		String[] patterns = new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss.SSS", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss", "HH:mm:ss"};
		for(String pattern : patterns){
			System.out.println(DateTimeUtils.formatNow(pattern));
		}
	}
	
	@Test
	public void testFrom(){
		Date date = new Date();
		DateTime dateTime = DateTimeUtils.from(date);
		System.out.println(dateTime);
		Date date1 = DateTimeUtils.from(dateTime);
		System.out.println(date.equals(date1));
	}
	
	@Test
	public void testParse(){
		String dateTimeText = null;
		dateTimeText = "2012-12-12";
		System.out.println(">>> " + dateTimeText + " = " + DateTimeUtils.parse(dateTimeText, "yyyy-MM-dd"));
		dateTimeText = "2012-12-12 12:12:12";
		System.out.println(">>> " + dateTimeText + " = " + DateTimeUtils.parse(dateTimeText, "yyyy-MM-dd HH:mm:ss"));
		
		dateTimeText = "2012/12/12";
		System.out.println(">>> " + dateTimeText + " = " + DateTimeUtils.parse(dateTimeText, "yyyy/MM/dd"));
		dateTimeText = "2012/12/12 12:12:12";
		System.out.println(">>> " + dateTimeText + " = " + DateTimeUtils.parse(dateTimeText, "yyyy/MM/dd HH:mm:ss"));
		
		dateTimeText = "2012.12.12";
		System.out.println(">>> " + dateTimeText + " = " + DateTimeUtils.parse(dateTimeText, "yyyy.MM.dd"));
		dateTimeText = "2012.12.12 12:12:12";
		System.out.println(">>> " + dateTimeText + " = " + DateTimeUtils.parse(dateTimeText, "yyyy.MM.dd HH:mm:ss"));
		
		dateTimeText = "12:12:12";
		System.out.println(">>> " + dateTimeText + " = " + DateTimeUtils.parse(dateTimeText, "HH:mm:ss"));
	}
	
	@Test
	public void testSimpleDateFormat() throws Exception {
		String dateFormat = "yyyy-MM-dd HH:mm:ss";
		String text = "2014-07-26 12:45:07.0";
		System.out.println(DateTimeUtils.parse(text, dateFormat));
	}
	
}

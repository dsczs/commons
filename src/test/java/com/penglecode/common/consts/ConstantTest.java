package com.penglecode.common.consts;

import org.junit.Test;

public class ConstantTest {
	
	@Test
	public void testConstant(){
		System.out.println(null == null);
		System.out.println(GlobalConstants.SYSTEM_DEFAULT_ENCODING.VALUE());
		System.out.println(GlobalConstants.SYSTEM_DEFAULT_LOCALE);
	}
	
}

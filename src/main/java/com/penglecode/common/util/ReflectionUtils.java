package com.penglecode.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.util.Assert;

/**
 * 反射工具类
 * 
 * @author	  	pengpeng
 * @date	  	2014年7月19日 下午7:12:07
 * @version  	1.0
 */
public class ReflectionUtils {
	
	/**
	 * <p>根据属性字段名称获取@{code java.lang.reflect.Field}</p>
	 * 
	 * @param targetClass
	 * @param fieldName
	 * @return
	 */
	public static Field findField(Class<?> targetClass, String fieldName) {
		Assert.notNull(targetClass, "Parameter 'targetClass' must be not null!");
		Assert.hasText(fieldName, "Parameter 'fieldName' must be not empty!");
		Class<?> searchType = targetClass;
		while (!Object.class.equals(searchType) && searchType != null) {
			Field[] fields = searchType.getDeclaredFields();
			for (Field field : fields) {
				if (fieldName.equals(field.getName())) {
					return field;
				}
			}
			searchType = searchType.getSuperclass();
		}
		return null;
	}
	
	/**
	 * <p>在目标对象上设置属性字段的值(包括修改final字段的值)</p>
	 * 
	 * @param field
	 * @param target
	 * @param value
	 */
	public static void setFieldValue(Field field, Object target, Object value) {
		try {
			field.setAccessible(true);
			field.set(target, value);
		} catch (Exception e) {
			throw new ReflectionException(String.format("setting field's value failed by reflection! error message is: %s", e.getMessage()), e);
		}
	}
	
	/**
	 * <p>在目标对象上获取属性字段的值</p>
	 * 
	 * @param field
	 * @param target
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getFieldValue(Field field, Object target) {
		try {
			field.setAccessible(true);
			return (T) field.get(target);
		} catch (Exception e) {
			throw new ReflectionException(String.format("getting field's value failed by reflection! error message is: %s", e.getMessage()), e);
		}
	}
	
	/**
	 * <p>根据方法名字及入参在类中查找方法</p>
	 * 
	 * @param targetClass
	 * @param methodName
	 * @param paramTypes
	 * @return
	 */
	public static Method findMethod(Class<?> targetClass, String methodName, Class<?>... paramTypes) {
		Assert.notNull(targetClass, "Parameter 'targetClass' can not be null!");
		Assert.hasText(methodName, "Parameter 'methodName' can not be empty!");
		Class<?> searchType = targetClass;
		while (searchType != null) {
			Method[] methods = (searchType.isInterface() ? searchType.getMethods() : searchType.getDeclaredMethods());
			for (Method method : methods) {
				if (methodName.equals(method.getName())
						&& (paramTypes == null || Arrays.equals(paramTypes, method.getParameterTypes()))) {
					return method;
				}
			}
			searchType = searchType.getSuperclass();
		}
		return null;
	}
	
	/**
	 * <p>根据方法名字在类中查找其无参方法</p>
	 * 
	 * @param targetClass
	 * @param methodName
	 * @return
	 */
	public static Method findMethod(Class<?> targetClass, String methodName) {
		return findMethod(targetClass, methodName, new Class[0]);
	}
	
	/**
	 * <p>在某个对象上调用某个无参方法</p>
	 * 
	 * @param method
	 * @param target
	 * @return
	 */
	public static <T> T invokeMethod(Method method, Object target) {
		return invokeMethod(method, target, new Object[0]);
	}

	/**
	 * <p>在某个对象上调用某个有参方法</p>
	 * 
	 * @param method	- Method方法对象
	 * @param target	- 方法所属目标对象
	 * @param args		- 方法入参
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T invokeMethod(Method method, Object target, Object... args) {
		try {
			method.setAccessible(true);
			return (T) method.invoke(target, args);
		} catch (Exception e) {
			throw new ReflectionException(String.format("invoke method failed by reflection! error message is: %s", e.getMessage()), e);
		}
	}
	
	public static class ReflectionException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public ReflectionException(String message, Throwable cause) {
			super(message, cause);
		}

		public ReflectionException(String message) {
			super(message);
		}

		public ReflectionException(Throwable cause) {
			super(cause);
		}
		
	}
	
}
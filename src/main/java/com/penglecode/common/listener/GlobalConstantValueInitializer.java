package com.penglecode.common.listener;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.AbstractPropertyResolver;

import com.penglecode.common.consts.AbstractConstants.Constant;
import com.penglecode.common.util.ClassScanningUtils;
import com.penglecode.common.util.ClassUtils;
import com.penglecode.common.util.CollectionUtils;
import com.penglecode.common.util.ReflectionUtils;

/**
 * 全局常量值注入处理器,
 * 即从properties属性配置文件中将相应的配置通过@Value注解注入到public static final的常量字段上去,
 * 使用示例1(应用于普通常量)：
 * 
 * //该URLConstants无需作为一个bean被Spring托管
 * public class URLConstants extends AbstractConstants {
 *
 *		@Value("${image.server.domain}") //属性文件中须配有image.server.domain=xxx
 *		public static final Constant<String> IMAGE_SERVER_DOMAIN = valueOf(null);
 *	
 *		@Value("${ordercenter.server.url}")
 *		public static final Constant<String> ORDER_CENTER_SERVER_URL = valueOf(null);
 * 		
 * 		...
 * }
 * 
 * @author	  	pengpeng
 * @date	  	2014年7月17日 下午1:57:00
 * @version  	1.0
 */
public class GlobalConstantValueInitializer extends AbstractApplicationInitializer {

	private static final Logger logger = LoggerFactory.getLogger(GlobalConstantValueInitializer.class);

	private String basePackage;
	
	/**
	 * 找不到属性会报错 ? false - 会, true - 不会
	 */
	private boolean ignoreUnresolvablePlaceholders = true;
	
	private AbstractPropertyResolver globalPropertyResolver;
	
	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public void setIgnoreUnresolvablePlaceholders(boolean ignoreUnresolvablePlaceholders) {
		this.ignoreUnresolvablePlaceholders = ignoreUnresolvablePlaceholders;
	}

	public void setGlobalPropertyResolver(AbstractPropertyResolver globalPropertyResolver) {
		this.globalPropertyResolver = globalPropertyResolver;
	}

	public void initialize(ApplicationContext applicationContext) throws Exception {
		logger.info(">>> 初始化被@Value注解的常量字段值(值来自properties配置文件)!");
		processInject();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void processInject() throws Exception {
		Assert.hasLength(basePackage, "Property 'basePackage' must be specified!");
		Assert.notNull(globalPropertyResolver, "Property 'globalPropertyResolver' must be specified!");
		List<String> classNameList = ClassScanningUtils.scanPackages(basePackage);
        if(!CollectionUtils.isEmpty(classNameList)) {
            for(String className : classNameList) {
                Class<?> clazz = ClassUtils.forName(className, Thread.currentThread().getContextClassLoader());
                Field[] fields = clazz.getFields();
                if(fields != null) {
                    for(Field field : fields) {
                    	if(field.isAnnotationPresent(Value.class)){
                    		if(isConstantField(field) && field.getType().equals(Constant.class)){
                    			Value valueAnnotation = field.getAnnotation(Value.class);
                            	String rawValue = valueAnnotation.value();
                            	rawValue = ignoreUnresolvablePlaceholders ? globalPropertyResolver.resolvePlaceholders(rawValue) : globalPropertyResolver.resolveRequiredPlaceholders(rawValue);
                            	if(rawValue != null){
                            		applyConstantValue((Constant)field.get(null), globalPropertyResolver.getConversionService().convert(rawValue, ReflectionUtils.getFieldGenricType(field)));
                            	}
                    		}
                    	}
                    }
                }
            }
        }
	}
	
	/**
	 * 修饰符中同时包含public static的即被认为是常量
	 * @param field
	 * @return
	 */
	protected boolean isConstantField(Field field) {
		int mod = field.getModifiers();
		return Modifier.isFinal(mod) && Modifier.isStatic(mod);
	}

}

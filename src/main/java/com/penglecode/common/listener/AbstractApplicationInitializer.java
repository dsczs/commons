package com.penglecode.common.listener;

import java.lang.reflect.Field;

import com.penglecode.common.consts.AbstractConstants;
import com.penglecode.common.consts.AbstractConstants.Constant;
import com.penglecode.common.util.ReflectionUtils;

/**
 * 应用程序初始化基类
 * 
 * @author	  	pengpeng
 * @date	  	2014年10月14日 下午4:01:51
 * @version  	1.0
 */
public abstract class AbstractApplicationInitializer implements ApplicationInitializer {

    protected <T> void applyConstantValue(Constant<T> constant, T value) {
    	Field field = ReflectionUtils.findField(AbstractConstants.Constant.class, "value");
    	ReflectionUtils.setFieldValue(field, constant, value);
    }
    
}

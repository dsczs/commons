package com.penglecode.common.support;

import org.springframework.context.support.AbstractMessageSource;
import org.springframework.util.Assert;

import com.penglecode.common.consts.ApplicationGlobalConstants;

import java.util.Locale;

/**
 * 全局国际化资源文件获取工具类
 * 
 * @author	  	pengpeng
 * @date	  	2014年7月28日 下午9:28:22
 * @version  	1.0
 */
public class Messages {

    public static final Locale DEFAULT_LOCALE = ApplicationGlobalConstants.SYSTEM_DEFAULT_LOCALE.VALUE();

    private static AbstractMessageSource messageSource;

    public static void setMessageSource(AbstractMessageSource messageSource) {
        Messages.messageSource = messageSource;
    }

    public static String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        String message = messageSource.getMessage(code, args, defaultMessage, locale);
        Assert.hasText(message, "No message found in i18n message resource file!");
        return message;
    }

    public static String getMessage(String code, Object[] args, String defaultMessage) {
        String message = messageSource.getMessage(code, args, defaultMessage, DEFAULT_LOCALE);
        Assert.hasText(message, "No message found in i18n message resource file!");
        return message;
    }

    public static String getMessage(String code, Object[] args) {
        String message = messageSource.getMessage(code, args, "", DEFAULT_LOCALE);
        Assert.hasText(message, "No message found in i18n message resource file!");
        return message;
    }

    public static String getMessage(String code, String args0) {
        String message = messageSource.getMessage(code, new Object[]{args0}, "", DEFAULT_LOCALE);
        Assert.hasText(message, "No message found in i18n message resource file!");
        return message;
    }

    public static String getMessage(String code) {
        String message = messageSource.getMessage(code, null, "", DEFAULT_LOCALE);
        Assert.hasText(message, "No message found in i18n message resource file for message code '" + code + "'!");
        return message;
    }

}
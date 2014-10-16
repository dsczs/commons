package com.penglecode.common.listener;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.penglecode.common.consts.GlobalConstants;
import com.penglecode.common.util.FileUtils;


/**
 * 应用中依赖于Servlet环境的系统常量初始化
 * 
 * 注：由于该初始化程序中涉及到容器上下文(ServletContext)即需要Servlet容器环境的支持,因此该初始化bean必须配置在springmvc配置文件中
 * 
 * @author 	pengpeng
 * @version 	1.0
 * @date 		2014-07-03 下午3:52:15
 */
public class ServletBootingInitializer extends AbstractApplicationInitializer {

    private static final Logger logger = LoggerFactory.getLogger(ServletBootingInitializer.class);

    public void initialize(ApplicationContext applicationContext) throws Exception {
    	WebApplicationContext mvcApplicationContext = null;
    	if(applicationContext instanceof WebApplicationContext && applicationContext.getParent() != null){
    		mvcApplicationContext = (WebApplicationContext) applicationContext;
    		ServletContext servletContext = mvcApplicationContext.getServletContext();
    		logger.info(">>> 初始化应用中依赖于Servlet环境的系统常量!");
    		applyConstantValue(GlobalConstants.MVC_APPLICATION_CONTEXT, applicationContext);
    		applyConstantValue(GlobalConstants.SERVLET_CONTEXT, servletContext);
    		applyConstantValue(GlobalConstants.CONTEXT_PATH, FileUtils.formatFilePath(servletContext.getContextPath()));
    		applyConstantValue(GlobalConstants.CONTEXT_REAL_PATH, FileUtils.formatFilePath(servletContext.getRealPath("/")));
    	}
    }
}

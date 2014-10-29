package com.penglecode.common.support;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.context.support.ServletContextResourcePatternResolver;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * logback日志组件初始化Listener
 * 
 * @author	  	pengpeng
 * @date	  	2014年10月28日 下午8:16:45
 * @version  	1.0
 */
public class LogbackConfigListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(LogbackConfigListener.class);

    private static final String CONFIG_LOCATION = "logbackConfigLocation";

    public void contextInitialized(ServletContextEvent event) {
        //从web.xml中加载指定文件名的日志配置文件
        String logbackConfigLocation = event.getServletContext().getInitParameter(CONFIG_LOCATION);
        String fullFileName = null;
        try {
            PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new ServletContextResourcePatternResolver(event.getServletContext());
            Resource resource = pathMatchingResourcePatternResolver.getResource(logbackConfigLocation);
            fullFileName = resource.getFile().getAbsolutePath();
            LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
            loggerContext.reset();
            JoranConfigurator joranConfigurator = new JoranConfigurator();
            joranConfigurator.setContext(loggerContext);
            joranConfigurator.doConfigure(resource.getFile());
            logger.debug("loaded slf4j configure file from {}", fullFileName);
        } catch (Exception e) {
            logger.error("can loading slf4j configure file from " + logbackConfigLocation, e);
        }
    }

    public void contextDestroyed(ServletContextEvent event) {
    }
}
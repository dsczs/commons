package com.penglecode.common.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.WebApplicationContext;

import com.penglecode.common.util.CollectionUtils;

/**
 * Spring应用程序启动/关闭监听器
 * 
 * @author	  	pengpeng
 * @date	  	2014年10月14日 下午4:05:38
 * @version  	1.0
 */
public class ApplicationContextListener implements ApplicationListener<ApplicationEvent> {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationContextListener.class);

    private static final String KEY_INITIALIZED_CONTEXT_ID = "INITIALIZED";
    
    private static final String KEY_DESTROYED_CONTEXT_ID = "DESTROYED";
    
    /**
     * 解决Spring上下文refresh的时候重复加载的问题
     */
    private static final Map<String,List<String>> APPLICATIONCONTEXT_ID_MAP = new HashMap<String,List<String>>(){
		private static final long serialVersionUID = 1L;
		{
			put(KEY_INITIALIZED_CONTEXT_ID, new ArrayList<String>());
			put(KEY_DESTROYED_CONTEXT_ID, new ArrayList<String>());
		}
    };
    
    private List<ApplicationInitializer> applicationInitializers;
    
    public void setApplicationInitializers(List<ApplicationInitializer> applicationInitializers) {
		this.applicationInitializers = applicationInitializers;
	}

	public void onApplicationEvent(ApplicationEvent event) {
        	ApplicationContext currentApplicationContext = null;
            if (event instanceof ContextRefreshedEvent) {
            	try {
	            	currentApplicationContext = ((ContextRefreshedEvent) event).getApplicationContext();
	            	if(!APPLICATIONCONTEXT_ID_MAP.get(KEY_INITIALIZED_CONTEXT_ID).contains(currentApplicationContext.getId())){
	            		try {
							contextInitialized(currentApplicationContext);
						} finally {
							APPLICATIONCONTEXT_ID_MAP.get(KEY_INITIALIZED_CONTEXT_ID).add(currentApplicationContext.getId());
						}
	            	}
	            } catch (Exception e) {
	                RuntimeException ex = new RuntimeException("application initialization failed!", e);
	                logger.error(ex.getMessage(), e);
	                throw ex;
	            }
            } else if (event instanceof ContextClosedEvent) {
            	try {
	            	currentApplicationContext = ((ContextClosedEvent) event).getApplicationContext();
	            	if(!APPLICATIONCONTEXT_ID_MAP.get(KEY_DESTROYED_CONTEXT_ID).contains(currentApplicationContext.getId())){
	            		try {
	            			contextDestroyed(currentApplicationContext);
						} finally {
							APPLICATIONCONTEXT_ID_MAP.get(KEY_DESTROYED_CONTEXT_ID).add(currentApplicationContext.getId());
						}
	            	}
	            } catch (Exception e) {
	            	RuntimeException ex = new RuntimeException("application destroy failed!", e);
	                logger.error(ex.getMessage(), e);
	                throw ex;
	            }
            }
        
    }

    /**
     * Spring应用加载完毕
     *
     * @param servletContext
     */
    public void contextInitialized(ApplicationContext applicationContext) throws Exception {
    	String mode = applicationContext instanceof WebApplicationContext ? "Java Servlet Mode" : "Java Application Mode";
        logger.info(String.format("application initializing start in %s", mode));
        logger.info("application initializing begin ...");
        if (!CollectionUtils.isEmpty(applicationInitializers)) {
            for (ApplicationInitializer applicationInitializer : applicationInitializers) {
            	applicationInitializer.initialize(applicationContext);
            }
        }
        logger.info("application initializing end ...");
    }

    /**
     * Spring应用关闭
     *
     * @param applicationContext
     */
    public void contextDestroyed(ApplicationContext applicationContext) throws Exception {
    	String mode = applicationContext instanceof WebApplicationContext ? "Java Servlet Mode" : "Java Application Mode";
    	logger.info(String.format("application destroyed in %s", mode));
    }

}

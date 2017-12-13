package com.learning.boot.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@WebListener
public class AppVariableInitiator implements ServletContextListener{
	private static final Logger logger = LoggerFactory.getLogger(AppVariableInitiator.class);
	
	@Autowired
	private AppVariable resource;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		context.setAttribute("appBase", context.getContextPath());
		
		try {
			String pomPropertiesPath = AppVariableInitiator.class.getResource(
					resource.getPomPropertiesPath()).getPath();
			logger.info("PomPropertiesPath is {}", pomPropertiesPath);
			String version = getVersion(pomPropertiesPath);
			context.setAttribute("version", version);
			logger.info("Application version is {}", version);
		} catch (Exception e) {
			logger.error("loading version has error!", e);
		}
	}
	
	private String getVersion(String path) throws IOException{
		if(StringUtils.isNotBlank(path)){
			Properties properties = new Properties();
			FileInputStream in = new FileInputStream(path);
			properties.load(in);
			properties.clone();
			return properties.getProperty("version");
		}
        return StringUtils.EMPTY;
	}
}

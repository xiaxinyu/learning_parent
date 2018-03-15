package com.learning.boot.core;

import java.io.InputStream;
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
public class AppInitiator implements ServletContextListener {
	private static final Logger logger = LoggerFactory.getLogger(AppInitiator.class);

	@Autowired
	private AppParameters resource;

	@Override
	public void contextDestroyed(ServletContextEvent event) {

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		context.setAttribute("appBase", context.getContextPath());

		if (!"dev".equalsIgnoreCase(resource.getEnvironment())) {
			String version = getVersion();
			context.setAttribute("version", version);
			logger.info("Application version is {}", version);
		}
	}

	private String getVersion() {
		try {
			InputStream inputStream = this.getClass().getResourceAsStream(resource.getPomPropertiesPath());
			Properties properties = new Properties();
			properties.load(inputStream);
			inputStream.close();
			return properties.getProperty("version");
		} catch (Exception e) {
			logger.error("loading version has error!", e);
		}
		return StringUtils.EMPTY;
	}
}

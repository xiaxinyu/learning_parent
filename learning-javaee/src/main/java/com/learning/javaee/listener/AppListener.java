package com.learning.javaee.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("AppListener is destroying");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("AppListener is initializing");
	}
}

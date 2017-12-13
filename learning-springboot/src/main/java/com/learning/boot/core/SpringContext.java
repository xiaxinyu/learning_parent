package com.learning.boot.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy(false)
public class SpringContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContext.applicationContext = applicationContext;
	}

	public static ApplicationContext getContext() {
		return applicationContext;
	}
}

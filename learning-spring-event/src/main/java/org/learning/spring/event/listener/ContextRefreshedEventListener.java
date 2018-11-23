package org.learning.spring.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
	private Logger logger = LoggerFactory.getLogger(ContextRefreshedEventListener.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info("trigger ContextRefreshedEvent");
	}
}

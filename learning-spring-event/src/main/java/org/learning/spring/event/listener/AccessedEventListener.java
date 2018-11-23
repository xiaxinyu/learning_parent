package org.learning.spring.event.listener;

import org.learning.spring.event.AccessedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AccessedEventListener implements ApplicationListener<AccessedEvent> {
	private Logger logger = LoggerFactory.getLogger(ContextRefreshedEventListener.class);

	@Override
	public void onApplicationEvent(AccessedEvent event) {
		logger.info("trigger ConfigurationEvent,{}", event.getSource());
	}
}
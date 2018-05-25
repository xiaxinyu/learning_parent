package org.learning.spring.ioc.publisher;

import org.learning.spring.ioc.event.AppEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppPublisher {

	@Autowired
	ApplicationContext context;
	
	public void published() {
		AppEvent event = new AppEvent(this, "I am summer");
		context.publishEvent(event);
	}
}

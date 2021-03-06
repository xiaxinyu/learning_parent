package com.learning.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class YellowLevelEventPublisher {
	@Autowired
	private ApplicationContext applicationContext;

	public void pushlish(String msg, String mail) {
		applicationContext.publishEvent(new YellowLevelEvent(this, msg, mail));
	}
}

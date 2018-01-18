package com.learning.spring.event;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventTest {
	private AnnotationConfigApplicationContext context;

	@Before
	public void setup() {
		context = new AnnotationConfigApplicationContext(EventConfig.class);
	}

	@Test
	public void testEvent() {
		YellowLevelEventPublisher publisher = context.getBean(YellowLevelEventPublisher.class);
		publisher.pushlish("summer", "5.0");
		publisher.pushlish("spring", "5.1");
		publisher.pushlish("winner", "5.2");
		publisher.pushlish("autumn", "5.3");
		context.close();
	}
}

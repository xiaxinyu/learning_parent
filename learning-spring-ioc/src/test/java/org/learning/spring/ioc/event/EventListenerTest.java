package org.learning.spring.ioc.event;

import org.learning.spring.ioc.event.listener.AppPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "org.learning.spring.ioc" })
public class EventListenerTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventListenerTest.class);
		AppPublisher publisher = context.getBean(AppPublisher.class);
		publisher.published();
		context.close();
	}
}

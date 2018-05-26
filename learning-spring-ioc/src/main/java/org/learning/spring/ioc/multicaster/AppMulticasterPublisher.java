package org.learning.spring.ioc.multicaster;

import org.learning.spring.ioc.event.listener.AppEvent;
import org.learning.spring.ioc.event.listener.AppListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

public class AppMulticasterPublisher {
	public void publishEvent() {
		SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
		multicaster.addApplicationListener(new AppListener());
		multicaster.addApplicationListener(new AppListener());
		
		multicaster.multicastEvent(new AppEvent(this, "I am winner"));
	}
}

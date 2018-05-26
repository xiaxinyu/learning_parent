package org.learning.spring.ioc.event.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppListener implements ApplicationListener<AppEvent> {
	public void onApplicationEvent(AppEvent event) {
		String msg = event.getMessage();
		System.out.println("AppListener接受到了AppPublisher发布的消息：" + msg);
	}
}

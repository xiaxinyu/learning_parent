package com.learning.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class YellowLevelEventListener implements ApplicationListener<YellowLevelEvent> {

	@Async
	@Override
	public void onApplicationEvent(YellowLevelEvent event) {
		System.out.println("Yellow level event is triggered, " + event.toString());
	}

}

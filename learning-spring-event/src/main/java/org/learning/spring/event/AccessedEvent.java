package org.learning.spring.event;

import org.springframework.context.ApplicationEvent;

public class AccessedEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;
	
	public AccessedEvent(Object source) {
		super(source);
	}
}
package org.learning.spring.ioc.event.listener;

import org.springframework.context.ApplicationEvent;

public class AppEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;

	private String message;

	public AppEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	public void printAppLog() {
		System.out.println(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

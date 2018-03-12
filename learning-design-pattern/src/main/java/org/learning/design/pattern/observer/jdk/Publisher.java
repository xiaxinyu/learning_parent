package org.learning.design.pattern.observer.jdk;

import java.util.Observable;

public class Publisher extends Observable {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		this.setChanged();
		//主动通知，这里用的是推的方式
		//this.notifyObservers(message);
		//拉的方式
	    this.notifyObservers();
	}
}

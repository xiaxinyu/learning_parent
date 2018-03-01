package org.learning.design.pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class Reader implements Observer {
	private String name;

	public Reader(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void update(Observable o, Object arg) {
		System.out.println(name + " gets " + arg);
	}

}

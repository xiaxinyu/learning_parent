package org.learning.design.pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class Subcriber implements Observer {
	private String name;

	public Subcriber(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void update(Observable o, Object message) {
		//推的方式
		System.out.println(name + " gets " + message);
		//拉的方式
		//System.out.println(name + " gets " + ((Publisher)o).getMessage());
	}

}

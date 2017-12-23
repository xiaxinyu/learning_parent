package org.learning.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
	protected List<Observer> observers = new ArrayList<Observer>();

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObjserver(Observer observer) {
		observers.remove(observer);
	}
}

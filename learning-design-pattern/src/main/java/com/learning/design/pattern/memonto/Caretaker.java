package com.learning.design.pattern.memonto;

import java.util.HashMap;
import java.util.Map;

public class Caretaker {
	private Map<Status, Memento> tos = new HashMap<Status, Memento>();

	public Memento getMemento(Status status) {
		return tos.get(status);
	}

	public void saveMemento(Memento to) {
		this.tos.put(to.getStatus(), to);
	}
}

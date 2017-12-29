package com.learning.design.pattern.memonto;

public class Originator {
	private Status status;

	public Memento createMemento() {
		return new Memento(this.status);
	}

	public void restoreMemento(Memento to) {
		this.status = to.getStatus();
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}

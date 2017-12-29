package org.learning.design.pattern.memonto;

public class Memento {
	private Status status;

	public Memento(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}

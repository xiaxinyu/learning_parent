package org.learning.jvolatile.thread.stop;

public class Worker extends Thread {
	private Action action;

	public Worker(Action action) {
		super.setName("Worker");
		this.action = action;
	}

	@Override
	public void run() {
		while (!action.isStop()) {
			action.doSomething();
		}
	}
}

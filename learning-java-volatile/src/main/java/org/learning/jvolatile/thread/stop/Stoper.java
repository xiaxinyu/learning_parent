package org.learning.jvolatile.thread.stop;

public class Stoper extends Thread {
	private Action action;

	public Stoper(Action action) {
		super.setName("Stoper");
		this.action = action;
	}

	@Override
	public void run() {
		action.stop();
		System.out.println(this.getName() + ":stop action");
	}
}

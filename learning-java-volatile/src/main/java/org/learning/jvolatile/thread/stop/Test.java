package org.learning.jvolatile.thread.stop;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		Action action = new Action();
		new Worker(action).start();
		Thread.sleep(5000);
		new Stoper(action).start();
	}
}

package org.learning.thread.tradition.interrupte;

public class Test {
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.run();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}
}

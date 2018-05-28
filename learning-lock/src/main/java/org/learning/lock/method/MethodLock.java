package org.learning.lock.method;

public class MethodLock {
	public synchronized void printCounter(String name) {
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " : Current counter is " + i);
		}
	}
}

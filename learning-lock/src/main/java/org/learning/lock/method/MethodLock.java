package org.learning.lock.method;

public class MethodLock {
	public synchronized void printCounter1(String name) {
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " : Current counter[1] is " + i);
		}
	}

	public synchronized void printCounter2(String name) {
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " : Current counter[2] is " + i);
		}
	}

	public void printCounter3(String name) {
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " : Current counter[3] is " + i);
		}
	}
}
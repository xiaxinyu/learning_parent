package org.learning.lock.reentrant;

public class NoLockThread implements Runnable {
	volatile int num = 1000000;

	@Override
	public void run() {
		if (Thread.currentThread().getName().equals("t1")) {
			increment();
		} else {
			decrement();
		}
	}

	public void increment() {
		for (int i = 0; i < 10000; i++) {
			num++;
		}
	}

	public void decrement() {
		for (int i = 0; i < 10000; i++) {
			num--;
		}
	}
}
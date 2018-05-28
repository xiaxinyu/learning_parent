package org.learning.lock.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WithLockThread implements Runnable{
	int num = 1000000;
	Lock lock = new ReentrantLock();

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
			try {
				lock.lock();
				num++;
			} finally {
				lock.unlock();
			}
		}
	}

	public void decrement() {
		for (int i = 0; i < 10000; i++) {
			try {
				lock.lock();
				num--;
			} finally {
				lock.unlock();
			}
		}
	}
}

package org.learning.lock.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicThread implements Runnable {
	AtomicInteger counter = new AtomicInteger(10000);
	@Override
	public void run() {
		if (Thread.currentThread().getName().equals("t1")) {
			increase();
		} else {
			decrease();
		}
	}
	
	public void increase() {
		for(int i=0;i<10000;i++) {
			counter.incrementAndGet();
			System.out.println("increase: " + counter.get());
		}
	}

	public void decrease() {
		for(int i=0;i<10000;i++) {
			counter.decrementAndGet();
			System.out.println("decrease: " + counter.get());
		}
	}
}

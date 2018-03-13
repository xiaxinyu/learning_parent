package org.learning.thread.concurrent.lock.condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		BoundedBuffer buffer = new BoundedBuffer();
		ExecutorService pool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 5; i++) {
			pool.execute(new Producer(buffer));
			pool.execute(new Consumer(buffer));
		}
	}
}

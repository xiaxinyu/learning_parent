package org.learning.concurrent.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		BlockingQueue<Product> queue = new ArrayBlockingQueue<Product>(10);

		ExecutorService producers = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			producers.execute(new Producer(queue));
		}

		ExecutorService consumers = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 5; i++) {
			consumers.execute(new Consumer(queue));
		}
	}
}
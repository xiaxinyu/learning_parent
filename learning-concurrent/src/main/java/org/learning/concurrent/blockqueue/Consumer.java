package org.learning.concurrent.blockqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private final BlockingQueue<Product> queue;

	public Consumer(BlockingQueue<Product> queue) {
		this.queue = queue;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(5000);
				Product iceCream = queue.take();
				System.out.println("Consumer takes " + iceCream);
			} catch (InterruptedException e) {
			}
		}
	}
}

package org.learning.thread.concurrent.blockqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private final BlockingQueue<IceCream> queue;

	public Consumer(BlockingQueue<IceCream> queue) {
		this.queue = queue;
	}

	public void run() {
		while (true) {
			try {
				IceCream iceCream = queue.take();
				System.out.println("Consumer " + iceCream);
			} catch (InterruptedException e) {
			}
		}
	}
}

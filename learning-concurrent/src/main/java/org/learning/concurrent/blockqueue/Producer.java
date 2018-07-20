package org.learning.concurrent.blockqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private final BlockingQueue<Product> queue;

	public Producer(BlockingQueue<Product> queue) {
		this.queue = queue;
	}

	public void produce(Product iceCream) throws InterruptedException {
		queue.put(iceCream);
		System.out.println("Producer makes " + iceCream + ", the number of ice cream is " + queue.size());
	}

	public Product getIceCream() {
		Product[] favors = new Product[] { Product.CHOCOLATE, Product.APPLE, Product.APPLE, Product.PEACH };
		int favor = Math.abs(new Random().nextInt(4));
		return favors[favor];
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
				produce(getIceCream());
			} catch (InterruptedException e) {
			}
		}
	}
}

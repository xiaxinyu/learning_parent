package org.learning.thread.concurrent.blockqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private final BlockingQueue<IceCream> queue;

	public Producer(BlockingQueue<IceCream> queue) {
		this.queue = queue;
	}

	public void produce(IceCream iceCream) throws InterruptedException {
		queue.put(iceCream);
		System.out.println(
				"Success:" + Thread.currentThread().getName() + " product " + iceCream + ",size=" + queue.size());

	}

	public IceCream getIceCream() {
		IceCream[] favors = new IceCream[] { IceCream.CHOCOLATE, IceCream.APPLE, IceCream.APPLE, IceCream.PEACH };
		int favor = Math.abs(new Random().nextInt(4));
		return favors[favor];
	}

	public void run() {
		while (true) {
			try {
				produce(getIceCream());
			} catch (InterruptedException e) {
			}
		}
	}
}

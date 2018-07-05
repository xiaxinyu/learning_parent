package org.learning.thread.tradition.notifyAll;

import java.util.Queue;

import org.learning.thread.tradition.wait.Phone;

public class ConsumerThread extends Thread {
	private Queue<Phone> pool;

	public ConsumerThread(Queue<Phone> pool, Integer threadSN) {
		this.pool = pool;
		super.setName("Consumer" + threadSN);
	}

	@Override
	public void run() {
		while (true) {
			synchronized (pool) {
				if (pool.size() <= 0) {
					try {
						pool.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				System.out.println(Thread.currentThread().getName() + " buy " + pool.poll());

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

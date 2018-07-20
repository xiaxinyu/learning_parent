package org.learning.thread.wait;

import java.util.Queue;

public class ConsumerThread extends Thread {
	private Queue<Phone> pool;
	private Condition condition;

	public ConsumerThread(Queue<Phone> pool, Integer threadSN, Condition condition) {
		this.pool = pool;
		this.condition = condition;
		super.setName("Consumer" + threadSN);
	}

	@Override
	public void run() {
		while (true) {
			synchronized (condition) {
				int size = pool.size();
				if (size <= 0) {
					System.out.println();
					condition.unLock();
					condition.lock();
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

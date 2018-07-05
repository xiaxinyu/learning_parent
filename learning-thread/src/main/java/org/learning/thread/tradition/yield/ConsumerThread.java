package org.learning.thread.tradition.yield;

import java.util.Queue;

import org.learning.thread.tradition.wait.Phone;

public class ConsumerThread extends Thread {
	private Queue<Phone> pool;
	private Integer threadSN;

	public ConsumerThread(Queue<Phone> pool, Integer threadSN) {
		this.pool = pool;
		this.threadSN = threadSN;
		super.setName("Consumer" + threadSN);
	}

	@Override
	public void run() {
		while (true) {
			synchronized (pool) {
				if (pool.size() <= 0) {
					// Needn't wait if it's the first thread
					if (this.threadSN == 1) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						continue;
					} else {
						try {
							pool.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				System.out.println(Thread.currentThread().getName() + " buy " + pool.poll());
				if (this.threadSN == 1 && pool.size() == 100) {
					System.out.println("Pool size is 100.");
					yield();
					/*try {
						pool.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
				}

				if (this.threadSN != 1) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					if (pool.size() <= 100) {
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}

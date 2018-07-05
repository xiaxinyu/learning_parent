package org.learning.thread.tradition.yield;

import java.util.Queue;

import org.learning.thread.tradition.wait.Phone;

public class ProducerThread extends Thread {
	private Queue<Phone> pool;
	private int number = 200;

	public ProducerThread(Queue<Phone> pool, Integer threadSN) {
		this.pool = pool;
		super.setName("Producer" + threadSN);
	}

	@Override
	public void run() {
		synchronized (pool) {
			System.out.println(Thread.currentThread().getName() + " is producing 50 iPhoneX.");

			for (int i = 0; i < number; i++) {
				Phone phone = new Phone("iPhoneX", String.valueOf(System.currentTimeMillis()));
				System.out.println(phone);
				pool.add(phone);

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println(Thread.currentThread().getName() + " finish this task.");
			System.out.println();

			// Execute other commands after 1s
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			try {
				pool.notifyAll();
				pool.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

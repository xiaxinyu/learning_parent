package org.learning.thread.tradition.wait;

import java.util.Queue;

public class ProducerThread extends Thread {
	private Queue<Phone> pool;
	private Condition condition;
	private int number = 50;

	public ProducerThread(Queue<Phone> pool, Integer threadSN, Condition condition) {
		this.pool = pool;
		this.condition = condition;
		super.setName("Producer" + threadSN);
	}

	@Override
	public void run() {
		while (true) {
			synchronized (condition) {
				System.out.println(Thread.currentThread().getName() + " is producing 50 iPhoneX.");

				int size = pool.size();
				if (size >= number) {
					condition.unLock();
					condition.lock();
				}
				
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
				
				//Execute other commands after 1s
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				condition.unLock();
				condition.lock();
			}
		}
	}
}

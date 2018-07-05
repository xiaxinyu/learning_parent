package org.learning.thread.tradition.notifyAll;

import java.util.LinkedList;
import java.util.Queue;

import org.learning.thread.tradition.wait.Phone;

public class NotifyAllTest {
	public static void main(String[] args) throws InterruptedException {
		Queue<Phone> pool = new LinkedList<Phone>();

		//Consume phone after getting notification
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
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
							System.out.println(Thread.currentThread().getName() + " : " + pool.poll());
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}).start();
		}

		//Notice all after finishing self task.
		new Thread() {
			@Override
			public void run() {
				synchronized (pool) {
					System.out.println(Thread.currentThread().getName() + " is producing 50 iPhoneX.");
					for (int i = 0; i < 50; i++) {
						Phone phone = new Phone("iPhoneX", String.valueOf(System.currentTimeMillis()));
						System.out.println(phone);
						pool.add(phone);

						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName() + " finish this task. size=" + pool.size());
					System.out.println();

					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					pool.notifyAll();
					try {
						pool.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
	}
}
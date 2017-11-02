package org.learning.thread.concurrent.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SecureCounter {
	private static Counter counter = new Counter();

	public static void main(String[] args) {
		int poolSize = 5;
		ExecutorService pool = Executors.newFixedThreadPool(poolSize);
		for (int i = 0; i < poolSize; i++) {
			pool.execute(new Runnable() {
				public void run() {
					while (true) {
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
						}

						int t = counter.getCounter();
						if (t > 10000) {
							System.out.println(Thread.currentThread().getName() + " stopped!");
							break;
						}

						System.out.println(t + ": " + Thread.currentThread().getName());
					}
				}
			});
		}
	}

}

class Counter {
	private int i = 0;
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private int copy = 0;

	public int getCounter() {
		lock.readLock().lock();
		copy = i;
		lock.readLock().unlock();
		lock.writeLock().lock();
		i++;
		lock.writeLock().unlock();
		return copy;
	}
}
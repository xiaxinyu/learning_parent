package org.learning.concurrent.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SecureCounter {
	private static int MAX_VALUE = 1000;
	private static Counter counter = new Counter(MAX_VALUE);

	public static void main(String[] args) {
		int poolSize = 5;
		ExecutorService pool = Executors.newFixedThreadPool(poolSize);
		for (int i = 0; i < poolSize; i++) {
			pool.execute(new Runnable() {
				public void run() {
					while (true) {
						int t = counter.getCounter();
						System.out.println(t + ": " + Thread.currentThread().getName());
						if (t >= MAX_VALUE) {
							List<Integer> result = counter.getResult();
							if (result != null && result.size() > 0) {
								System.out.println("Counter size: " + result.size());
							} else {
								System.out.println("Error occure!");
							}
							System.out.println(Thread.currentThread().getName() + " stopped!");
							break;
						}
					}
				}
			});
		}
		pool.shutdown();
	}
}

class Counter {
	private int i = 0;
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private int copy = 0;
	private List<Integer> list = new ArrayList<Integer>();
	private int max;

	public Counter(int max) {
		this.max = max;
	}

	public int getCounter() {
		lock.readLock().lock();
		try {
			copy = i;
			lock.readLock().unlock();
			lock.writeLock().lock();
			try {
				// Recheck state because another thread might have
				// current value is greater than max, do nothing
				if (copy == i && copy < max) {
					i++;
					list.add(i);
				}
			} finally {
				lock.writeLock().unlock();
			}
			lock.readLock().lock();
		} finally {
			lock.readLock().unlock();
		}
		return copy;
	}

	public synchronized List<Integer> getResult() {
		return list;
	}
}
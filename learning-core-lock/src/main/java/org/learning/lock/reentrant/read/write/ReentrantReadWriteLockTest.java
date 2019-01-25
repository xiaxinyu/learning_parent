package org.learning.lock.reentrant.read.write;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock readLock = lock.readLock();
	private final Lock writeLock = lock.writeLock();

	public void get() {
		readLock.lock();
		try {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " start reading.");
			Thread.sleep(1000);
			System.out.println(threadName + " finish reading.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readLock.unlock();
		}
	}

	public void put() {
		writeLock.lock();
		try {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " start writing.");
			Thread.sleep(1000);
			System.out.println(threadName + " finish writing.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			writeLock.unlock();
		}
	}
	
	public static void main(String[] args) {
		ReentrantReadWriteLockTest test = new ReentrantReadWriteLockTest();
		int number = 5;
		
		/*for (int i = 1; i <= number; i++) {
			new Thread("Reader" + i) {
				@Override
				public void run() {
					test.get();
				}
			}.start();
		}*/
		
		for (int i = 1; i <= number; i++) {
			new Thread("Writer" + i) {
				@Override
				public void run() {
					test.put();
				}
			}.start();
		}
	}
}

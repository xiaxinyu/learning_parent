package org.learning.thread.concurrent.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
	private final Lock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();
	private final int DEFAULT_CAPACITY = 100;
	private int capacity = DEFAULT_CAPACITY;
	private Object[] items = null;
	private int putptr, takeptr, count;

	public BoundedBuffer() {
		items = new Object[capacity];
	}

	public BoundedBuffer(int capacity) {
		this.capacity = capacity;
		items = new Object[capacity];
	}

	public void put(Object value) throws InterruptedException {
		lock.lock();
		try {
			while (count == capacity) {
				System.out.println("full !!!!!!!!!!!full!!!!!!!!!!!full!!");
				notFull.await();
			}
			items[putptr] = value;
			if (++putptr == capacity)
				putptr = 0; 
			++count;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public Object take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0) {
				System.out.println("hungry !!!!!!!!!hungry!!!!!!hungry!!!!!");
				notEmpty.await();
			}
			Object value = items[takeptr];
			if (++takeptr == capacity)
				takeptr = 0;
			--count;
			notFull.signal();
			return value;
		} finally {
			lock.unlock();
		}
	}
}

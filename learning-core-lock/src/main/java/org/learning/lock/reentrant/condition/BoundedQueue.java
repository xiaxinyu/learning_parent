package org.learning.lock.reentrant.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueue<T> {
	private int addIndex, removeIndex, count;

	private Lock lock = new ReentrantLock();
	private Condition notEmpty = lock.newCondition();
	private Condition empty = lock.newCondition();
	private String[] queue;

	public BoundedQueue(int size) {
		queue = new String[size];
	}

	public void put() {
		try {
			
		}finally {
			
		}
	}

	public void pop() {

	}
}

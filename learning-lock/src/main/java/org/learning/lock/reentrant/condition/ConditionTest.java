package org.learning.lock.reentrant.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void conditionWait() {
		lock.lock();
		try {
			System.out.println("conditionWait start");
			condition.await();
			System.out.println("conditionWait finish");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void conditionSignal() {
		lock.lock();
		try {
			System.out.println("conditionSignal start");
			for (int i = 0; i < 100; i++) {
				Thread.sleep(50);
				System.out.println("conditionSignal is preparing notify.");
			}
			condition.signal();
			System.out.println("conditionSignal finish");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		ConditionTest test = new ConditionTest();
		new Thread() {
			public void run() {
				test.conditionWait();
			};
		}.start();

		new Thread() {
			public void run() {
				test.conditionSignal();
			};
		}.start();
	}
}

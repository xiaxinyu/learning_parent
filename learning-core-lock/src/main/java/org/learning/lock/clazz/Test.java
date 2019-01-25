package org.learning.lock.clazz;

public class Test {
	public void print1() {
		ClazzLock lock = new ClazzLock();
		new Thread() {
			@Override
			public void run() {
				lock.printCounter("summer");
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				lock.printCounter("winter");
			}
		}.start();
	}

	public void print2() {
		ClazzLock lock1 = new ClazzLock();
		new Thread() {
			@Override
			public void run() {
				lock1.printCounter("autumn");
			}
		}.start();

		ClazzLock lock2 = new ClazzLock();
		new Thread() {
			@Override
			public void run() {
				lock2.printCounter("spring");
			}
		}.start();
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.print1();
		test.print2();
	}
}

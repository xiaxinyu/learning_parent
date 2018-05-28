package org.learning.lock.method;

public class Test {
	public void print1() {
		MethodLock lock = new MethodLock();
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
		MethodLock lock1 = new MethodLock();
		new Thread() {
			@Override
			public void run() {
				lock1.printCounter("autumn");
			}
		}.start();

		MethodLock lock2 = new MethodLock();
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

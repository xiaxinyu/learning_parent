package org.learning.lock.method;

public class Test {
	public void sameObjectAndMethod() {
		MethodLock lock = new MethodLock();
		new Thread() {
			@Override
			public void run() {
				lock.printCounter1("summer");
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				lock.printCounter1("winter");
			}
		}.start();
	}

	public void diffObjectAndSameMethod() {
		MethodLock lock1 = new MethodLock();
		new Thread() {
			@Override
			public void run() {
				lock1.printCounter1("autumn");
			}
		}.start();

		MethodLock lock2 = new MethodLock();
		new Thread() {
			@Override
			public void run() {
				lock2.printCounter1("spring");
			}
		}.start();
	}
	
	public void sameObjectAndDiffMethod() {
		MethodLock lock = new MethodLock();
		new Thread() {
			@Override
			public void run() {
				lock.printCounter1("summer");
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				lock.printCounter2("winter");
			}
		}.start();
	}
	
	public void sameObjectAndDiffMethodWithNoneSync() {
		MethodLock lock = new MethodLock();
		new Thread() {
			@Override
			public void run() {
				lock.printCounter1("summer");
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				lock.printCounter3("winter");
			}
		}.start();
	}

	public static void main(String[] args) {
		Test test = new Test();
		//test.sameObjectAndMethod();
		//test.diffObjectAndSameMethod();
		//test.sameObjectAndDiffMethod();
		test.sameObjectAndDiffMethodWithNoneSync();
	}
}

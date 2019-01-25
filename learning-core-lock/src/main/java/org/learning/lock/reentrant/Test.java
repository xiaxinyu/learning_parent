package org.learning.lock.reentrant;

public class Test {
	public void invokeNoLock() {
		NoLockThread thread = new NoLockThread();
		Thread a = new Thread(thread, "t1");
		Thread b = new Thread(thread, "t2");

		a.start();
		b.start();

		try {
			a.join();
			b.join();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(thread.num);
	}

	public void invokeWithLock() {
		WithLockThread thread = new WithLockThread();
		Thread a = new Thread(thread, "t1");
		Thread b = new Thread(thread, "t2");

		a.start();
		b.start();

		try {
			a.join();
			b.join();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(thread.num);
	}

	public static void main(String[] args) {
		Test test = new Test();
		// test.invokeNoLock();
		test.invokeWithLock();
	}
}

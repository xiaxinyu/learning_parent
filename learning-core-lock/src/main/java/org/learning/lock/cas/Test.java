package org.learning.lock.cas;

public class Test {
	public static void main(String[] args) {
		AtomicThread thread = new AtomicThread();
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

		System.out.println(thread.counter.get());
	}
}

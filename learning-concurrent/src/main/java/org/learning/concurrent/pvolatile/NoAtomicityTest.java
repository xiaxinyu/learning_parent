package org.learning.concurrent.pvolatile;

/**
 * volatile关键字保证了操作的可见性，但是volatile不能保证对变量的操作是原子性
 * 
 * @author summer.xia
 *
 */
public class NoAtomicityTest {
	public volatile int inc = 0;

	public void increase() {
		inc++;
	}

	public static void main(String[] args) {
		final NoAtomicityTest test = new NoAtomicityTest();
		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					for (int j = 0; j < 1000; j++)
						test.increase();
				};
			}.start();
		}

		while (Thread.activeCount() > 1) // 保证前面的线程都执行完
			Thread.yield();
		System.out.println(test.inc);
	}
}
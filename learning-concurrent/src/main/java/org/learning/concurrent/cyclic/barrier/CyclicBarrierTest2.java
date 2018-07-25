package org.learning.concurrent.cyclic.barrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 {
	static CyclicBarrier c = new CyclicBarrier(2, new A());

	public static void main(String[] args) {
		//thread 1
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(1);
				try {
					c.await();
				} catch (Exception e) {
				}
			}
		}).start();

		//thread main
		System.out.println(2);
		try {
			c.await();
		} catch (Exception e) {
		}
	}

	//thread final
	static class A implements Runnable {
		@Override
		public void run() {
			System.out.println(3);
		}
	}
}

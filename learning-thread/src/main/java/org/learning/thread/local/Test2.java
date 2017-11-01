package org.learning.thread.local;

import java.util.Random;

public class Test2 {
	private static ThreadLocal<String> map = new ThreadLocal<String>();
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread() {
				public void run() {
					String port = String.valueOf(new Random().nextInt(10000));
					String host = "Sever" + port;

					map.set(host);

					new A().get();
					new B().get();
				}
			}.start();
		}
	}

	static class A {
		public void get() {
			Thread current = Thread.currentThread();
			System.out.println("A->Local->" + current.getName() + "->" + map.get());
		}
	}

	static class B {
		public void get() {
			Thread current = Thread.currentThread();
			System.out.println("B->Local->" + current.getName() + "->" + map.get());
		}
	}
}

package org.learning.concurrent.threadlocal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapThreadLocalTest {
	private static final Map<Thread, Integer> map = new HashMap<Thread, Integer>();

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			final int data = new Random().nextInt(10000);
			new Thread() {
				public void run() {
					map.put(Thread.currentThread(), data);
					new A().get();
					new B().get();
				}
			}.start();
		}
	}

	static class A {
		public void get() {
			Thread current = Thread.currentThread();
			System.out.println("A->Local->" + current.getName() + "->Data:" + map.get(current));
		}
	}

	static class B {
		public void get() {
			Thread current = Thread.currentThread();
			System.out.println("B->Local->" + current.getName() + "->Data:" + map.get(current));
		}
	}
}

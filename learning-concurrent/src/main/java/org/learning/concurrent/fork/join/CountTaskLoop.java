package org.learning.concurrent.fork.join;

public class CountTaskLoop {
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		int sum = 0;
		for (int i = 1; i <= 10000; i++) {
			sum += i;
		}
		System.out.println(sum);
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}

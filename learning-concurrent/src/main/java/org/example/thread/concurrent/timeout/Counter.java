package org.example.thread.concurrent.timeout;

import java.util.Random;

public class Counter {

	public static long calc(long limit) {
		long result = 0L;
		int counter = 0;
		while (counter < limit) {
			result += counter;
			counter++;
		}
		return result;
	}

	public static long getLimit() {
		int limit = new Random().nextInt(10);
		return 1000000000L + limit * 100000000L;
	}

	public static void main(String[] args) {
		Long start = System.currentTimeMillis();
		long limit = getLimit();
		System.out.println("limit:" + limit);
		System.out.println(Counter.calc(limit));
		Long end = System.currentTimeMillis();
		System.out.println("cost:" + (end - start));
	}
}

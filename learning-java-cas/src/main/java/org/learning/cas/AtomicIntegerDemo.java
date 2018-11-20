package org.learning.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
	public static void main(String[] args) {
		AtomicInteger ai = new AtomicInteger(0);
		boolean flag = ai.compareAndSet(0, 1);
		if(flag) {
			System.out.println("update successfully.");
		}
		System.out.println(ai.get());
		flag = ai.compareAndSet(1, 2);
		if(flag) {
			System.out.println("update successfully.");
		}
		System.out.println(ai.get());
		System.out.println(ai.incrementAndGet());
	}
}

package org.learning.thread.runtime;

public class RuntimeTest {
	public static void main(String[] args) {
		System.out.println("I am working.");
		long total = 0;
		for (long i = 0; i < 9000000000L; i++) {
			total += i;
		}
		System.out.println("Final result is " + total);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("Close resource!!!");
			}
		});
	}
}

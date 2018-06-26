package org.learning.concurrent.random.number;

public class Test {
	public static void main(String[] args) {
		new TestWorker("RN[1]").start();
		new TestWorker("RN[2]").start();
	}
}

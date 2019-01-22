package org.learning.jvm;

public class StackOverflowError {
	private static int index = 1;

	public void doSomething() {
		index++;
		doSomething();
	}

	public static void main(String[] args) {
		StackOverflowError mock = new StackOverflowError();
		try {
			mock.doSomething();
		} catch (Throwable e) {
			System.out.println("Stack deep : " + index);
			e.printStackTrace();
		}
	}
}
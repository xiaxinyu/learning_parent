package org.learning.thread.base;

import java.lang.Thread.UncaughtExceptionHandler;

public class UncaughtExceptionHandlerDemo {
	public static void main(String[] args) {
		Thread t = new Thread(new Task());
		t.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				e.printStackTrace();
			}
		});
		t.start();
	}

	private static class Task implements Runnable {
		@Override
		public void run() {
			System.out.println("running task");
			int i = 1 / 0;
		}
	}
}

package org.learning.thread.concurrent.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		Executor e = new SerialExecutor(Executors.newFixedThreadPool(3));
		for (int i = 0; i < 5; i++) {
			e.execute(new Runnable() {
				public void run() {
					System.out.println("I am working.");
				}
			});
		}
		
		Executor e1 = new DirectExecutor();
		e1.execute(new Runnable() {
			public void run() {
				System.out.println("I am working in directly.");
			}
		});
	}
}

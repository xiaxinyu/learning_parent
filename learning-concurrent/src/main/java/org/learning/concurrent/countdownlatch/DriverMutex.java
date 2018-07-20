package org.learning.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DriverMutex {
	public static void doSomething1() {
		System.out.println("Start execution.");
	}
	
	public static void doSomething2() {
		System.out.println("Eliminate lock.");
	}


	public static void main(String[] args) throws InterruptedException {
		int N = 5;
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(N);
		ExecutorService e = Executors.newFixedThreadPool(3);

		for (int i = 0; i < N; i++) {
			e.execute(new Worker(startSignal, doneSignal, i));
		}

		doSomething1();
		//remove it, it will cause thread deadlock
		startSignal.countDown();
		doSomething2();
		doneSignal.await();
		System.out.println("All workers finishes task.");
		e.shutdownNow();
	}
}

class Worker implements Runnable {
	private final CountDownLatch startSignal;
	private final CountDownLatch doneSignal;
	private final int i;

	public Worker(CountDownLatch startSignal, CountDownLatch doneSignal, int i) {
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
		this.i = i;
	}

	public void run() {
		try {
			startSignal.await();
			doWork();
			doneSignal.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void doWork() {
		System.out.println("Worker" + i + " is working.");
	}
}

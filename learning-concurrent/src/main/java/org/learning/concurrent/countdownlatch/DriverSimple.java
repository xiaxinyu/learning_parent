package org.learning.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DriverSimple {
	public static void main(String[] args) throws InterruptedException {
		int N = 5;
		CountDownLatch doneSignal = new CountDownLatch(N);
		ExecutorService e = Executors.newFixedThreadPool(3);

		for (int i = 0; i < N; i++) {
			e.execute(new WorkerRunnable(doneSignal, i));
		}

		doneSignal.await();
		System.out.println("All workers finishes task.");
		e.shutdownNow();
	}
}

class WorkerRunnable implements Runnable {
	private final CountDownLatch doneSignal;
	private final int i;

	public WorkerRunnable(CountDownLatch doneSignal, int i) {
		this.doneSignal = doneSignal;
		this.i = i;
	}

	public void run() {
		doWork();
		if (i == 4) {
			try {
				System.out.println("Worker" + i + " will work overtime.");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		finishWork();
		doneSignal.countDown();
	}

	void doWork() {
		System.out.println("Worker" + i + " is working.");
	}

	void finishWork() {
		System.out.println("Worker" + i + " finishes work.");
	}

}

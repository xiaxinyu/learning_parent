package org.learning.thread.tradition.interrupte;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Terminator implements Runnable {
	private Worker worker;

	public Terminator(Worker worker) {
		this.worker = worker;
	}

	@Override
	public void run() {
		worker.interrupt();
	}
}

class Worker extends Thread {
	@Override
	public void run() {
		System.out.println("I's gonna work.");
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("I finished working.");
	}
}

public class TimeoutInterrupt {
	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.start();

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(new Terminator(worker), 5, 5, TimeUnit.SECONDS);
	}
}

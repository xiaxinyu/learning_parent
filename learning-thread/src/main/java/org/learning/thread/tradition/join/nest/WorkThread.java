package org.learning.thread.tradition.join.nest;

public class WorkThread extends Thread {
	private int counter;

	public WorkThread(int counter) {
		this.counter = counter;
		super.setName("ThreadName" + counter);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running");
		if (counter > 0) {
			counter--;
			WorkThread thread = new WorkThread(counter);
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

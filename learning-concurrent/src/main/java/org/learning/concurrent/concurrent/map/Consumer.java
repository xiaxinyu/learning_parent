package org.learning.concurrent.concurrent.map;

public class Consumer implements Runnable {
	private String sequenceName;

	public Consumer(String sequenceName) {
		this.sequenceName = sequenceName;
	}

	@Override
	public void run() {
		Long sequence = ConcurrentMapSequence.getSequence(this.sequenceName);
		System.out.println(Thread.currentThread().getName() + " : " + this.sequenceName + " sequence is " + sequence);
	}
}

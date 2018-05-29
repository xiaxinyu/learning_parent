package org.learning.concurrent.sequence.concurrent.map;

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

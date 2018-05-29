package org.learning.concurrent.sequence.thread.local;

public class Consumer implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			Long sequence = ThreadLocalSequence.getSequence();
			System.out.println(Thread.currentThread().getName() + " : current sequence is " + sequence);
		}
	}
}

package org.learning.concurrent.sequence.syn.lock;

public class Consumer implements Runnable {
	@Override
	public void run() {
			Long sequence = SynLockSequence.getSequence();
			System.out.println(Thread.currentThread().getName() + " : current sequence is " + sequence);
	 }
}

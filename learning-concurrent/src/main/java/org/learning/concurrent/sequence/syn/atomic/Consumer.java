package org.learning.concurrent.sequence.syn.atomic;

public class Consumer implements Runnable {
	@Override
	public void run() {
			Long sequence = SynAtomicSequence.getSequence();
			System.out.println(Thread.currentThread().getName() + " : current sequence is " + sequence);
	 }
}

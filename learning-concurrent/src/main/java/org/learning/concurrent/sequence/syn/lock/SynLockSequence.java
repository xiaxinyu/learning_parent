package org.learning.concurrent.sequence.syn.lock;

import java.util.concurrent.locks.ReentrantLock;

public class SynLockSequence {
	private static Long sequence = 0L;
	private static ReentrantLock lock = new ReentrantLock();

	public static Long getSequence() {
		try {
			lock.lock();
			sequence++;
		} finally {
			lock.unlock();
		}
		return sequence;
	}
}

package org.learning.concurrent.sequence.concurrent.map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentMapSequence {
	private static ConcurrentMap<String, Long> pool = new ConcurrentHashMap<String, Long>();
	private static ReentrantLock lock = new ReentrantLock();

	public static Long getSequence(String sequenceName) {
		Long sequence = null;
		try {
			lock.lock();
			sequence = pool.get(sequenceName);
			if (sequence == null) {
				sequence = 1L;
			} else {
				sequence++;
			}
			pool.put(sequenceName, sequence);
		} finally {
			lock.unlock();
		}
		return sequence;
	}
}

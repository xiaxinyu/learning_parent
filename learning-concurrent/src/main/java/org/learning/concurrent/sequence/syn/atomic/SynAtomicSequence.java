package org.learning.concurrent.sequence.syn.atomic;

import java.util.concurrent.atomic.AtomicLong;

public class SynAtomicSequence {
	private static AtomicLong sequence = new AtomicLong(0L);

	public static Long getSequence() {
		sequence.incrementAndGet();
		return sequence.get();
	}
}

package org.learning.concurrent.sequence.thread.local;

public class ThreadLocalSequence {
	private static ThreadLocal<Long> pool = new ThreadLocal<Long>() {
		protected Long initialValue() {
			return 0L;
		};
	};

	public static Long getSequence() {
		Long currentSequence = pool.get();
		currentSequence++;
		pool.set(currentSequence);
		return currentSequence;
	}
}

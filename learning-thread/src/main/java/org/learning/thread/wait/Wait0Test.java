package org.learning.thread.wait;

import java.util.LinkedList;
import java.util.Queue;

public class Wait0Test {
	private Condition condition = new Condition();
	private Queue<Phone> pool = new LinkedList<Phone>();

	public void test() {
		new ProducerThread(pool, 1, condition).start();
		new ConsumerThread(pool, 1, condition).start();
	}

	public static void main(String[] args) {
		new Wait0Test().test();
	}
}

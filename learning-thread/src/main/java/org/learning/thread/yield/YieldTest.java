package org.learning.thread.yield;

import java.util.LinkedList;
import java.util.Queue;

import org.learning.thread.wait.Phone;

public class YieldTest {
	public static void main(String[] args) {
		Queue<Phone> pool = new LinkedList<Phone>();
		// Consume phone after getting notification
		for (int i = 1; i <= 5; i++) {
			new ConsumerThread(pool, i).start();
		}
		// Notice all after finishing self task.
		new ProducerThread(pool, 0).start();
	}
}

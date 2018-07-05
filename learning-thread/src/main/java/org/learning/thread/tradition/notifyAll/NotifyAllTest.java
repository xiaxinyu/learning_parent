package org.learning.thread.tradition.notifyAll;

import java.util.LinkedList;
import java.util.Queue;

import org.learning.thread.tradition.wait.Phone;

public class NotifyAllTest {
	public static void main(String[] args) throws InterruptedException {
		Queue<Phone> pool = new LinkedList<Phone>();
		// Consume phone after getting notification
		for (int i = 1; i <= 5; i++) {
			new ConsumerThread(pool, i).start();
		}
		// Notice all after finishing self task.
		new ProducerThread(pool, 0).start();
	}
}
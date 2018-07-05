package org.learning.thread.tradition.join.nest;

public class JoinTest {
	public long preserveOrderViaJoin() throws InterruptedException {
		int count = 5;
		long startMillis = System.currentTimeMillis();
		// Thread5 is the first thread.
		new WorkThread(count).start();
		return System.currentTimeMillis() - startMillis;
	}

	public static void main(String[] args) throws InterruptedException {
		JoinTest test = new JoinTest();
		System.out.println(test.preserveOrderViaJoin());
	}
}

package org.learning.thread.join;

public class JoinTest {
	public long preserveOrderViaJoin() throws InterruptedException {
		int count = 5;
		long startMillis = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			Thread tmp = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + " is running");
				}
			}, "join-" + i);
			tmp.start();
			tmp.join();// 不停地检测线程是否执行完成，执行完成才继续往下
		}
		return System.currentTimeMillis() - startMillis;
	}

	public static void main(String[] args) throws InterruptedException {
		JoinTest test = new JoinTest();
		System.out.println(test.preserveOrderViaJoin());
	}
}

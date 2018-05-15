package org.learning.thread.tradition.join;

public class JoinTest2 {
	public long preserveOrderViaJoin() throws InterruptedException {
		int count = 5;
		long startMillis = System.currentTimeMillis();
		Thread mainThread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < count; i++) {
					Thread tmp = new Thread(new Runnable() {
						@Override
						public void run() {
							System.out.println(Thread.currentThread().getName() + " is running");
						}
					}, "join-" + i);
					tmp.start();
					try {
						tmp.join(0);// 不停地检测线程是否执行完成，执行完成才继续往下
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
				}
			}
		});
		mainThread.start();
		return System.currentTimeMillis() - startMillis;
	}

	public static void main(String[] args) throws InterruptedException {
		JoinTest2 test = new JoinTest2();
		System.out.println(test.preserveOrderViaJoin());
	}
}
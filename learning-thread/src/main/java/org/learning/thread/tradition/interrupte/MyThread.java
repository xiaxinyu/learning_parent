package org.learning.thread.tradition.interrupte;

public class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		try {
			for (int i = 0; i < 500000; i++) {
				if (interrupted()) {
					System.out.println("should be stopped and exit");
					throw new InterruptedException();
				}
				System.out.println("i=" + (i + 1));
				if (i == 10000) {
					throw new InterruptedException();
				}
			}
			System.out.println("this line cannot be executed. cause thread throws exception");// 这行语句不会被执行!!!
		} catch (InterruptedException e) {
			System.out.println("catch interrupted exception");
		}
	}
}
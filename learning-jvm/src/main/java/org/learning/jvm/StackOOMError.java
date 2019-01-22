package org.learning.jvm;

/**
 * 运行时不断创建新的线程（且每个线程持续执行），每个线程对一个一个栈，最终没有多余的空间来为新的线程分配，导致OutOfMemoryError
 */
public class StackOOMError {
	private static int index = 1;
	private static boolean flag = true;

	public void doSomething() {
		try {
			Thread.sleep(100000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		StackOOMError error = new StackOOMError();
		while (flag) {
			try {
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
						error.doSomething();
					}
				});
				thread.start();
			} catch (Throwable e) {
				flag = false;
				System.out.println("Run times : " + index);
				e.printStackTrace();
			}
		}
	}
}
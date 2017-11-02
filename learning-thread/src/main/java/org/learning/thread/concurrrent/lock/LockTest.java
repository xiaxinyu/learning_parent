package org.learning.thread.concurrrent.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	private final static OutPut out = new OutPut();
	private static String MODE_LOCK = "lock";
	private static String MODE_UNLOCK = "unlock";
	private static int WAITING_SECOND = 20;

	public static void main(String[] args) {
		//invokeTraditionalThread(MODE_UNLOCK);
		//Under multithreading, must use mode lock to make every task can be completed in a thread
		invokeThreadPool(MODE_LOCK);
	}

	static class OutPut {
		//must use same lock for all invoked thread
		Lock lock = new ReentrantLock();
		public void printWithLock(String value) {
			lock.lock();
			try{
				if (value != null && value.length() > 0) {
					for (int i = 0; i < value.length(); i++) {
						System.out.print(value.charAt(i));
					}
				}
				System.out.println();
			}finally{
				lock.unlock();
			}
		}
		
		public void printWithoutLock(String value) {
			if (value != null && value.length() > 0) {
				for (int i = 0; i < value.length(); i++) {
					System.out.print(value.charAt(i));
				}
			}
			System.out.println();
		}
	}
	
	
	static void invokeThreadPool(final String mode){
		int poolSize = 5;
		ExecutorService pool = Executors.newFixedThreadPool(poolSize);
		for (int i = 0; i < poolSize; i++) {
			pool.execute(new Runnable() {
				public void run() {
					while (true) {
						try {
							Thread.sleep(WAITING_SECOND);
						} catch (InterruptedException e) {
						}
						String threadName = Thread.currentThread().getName();
						if(MODE_LOCK.equals(mode)){
							out.printWithLock(threadName);
						}else{
							out.printWithoutLock(threadName);
						}
					}
				}
			});
		}
	}
	
	static void invokeTraditionalThread(final String mode) {
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(WAITING_SECOND);
					} catch (InterruptedException e) {
					}
					String threadName = Thread.currentThread().getName();
					if(MODE_LOCK.equals(mode)){
						out.printWithLock(threadName);
					}else{
						out.printWithoutLock(threadName);
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(WAITING_SECOND);
					} catch (InterruptedException e) {
					}
					String threadName = Thread.currentThread().getName();
					if(MODE_LOCK.equals(mode)){
						out.printWithLock(threadName);
					}else{
						out.printWithoutLock(threadName);
					}
				}
			}
		}).start();
	}
}

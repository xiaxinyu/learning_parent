package org.learning.lock.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantPerformanceTest {
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		for (int i = 1; i <= 10; i++) {
			new Thread(new ReentrantLockPermance(lock), "Window" + i).start();
		}

		for (int i = 1; i <= 10; i++) {
			new Thread(new SyncLookPerfonmance(), "Window" + i).start();
		}
	}
}

class TicketPool {
	private static final int DEFAULT_POOL = 100000;
	private static volatile int pool = DEFAULT_POOL;
	public static long t1 = 0;
	public static long t2 = 0;

	public static int saleOneTicket() {
		return pool--;
	}

	public static boolean checkSaleStatus() {
		if (pool > 0) {
			return true;
		}
		return false;
	}

	public static int getCurrentTicket() {
		return pool;
	}

	public static int getDefualtTicket() {
		return DEFAULT_POOL;
	}
}

class ReentrantLockPermance implements Runnable {
	private Lock lock;

	public ReentrantLockPermance(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		while (true) {
			lock.lock();
			try {
				if (TicketPool.checkSaleStatus()) {
					if (TicketPool.getCurrentTicket() == TicketPool.getDefualtTicket()) {
						TicketPool.t1 = System.currentTimeMillis();
					}
					System.out.println(
							Thread.currentThread().getName() + " sales : Ticket" + (TicketPool.saleOneTicket()));
					if (TicketPool.getCurrentTicket() == 0) {
						TicketPool.t2 = System.currentTimeMillis();
						System.out.println("Cost : " + (TicketPool.t2 - TicketPool.t1));
					}
				} else {
					break;
				}
			} finally {
				lock.unlock();
			}
		}
	}
}

class SyncLookPerfonmance implements Runnable {
	@Override
	public void run() {
		while (true) {
			synchronized (SyncLookPerfonmance.class) {
				if (TicketPool.checkSaleStatus()) {
					if (TicketPool.getCurrentTicket() == TicketPool.getDefualtTicket()) {
						TicketPool.t1 = System.currentTimeMillis();
					}
					System.out.println(
							Thread.currentThread().getName() + " sales : Ticket" + (TicketPool.saleOneTicket()));
					if (TicketPool.getCurrentTicket() == 0) {
						TicketPool.t2 = System.currentTimeMillis();
						System.out.println("Cost : " + (TicketPool.t2 - TicketPool.t1));
					}
				} else {
					break;
				}
			}
		}
	}
}

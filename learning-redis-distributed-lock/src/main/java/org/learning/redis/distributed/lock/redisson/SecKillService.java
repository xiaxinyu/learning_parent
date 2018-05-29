package org.learning.redis.distributed.lock.redisson;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;

public class SecKillService {
	private RLock locker = null;
	private int n = 500;
	
	public SecKillService(RLock locker) {
		this.locker = locker;
	}

	public void seckill() {
		locker.lock(10,TimeUnit.SECONDS);
		System.out.println(Thread.currentThread().getName() + "获得了锁");
		System.out.println(--n);
		locker.unlock();
	}
}

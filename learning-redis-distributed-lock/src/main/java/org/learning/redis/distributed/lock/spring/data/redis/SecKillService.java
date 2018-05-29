package org.learning.redis.distributed.lock.spring.data.redis;

import org.springframework.data.redis.core.RedisTemplate;

public class SecKillService {
	private SpringDataRedisDistributedLock locker = null;
	private int n = 500;
	
	public SecKillService(RedisTemplate<String, Object> template) {
		locker = new SpringDataRedisDistributedLock(template, "resource", 100, 100);
	}

	public void seckill() {
		try {
			locker.lock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "获得了锁");
		System.out.println(--n);
		locker.unlock();
	}
}

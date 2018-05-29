package org.learning.redis.distributed.lock.jedis;

import redis.clients.jedis.JedisPool;

public class SecKillService {
	private JedisDistributedLock lock = null;
	private int n = 500;
	
	public SecKillService(JedisPool jedisPool) {
		lock = new JedisDistributedLock(jedisPool);
	}

	public void seckill() {
		String indentifier = lock.lockWithTimeout("resource", 5000, 1000);
		System.out.println(Thread.currentThread().getName() + "获得了锁");
		System.out.println(--n);
		lock.releaseLock("resource", indentifier);
	}
}

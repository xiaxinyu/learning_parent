package org.learning.redis.distributed.lock.redisson;

public class Test {
	public static void main(String[] args) {
		SecKillService service = new SecKillService(RedissonContext.getRedissonClient().getFairLock("mylock"));
		for (int i = 0; i < 50; i++) {
			Consumer consumer = new Consumer(service);
			consumer.start();
		}
	}
}
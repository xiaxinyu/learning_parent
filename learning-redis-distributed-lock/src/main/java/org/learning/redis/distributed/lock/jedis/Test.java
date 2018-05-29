package org.learning.redis.distributed.lock.jedis;

public class Test {
	public static void main(String[] args) {
		SecKillService service = new SecKillService(JedisPoolContext.getJedisPool());
		for (int i = 0; i < 50; i++) {
			Consumer consumer = new Consumer(service);
			consumer.start();
		}
	}
}
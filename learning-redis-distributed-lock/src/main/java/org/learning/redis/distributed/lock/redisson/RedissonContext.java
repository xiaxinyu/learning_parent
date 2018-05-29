package org.learning.redis.distributed.lock.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonContext {
			
	public static RedissonClient getRedissonClient() {
		Config config = new Config();
		config.useSingleServer().setAddress("redis://192.168.179.131:6379");
		config.useSingleServer().setPassword("redis");
		RedissonClient client = Redisson.create(config);
		return client;
	}
	
	public static void main(String[] args) {
		RLock lock = RedissonContext.getRedissonClient().getFairLock("summer");
	}
}

package org.learning.redis.distributed.lock.jedis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolContext {
	public static JedisPool getJedisPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(200);
		config.setMaxIdle(8);
		config.setMaxWaitMillis(1000 * 100);
		config.setTestOnBorrow(true);
		return new JedisPool(config, "192.168.179.131", 6379, 3000, "redis");
	}
}

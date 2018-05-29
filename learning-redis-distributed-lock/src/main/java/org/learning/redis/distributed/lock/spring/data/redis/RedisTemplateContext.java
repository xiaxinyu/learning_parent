package org.learning.redis.distributed.lock.spring.data.redis;

import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class RedisTemplateContext {
	public static RedisTemplate<String, Object> getRedisTemplate() {
		RedisStandaloneConfiguration standaloneConfig = new RedisStandaloneConfiguration("192.168.179.131", 6379);
		standaloneConfig.setPassword(RedisPassword.of("redis"));
		standaloneConfig.setDatabase(0);
		JedisConnectionFactory factory = new JedisConnectionFactory(standaloneConfig);

		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setEnableTransactionSupport(true);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setConnectionFactory(factory);
		return redisTemplate;
	}
}

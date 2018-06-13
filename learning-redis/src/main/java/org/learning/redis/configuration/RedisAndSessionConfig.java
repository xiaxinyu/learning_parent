package org.learning.redis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
public class RedisAndSessionConfig {
	@Bean
	public RedisConnectionFactory jedisConnectionFactory() {
		RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration().master("mymaster")
				.sentinel("192.168.179.131", 28000)
				.sentinel("192.168.179.131", 28001)
				.sentinel("192.168.179.131", 28002);
		return new JedisConnectionFactory(sentinelConfig);
	}
}
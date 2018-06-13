package org.learning.mybatis.cache;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.learning.mybatis.core.Constants;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCachePrefix;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
	@Bean
	public KeyGenerator redisCacheKeyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for (Object obj : params) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}

	@Bean
	public CacheManager cacheManager(RedisTemplate<String, Object> redisTemplate) {
		RedisCacheManager manager = new RedisCacheManager(redisTemplate);
		manager.setUsePrefix(true);

		RedisCachePrefix cachePrefix = new RedisPrefix("prefix");
		manager.setCachePrefix(cachePrefix);
		// 整体缓存过期时间
		manager.setDefaultExpiration(3600L);
		// 设置缓存过期时间。key和缓存过期时间，单位秒
		Map<String, Long> expiresMap = new HashMap<>();
		expiresMap.put(Constants.APP_CACHE_NAME, 1000L);
		manager.setExpires(expiresMap);
		return manager;
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory cf) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setConnectionFactory(cf);
		return redisTemplate;
	}
}

package org.learning.mybatis.cache;

import org.springframework.data.redis.cache.RedisCachePrefix;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis前缀配置，有时候多个工程共用一个database需要区分
 * @author summer.xiasz
 */
public class RedisPrefix implements RedisCachePrefix {
	private final RedisSerializer<String> serializer;
    private final String delimiter;

    public RedisPrefix() {
        this(":");
    }

    public RedisPrefix(String delimiter) {
        this.serializer = new StringRedisSerializer();
        this.delimiter = delimiter;
    }

    @Override
    public byte[] prefix(String cacheName) {
        return this.serializer.serialize(this.delimiter != null ? this.delimiter.concat(":").concat(cacheName).concat(":")
						: cacheName.concat(":"));
	}
}

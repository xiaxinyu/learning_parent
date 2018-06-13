package org.learning.mybatis.redis;

import org.learning.mybatis.bean.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
	@Autowired
	private StringRedisTemplate stringRedistemplate;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public void set(String key, String vlaue) {
		stringRedistemplate.opsForValue().set(key, vlaue);
	}

	public void set(Dept dept) {
		redisTemplate.opsForValue().set(String.valueOf(dept.getDeptNo().intValue()), dept);
	}

	public String get(String key) {
		return stringRedistemplate.opsForValue().get(key);
	}

	public Dept getDept(Integer key) {
		return (Dept) redisTemplate.opsForValue().get(String.valueOf(key.intValue()));
	}
}

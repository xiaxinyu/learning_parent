package com.learning.mybatis.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.learning.mybatis.Application;
import org.learning.mybatis.bean.Dept;
import org.learning.mybatis.redis.RedisService;
import org.learning.mybatis.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisServiceTest {
	@Autowired
	private RedisService redisServcie;
	
	@Autowired
	private DeptService deptService;

	@Test
	public void testSetString() {
		String key = "test001";
		String value = "summer001";
		redisServcie.set(key, value);

		String redisValue = redisServcie.get(key);
		Assert.assertTrue(value.equals(redisValue));
	}
	
	@Test
	public void testSetObject() {
		Integer deptNo = 81;
		Dept dept = deptService.findByDeptNO(deptNo);
		Assert.assertNotNull(dept);
		
		redisServcie.set(dept);
		Dept deptRedis = redisServcie.getDept(deptNo);
		Assert.assertTrue(dept.getDeptName().equals(deptRedis.getDeptName()));
	}
}

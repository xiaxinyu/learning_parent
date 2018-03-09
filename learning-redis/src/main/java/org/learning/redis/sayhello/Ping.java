package org.learning.redis.sayhello;

import org.learning.redis.core.Constant;

import redis.clients.jedis.Jedis;

public class Ping {

	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis(Constant.HOST, Constant.PORT);
		System.out.println("连接成功");
		// 查看服务是否运行
		System.out.println("服务正在运行: " + jedis.ping());
	}

}

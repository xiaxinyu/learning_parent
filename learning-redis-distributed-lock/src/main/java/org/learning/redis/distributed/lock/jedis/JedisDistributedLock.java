package org.learning.redis.distributed.lock.jedis;

import java.util.List;
import java.util.UUID;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.exceptions.JedisException;

public class JedisDistributedLock {
	private final JedisPool jedisPool;

	public JedisDistributedLock(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	public String lockWithTimeout(String locaName, long acquireTimeout, long timeout) {
		Jedis conn = null;
		String retIdentifier = null;
		try {
			conn = jedisPool.getResource();
			String identifier = UUID.randomUUID().toString();
			String lockKey = "lock:" + locaName;
			int lockExpire = (int) (timeout / 1000);

			long end = System.currentTimeMillis() + acquireTimeout;
			while (System.currentTimeMillis() < end) {
				// SETNX 是『SET if Not eXists』(如果不存在，则 SET)的简写
				// 设置成功，返回 1 。
				// 设置失败，返回 0 。
				if (conn.setnx(lockKey, identifier) == 1) {
					conn.expire(lockKey, lockExpire);
					retIdentifier = identifier;
					return retIdentifier;
				}
				// 返回-1代表key没有设置超时时间，为key设置一个超时时间
				if (conn.ttl(lockKey) == -1) {
					conn.expire(lockKey, lockExpire);
				}

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		} catch (JedisException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return retIdentifier;
	}

	public boolean releaseLock(String lockName, String identifier) {
		Jedis conn = null;
		String lockKey = "lock:" + lockName;
		boolean retFlag = false;
		try {
			conn = jedisPool.getResource();
			while (true) {
				// 监视lock，准备开始事务
				conn.watch(lockKey);
				// 通过前面返回的value值判断是不是该锁，若是该锁，则删除，释放锁
				if (identifier.equals(conn.get(lockKey))) {
					Transaction transaction = conn.multi();
					transaction.del(lockKey);
					List<Object> results = transaction.exec();
					if (results == null) {
						continue;
					}
					retFlag = true;
				}
				conn.unwatch();
				break;
			}
		} catch (JedisException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return retFlag;
	}
}

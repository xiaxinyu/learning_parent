package org.learning.redis.distributed.lock.spring.data.redis;

public class Consumer extends Thread {
	private SecKillService service;

	public Consumer(SecKillService service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.seckill();
	}
}

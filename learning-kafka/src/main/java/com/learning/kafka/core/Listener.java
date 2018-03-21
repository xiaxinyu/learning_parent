package com.learning.kafka.core;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;

import com.leanring.kafka.test.PlainTest;

public class Listener {
	private Logger logger = Logger.getLogger(PlainTest.class);
	public final CountDownLatch latch1 = new CountDownLatch(1);

	@KafkaListener(topics = Constant.TOPIC)
	public void listen1(ConsumerRecord<Integer, String> record) {
		logger.info(record);
		this.latch1.countDown();
	}

}

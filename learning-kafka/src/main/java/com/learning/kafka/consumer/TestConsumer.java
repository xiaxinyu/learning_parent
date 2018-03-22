package com.learning.kafka.consumer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.learning.kafka.producer.KafkaProducerParameters;

@Component
public class TestConsumer {
	private final Logger logger = Logger.getLogger(TestConsumer.class);

	@KafkaListener(topics = { "test" })
	public String consumerMessage(String message) {
		logger.info("consume message:" + message);
		return message;
	}
}
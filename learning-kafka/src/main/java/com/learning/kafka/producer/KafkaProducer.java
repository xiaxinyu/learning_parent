package com.learning.kafka.producer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
	private Logger logger = Logger.getLogger(KafkaProducer.class);
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	@Autowired
	private KafkaProducerParameters parameters;
	
	
	
	public void sendMessage(String message) {
		logger.info("Send message：" + message);
		kafkaTemplate.send(parameters.getTestTopic(), message);
	}
}

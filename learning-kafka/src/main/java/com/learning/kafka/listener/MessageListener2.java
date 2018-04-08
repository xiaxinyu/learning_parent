package com.learning.kafka.listener;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.learning.kafka.beans.Message;

@Component
public class MessageListener2 {
	private final Logger logger = Logger.getLogger(MessageListener2.class);

	@KafkaListener(topics = { "test" }, groupId = "group1")
	public Message consumer(Message message) {
		logger.info("Listener2 consume message:" + message.toString());
		return message;
	}
}
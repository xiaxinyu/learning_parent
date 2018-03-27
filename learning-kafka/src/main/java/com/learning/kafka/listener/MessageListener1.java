package com.learning.kafka.listener;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.learning.kafka.beans.Message;

@Component
public class MessageListener1 {
	private final Logger logger = Logger.getLogger(MessageListener1.class);

	@KafkaListener(topics = { "test" }, groupId = "group2")
	public Message consumer(Message message) {
		logger.info("Listener1 consume message:" + message.getName());
		return message;
	}
}
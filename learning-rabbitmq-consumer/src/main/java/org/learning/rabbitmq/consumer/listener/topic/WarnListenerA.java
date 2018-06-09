package org.learning.rabbitmq.consumer.listener.topic;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "warn-queue")
public class WarnListenerA {
	private Logger logger = Logger.getLogger(WarnListenerA.class);
	
	@RabbitHandler
	public void process(String message) {
		logger.info("warn-queue(A) message: " + message + " from TopicExchange.");
	}
}
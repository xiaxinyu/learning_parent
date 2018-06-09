package org.learning.rabbitmq.consumer.listener.topic;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "info-queue")
public class InfoListener {
	private Logger logger = Logger.getLogger(InfoListener.class);

	@RabbitHandler
	public void process(String message) {
		logger.info("info-queue message: " + message + " from TopicExchange.");
	}
}

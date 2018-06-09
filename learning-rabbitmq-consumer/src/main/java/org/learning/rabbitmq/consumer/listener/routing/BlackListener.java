package org.learning.rabbitmq.consumer.listener.routing;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "black-queue")
public class BlackListener {
	private Logger logger = Logger.getLogger(BlackListener.class);
	
	@RabbitHandler
	public void process(String message) {
		logger.info("black-queue message: " + message + " from DirectExchange.");
	}
}
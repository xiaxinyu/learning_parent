package org.learning.rabbitmq.consumer.listener.routing;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "green-queue")
public class GreenListener {
	private Logger logger = Logger.getLogger(GreenListener.class);
	
	@RabbitHandler
	public void process(String message) {
		logger.info("green-queue message: " + message + " from DirectExchange.");
	}
}
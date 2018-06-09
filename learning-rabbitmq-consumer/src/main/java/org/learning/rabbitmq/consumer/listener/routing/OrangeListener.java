package org.learning.rabbitmq.consumer.listener.routing;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "orange-queue")
public class OrangeListener {
	private Logger logger = Logger.getLogger(OrangeListener.class);

	@RabbitHandler
	public void process(String message) {
		logger.info("orange-queue message: " + message + " from DirectExchange.");
	}
}

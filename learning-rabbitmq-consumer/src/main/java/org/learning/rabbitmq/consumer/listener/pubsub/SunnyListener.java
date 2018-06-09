package org.learning.rabbitmq.consumer.listener.pubsub;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "sunny-queue")
public class SunnyListener {
	private Logger logger = Logger.getLogger(SunnyListener.class);
	
	@RabbitHandler
	public void process(String message) {
		logger.info("sunny-queue message: " + message + " from PubSubExchange.");
	}
}

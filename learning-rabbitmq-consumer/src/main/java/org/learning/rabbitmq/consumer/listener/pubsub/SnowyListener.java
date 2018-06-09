package org.learning.rabbitmq.consumer.listener.pubsub;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "snowy-queue")
public class SnowyListener {
	private Logger logger = Logger.getLogger(SnowyListener.class);
	
	@RabbitHandler
	public void process(String message) {
		logger.info("snowy-queue message: " + message + " from PubSubExchange.");
	}
}

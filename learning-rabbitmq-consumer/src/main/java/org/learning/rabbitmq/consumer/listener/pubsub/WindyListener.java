package org.learning.rabbitmq.consumer.listener.pubsub;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "windy-queue")
public class WindyListener {
	private Logger logger = Logger.getLogger(WindyListener.class);

	@RabbitHandler
	public void process(String message) {
		logger.info("windy-queue message: " + message + " from PubSubExchange.");
	}
}

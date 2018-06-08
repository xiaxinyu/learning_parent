package org.learning.rabbitmq.consumer.listener.helloworld;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "helloworld")
public class HelloWorldListener {
	private Logger logger = Logger.getLogger(HelloWorldListener.class);

	@RabbitHandler
	public void process(String message) {
		logger.info("Receiver message: " + message + " from helloworld.");
	}
}

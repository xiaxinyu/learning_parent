package org.learning.rabbitmq.consumer.listener.pubsubexchange;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "pubsubqueueb")
public class PubSubExchangeListenerB {
	private Logger logger = Logger.getLogger(PubSubExchangeListenerB.class);
	
	@RabbitHandler
	public void process(String message) {
		logger.info("ReceiverB message: " + message + " from PubSubExchange.");
	}
}

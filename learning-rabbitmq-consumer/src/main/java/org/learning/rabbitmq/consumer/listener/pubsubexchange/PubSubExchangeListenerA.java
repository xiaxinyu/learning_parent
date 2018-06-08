package org.learning.rabbitmq.consumer.listener.pubsubexchange;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "pubsubqueuea")
public class PubSubExchangeListenerA {
	private Logger logger = Logger.getLogger(PubSubExchangeListenerA.class);

	@RabbitHandler
	public void process(String message) {
		logger.info("ReceiverA message: " + message + " from PubSubExchange.");
	}
}

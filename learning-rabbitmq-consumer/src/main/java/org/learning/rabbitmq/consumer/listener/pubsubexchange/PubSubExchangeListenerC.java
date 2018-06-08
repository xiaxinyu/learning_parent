package org.learning.rabbitmq.consumer.listener.pubsubexchange;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "pubsubqueuec")
public class PubSubExchangeListenerC {
	private Logger logger = Logger.getLogger(PubSubExchangeListenerC.class);
	
	@RabbitHandler
	public void process(String message) {
		logger.info("ReceiverC message: " + message + " from PubSubExchange.");
	}
}

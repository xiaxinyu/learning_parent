package org.learning.rabbitmq.consumer.listener.topic;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topicqueueb")
public class TopicExchangeListenerB {
	private Logger logger = Logger.getLogger(TopicExchangeListenerB.class);
	
	@RabbitHandler
	public void process(String message) {
		logger.info("ReceiverB message: " + message + " from TopicExchange.");
	}
}
package org.learning.rabbitmq.consumer.listener.topic;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topicqueuea")
public class TopicExchangeListenerA {
	private Logger logger = Logger.getLogger(TopicExchangeListenerA.class);

	@RabbitHandler
	public void process(String message) {
		logger.info("ReceiverA message: " + message + " from TopicExchange.");
	}
}

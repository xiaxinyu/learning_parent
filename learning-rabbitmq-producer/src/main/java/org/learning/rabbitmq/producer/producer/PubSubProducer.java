package org.learning.rabbitmq.producer.producer;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PubSubProducer {
	private Logger logger = Logger.getLogger(PubSubProducer.class);

	@Autowired
	private RabbitTemplate template;

	@Value("${pubsub-mode.exchange.name}")
	public String exchangeName;

	public void sendMessage(String message) {
		logger.info("Send message: " + message + " to " + this.exchangeName);
		template.convertAndSend(this.exchangeName, null, message);
	}
}

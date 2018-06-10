package org.learning.rabbitmq.producer.producer;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TopicProducer {
	private Logger logger = Logger.getLogger(TopicProducer.class);

	@Autowired
	private RabbitTemplate template;

	@Value("${topic-mode.exchange.name}")
	public String exchangeName;
	
	@Value("${topic-mode.routing-key.info}")
	private String routingKeyInfo;

	@Value("${topic-mode.routing-key.warn}")
	private String routingKeyWarn;

	public void sendMessageInfo(String message) {
		logger.info("Send others message: " + message + " to " + this.exchangeName);
		template.convertAndSend(this.exchangeName, this.routingKeyInfo, message);
	}

	public void sendMessageWarn(String message) {
		logger.info("Send main message: " + message + " to " + this.exchangeName);
		template.convertAndSend(this.exchangeName, this.routingKeyWarn, message);
	}
}

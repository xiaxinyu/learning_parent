package org.learning.rabbitmq.producer.rabbitmq.producer;

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

	@Value("${exchange.name.topic}")
	public String exchangeName;

	public void sendMessageOthers(String message) {
		logger.info("Send others message: " + message + " to " + this.exchangeName);
		template.convertAndSend(this.exchangeName, "topic.others", message);
	}

	public void sendMessageMain(String message) {
		logger.info("Send main message: " + message + " to " + this.exchangeName);
		template.convertAndSend(this.exchangeName, "topic.main", message);
	}
}

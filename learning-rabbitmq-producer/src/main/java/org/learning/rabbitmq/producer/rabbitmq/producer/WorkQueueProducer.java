package org.learning.rabbitmq.producer.rabbitmq.producer;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WorkQueueProducer {
	private Logger logger = Logger.getLogger(WorkQueueProducer.class);
	
	@Autowired
	private RabbitTemplate template;

	@Value("${work-mode.queue.name}")
	private String queueName;

	public void sendMessage(String message) {
		logger.info("Send message: " + message + " to " + this.queueName);
		template.convertAndSend(queueName, message);
	}
}

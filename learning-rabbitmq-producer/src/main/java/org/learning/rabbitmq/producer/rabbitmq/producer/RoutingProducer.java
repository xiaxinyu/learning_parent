package org.learning.rabbitmq.producer.rabbitmq.producer;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RoutingProducer {
	private Logger logger = Logger.getLogger(RoutingProducer.class);

	@Autowired
	private RabbitTemplate template;

	@Value("${routing-mode.exchange.name}")
	private String exchangeName;

	@Value("${routing-mode.routing-key.orange}")
	private String routingKeyOrange;

	@Value("${routing-mode.routing-key.black}")
	private String routingKeyBlack;

	@Value("${routing-mode.routing-key.green}")
	private String routingKeyGreen;

	public void sendMessageOrange(String message) {
		logger.info("Send others message: " + message + " to " + this.exchangeName);
		template.convertAndSend(this.exchangeName, this.routingKeyOrange, message);
	}

	public void sendMessageBlack(String message) {
		logger.info("Send main message: " + message + " to " + this.exchangeName);
		template.convertAndSend(this.exchangeName, this.routingKeyBlack, message);
	}
	
	public void sendMessageGreen(String message) {
		logger.info("Send main message: " + message + " to " + this.exchangeName);
		template.convertAndSend(this.exchangeName, this.routingKeyGreen, message);
	}
}

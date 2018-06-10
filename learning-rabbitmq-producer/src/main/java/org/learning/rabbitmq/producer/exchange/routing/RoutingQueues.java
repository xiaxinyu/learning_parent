package org.learning.rabbitmq.producer.exchange.routing;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingQueues {

	@Value("${routing-mode.queues.name.orange}")
	private String queueNameOrange;

	@Value("${routing-mode.queues.name.black}")
	private String queueNameBlack;

	@Value("${routing-mode.queues.name.green}")
	private String queueNameGreen;

	@Bean
	public Queue queueOrange() {
		return new Queue(queueNameOrange);
	}

	@Bean
	public Queue queueBlack() {
		return new Queue(queueNameBlack);
	}

	@Bean
	public Queue queueGreen() {
		return new Queue(queueNameGreen);
	}
}

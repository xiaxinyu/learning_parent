package org.learning.rabbitmq.producer.rabbitmq.queue.helloworld;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWordQueue {
	@Value("${single-mode.queue.name}")
	private String queueName;

	@Bean
	public Queue singleModeQueue() {
		return new Queue(queueName);
	}
}

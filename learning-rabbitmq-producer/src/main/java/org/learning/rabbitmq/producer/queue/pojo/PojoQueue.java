package org.learning.rabbitmq.producer.queue.pojo;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PojoQueue {

	@Value("${pojo-mode.queue.name}")
	private String queueName;

	@Bean
	public Queue pojoModeQueue() {
		return new Queue(queueName);
	}
}

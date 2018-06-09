package org.learning.rabbitmq.producer.rabbitmq.queue.work;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkQueue {

	@Value("${work-mode.queue.name}")
	private String queueName;

	@Bean
	public Queue workModeQueue() {
		return new Queue(queueName);
	}
}

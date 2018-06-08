package org.learning.rabbitmq.producer.rabbitmq.queue.work;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkQueue {

	@Value("${queue.name.workqueue}")
	private String queueName;

	@Bean
	public Queue workQueueMethod() {
		return new Queue(queueName);
	}
}

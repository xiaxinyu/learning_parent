package org.learning.rabbitmq.producer.rabbitmq.exchange.topic;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicModeQueues {
	@Value("${topic-mode.queues.name.info}")
	private String queueNameInfo;

	@Value("${topic-mode.queues.name.warn}")
	private String queueNameWarn;

	@Bean
	public Queue queueInfo() {
		return new Queue(queueNameInfo);
	}

	@Bean
	public Queue queueWarn() {
		return new Queue(queueNameWarn);
	}
}

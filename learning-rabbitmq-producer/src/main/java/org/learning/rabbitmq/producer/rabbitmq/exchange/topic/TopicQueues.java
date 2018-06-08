package org.learning.rabbitmq.producer.rabbitmq.exchange.topic;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicQueues {
	@Value("${queue.name.topicqueuea}")
	private String queueNameA;

	@Value("${queue.name.topicqueueb}")
	private String queueNameB;

	@Bean
	public Queue topicQueueA() {
		return new Queue(queueNameA);
	}

	@Bean
	public Queue topicQueueB() {
		return new Queue(queueNameB);
	}
}

package org.learning.rabbitmq.producer.rabbitmq.exchange.pubsub;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PubSubQueues {

	@Value("${queue.name.pubsubqueuea}")
	private String queueNameA;

	@Value("${queue.name.pubsubqueueb}")
	private String queueNameB;

	@Value("${queue.name.pubsubqueuec}")
	private String queueNameC;

	@Bean
	public Queue pubsubQueueA() {
		return new Queue(queueNameA);
	}

	@Bean
	public Queue pubsubQueueB() {
		return new Queue(queueNameB);
	}

	@Bean
	public Queue pubsubQueueC() {
		return new Queue(queueNameC);
	}
}

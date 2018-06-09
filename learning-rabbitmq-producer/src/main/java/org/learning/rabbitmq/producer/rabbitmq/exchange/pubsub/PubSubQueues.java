package org.learning.rabbitmq.producer.rabbitmq.exchange.pubsub;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PubSubQueues {

	@Value("${pubsub-mode.queues.name.windy}")
	private String queueNameWindy;

	@Value("${pubsub-mode.queues.name.snowy}")
	private String queueNameSnowy;

	@Value("${pubsub-mode.queues.name.sunny}")
	private String queueNameSunny;

	@Bean
	public Queue queueWindy() {
		return new Queue(queueNameWindy);
	}

	@Bean
	public Queue queueSnowy() {
		return new Queue(queueNameSnowy);
	}

	@Bean
	public Queue queueSunny() {
		return new Queue(queueNameSunny);
	}
}

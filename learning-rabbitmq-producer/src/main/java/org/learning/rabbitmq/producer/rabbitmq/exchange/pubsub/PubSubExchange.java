package org.learning.rabbitmq.producer.rabbitmq.exchange.pubsub;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PubSubExchange {
	private Logger logger = Logger.getLogger(PubSubExchange.class);

	@Value("${exchange.name.pubsub}")
	public String exchangeName;

	@Bean
	public FanoutExchange pubSubFanoutExchange() {
		return new FanoutExchange(exchangeName);
	}

	@Bean
	public Binding bindingExchangeWithQueueA(Queue pubsubQueueA, FanoutExchange pubSubFanoutExchange) {
		logger.info("binding exchange: " + pubSubFanoutExchange.getName() + " queue: " + pubsubQueueA.getName());
		return BindingBuilder.bind(pubsubQueueA).to(pubSubFanoutExchange);
	}

	@Bean
	public Binding bindingExchangeWithQueueB(Queue pubsubQueueB, FanoutExchange pubSubFanoutExchange) {
		logger.info("binding exchange: " + pubSubFanoutExchange.getName() + " queue: " + pubsubQueueB.getName());
		return BindingBuilder.bind(pubsubQueueB).to(pubSubFanoutExchange);
	}

	@Bean
	public Binding bindingExchangeWithQueueC(Queue pubsubQueueC, FanoutExchange pubSubFanoutExchange) {
		logger.info("binding exchange: " + pubSubFanoutExchange.getName() + " queue: " + pubsubQueueC.getName());
		return BindingBuilder.bind(pubsubQueueC).to(pubSubFanoutExchange);
	}
}

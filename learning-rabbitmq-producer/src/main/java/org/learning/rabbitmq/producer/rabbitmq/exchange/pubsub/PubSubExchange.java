package org.learning.rabbitmq.producer.rabbitmq.exchange.pubsub;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PubSubExchange {
	@Value("${pubsub-mode.exchange.name}")
	public String exchangeName;

	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange(exchangeName);
	}

	@Bean
	public Binding bindingQueueWindy2FanoutExchange(Queue queueWindy, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(queueWindy).to(fanoutExchange);
	}

	@Bean
	public Binding bindingQueueSnowy2FanoutExchange(Queue queueSnowy, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(queueSnowy).to(fanoutExchange);
	}

	@Bean
	public Binding bindingQueueSunny2FanoutExchange(Queue queueSunny, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(queueSunny).to(fanoutExchange);
	}
}

package org.learning.rabbitmq.producer.exchange.routing;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingExchange {

	@Value("${routing-mode.exchange.name}")
	private String exchangeName;

	@Value("${routing-mode.routing-key.orange}")
	private String routingKeyOrange;

	@Value("${routing-mode.routing-key.black}")
	private String routingKeyBlack;

	@Value("${routing-mode.routing-key.green}")
	private String routingKeyGreen;

	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(exchangeName);
	}

	@Bean
	public Binding bindingQueueOrange2DirectExchange(Queue queueOrange, DirectExchange directExchange) {
		return BindingBuilder.bind(queueOrange).to(directExchange).with(routingKeyOrange);
	}

	@Bean
	public Binding bindingQueueBlack2DirectExchange(Queue queueBlack, DirectExchange directExchange) {
		return BindingBuilder.bind(queueBlack).to(directExchange).with(routingKeyBlack);
	}

	@Bean
	public Binding bindingQueueGreen2DirectExchange(Queue queueGreen, DirectExchange directExchange) {
		return BindingBuilder.bind(queueGreen).to(directExchange).with(routingKeyGreen);
	}
}

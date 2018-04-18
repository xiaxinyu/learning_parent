package com.learning.rabbitmq.queue.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FanoutExchangeFactory {
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("fanoutExchange");
	}

	@Bean
	public Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(AMessage).to(fanoutExchange);
	}

	@Bean
	public Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(BMessage).to(fanoutExchange);
	}

	@Bean
	public Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(CMessage).to(fanoutExchange);
	}
}

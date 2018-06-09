package org.learning.rabbitmq.consumer.rpc.client;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RPCClient {
	@Autowired
	private RabbitTemplate template;
	
	@Value("${rpc-mode.exchange.name}")
	private String exchangeName;

	@Value("${rpc-mode.routing-key.rpc}")
	private String routingKeyRPC;

	private int start = 0;

	public Integer send() {
		System.out.println(" [x] Requesting fib(" + start + ")");
		Integer response = (Integer) template.convertSendAndReceive(exchangeName, routingKeyRPC, start++);
		System.out.println(" [.] Got '" + response + "'");
		return response;
	}
}

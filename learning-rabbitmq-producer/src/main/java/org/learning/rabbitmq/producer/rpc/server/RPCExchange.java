package org.learning.rabbitmq.producer.rpc.server;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RPCExchange {

	@Value("${rpc-mode.exchange.name}")
	private String exchangeName;

	@Value("${rpc-mode.routing-key.rpc}")
	private String routingKeyRPC;

	@Bean
	public DirectExchange rpcDirectExchange() {
		return new DirectExchange(exchangeName);
	}

	@Bean
	public Binding bindingQueueRPC2DirectExchange(Queue queueRPC, DirectExchange rpcDirectExchange) {
		return BindingBuilder.bind(queueRPC).to(rpcDirectExchange).with(this.routingKeyRPC);
	}
	
	@RabbitListener(queues = "rpc-queue")
    public int fibonacci(int n) {
        System.out.println(" [x] Received request for " + n);
        int result = fib(n);
        System.out.println(" [.] Returned " + result);
        return result;
    }

    public int fib(int n) {
        //return n == 0 ? 0 : n == 1 ? 1 : (fib(n - 1) + fib(n - 2));
    	return n;
    }
}

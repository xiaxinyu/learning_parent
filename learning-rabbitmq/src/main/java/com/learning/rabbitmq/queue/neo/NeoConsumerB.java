package com.learning.rabbitmq.queue.neo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "neo")
public class NeoConsumerB {
	@RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver B: " + hello);
    }
}
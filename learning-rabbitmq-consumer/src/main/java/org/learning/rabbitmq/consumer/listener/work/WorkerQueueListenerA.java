package org.learning.rabbitmq.consumer.listener.work;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="work-queue")
public class WorkerQueueListenerA {
	private Logger logger = Logger.getLogger(WorkerQueueListenerA.class);
	
	@RabbitHandler
	public void processA(String message) {
		logger.info("WorkerA received message: " + message + " from workqueue.");
	}
}

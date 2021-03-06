package org.learning.rabbitmq.consumer.listener.work;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="work-queue")
public class WorkerQueueListenerB {
	private Logger logger = Logger.getLogger(WorkerQueueListenerB.class);
	
	@RabbitHandler
	public void processB(String message) {
		logger.info("WorkerB received message: " + message + " from workqueue.");
	}
}

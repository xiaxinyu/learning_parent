package org.learning.rabbitmq.producer.controller;

import org.learning.rabbitmq.producer.producer.PubSubProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PubSubController {
	@Autowired
	private PubSubProducer producer;
	
	@RequestMapping(value = "/pubsub/send", method = RequestMethod.GET)
	public void sendMessage(@RequestParam String message) {
		producer.sendMessage(message);
	}
}

package org.learning.rabbitmq.producer.controller;

import org.learning.rabbitmq.producer.rabbitmq.producer.HelloWorldProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@Autowired
	private HelloWorldProducer producer;

	@RequestMapping(value = "/hello/send", method = RequestMethod.GET)
	public void sendMessage(@RequestParam String message) {
		producer.sendMessage(message);
	}
}

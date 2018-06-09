package org.learning.rabbitmq.producer.controller;

import org.learning.rabbitmq.producer.rabbitmq.producer.RoutingProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoutingController {
	@Autowired
	private RoutingProducer producer;

	@RequestMapping(value = "/routing/send/orange", method = RequestMethod.GET)
	public void sendMessageOrange(@RequestParam String message) {
		producer.sendMessageOrange(message);
	}

	@RequestMapping(value = "/routing/send/black", method = RequestMethod.GET)
	public void sendMessageBlack(@RequestParam String message) {
		producer.sendMessageBlack(message);
	}
	
	@RequestMapping(value = "/routing/send/green", method = RequestMethod.GET)
	public void sendMessageGreen(@RequestParam String message) {
		producer.sendMessageGreen(message);
	}
}
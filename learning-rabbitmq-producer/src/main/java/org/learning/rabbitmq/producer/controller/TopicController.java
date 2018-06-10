package org.learning.rabbitmq.producer.controller;

import org.learning.rabbitmq.producer.producer.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	@Autowired
	private TopicProducer producer;

	@RequestMapping(value = "/topic/send/info", method = RequestMethod.GET)
	public void sendMessageMain(@RequestParam String message) {
		producer.sendMessageInfo(message);
	}

	@RequestMapping(value = "/topic/send/warn", method = RequestMethod.GET)
	public void sendMessage2(@RequestParam String message) {
		producer.sendMessageWarn(message);
	}
}
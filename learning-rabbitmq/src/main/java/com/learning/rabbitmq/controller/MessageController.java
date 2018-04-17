package com.learning.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.rabbitmq.beans.Response;
import com.learning.rabbitmq.queue.hello.world.HelloProducer;

@Controller
public class MessageController {
	@Autowired
	private HelloProducer producer;
	
	@RequestMapping(value = "/sendHello", method = RequestMethod.POST)
	@ResponseBody
	public Response sendHello(@RequestParam(value = "message", required = true) String message) {
		producer.send(message);
		return new Response("success", "send successfully");
	}
}

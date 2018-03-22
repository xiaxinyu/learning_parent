package com.learning.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.kafka.entity.Result;
import com.learning.kafka.producer.KafkaProducer;

@Controller
public class SendMessageController {

	@Autowired
	private KafkaProducer producer;

	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	@ResponseBody
	public Result sendMessage(@RequestParam(value = "message", required = true) String message) {
		producer.sendMessage(message);
		return new Result(Result.ResultStatus.SUCCESS, "It's ok.");
	}
}

package org.learning.spring.cloud.eureka.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ApplicationEurekaClient2 {
	private Logger logger = LoggerFactory.getLogger(ApplicationEurekaClient2.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationEurekaClient2.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping(value = "sayHello", method = RequestMethod.GET)
	public String sayHello(@RequestParam String name) {
		logger.info("EurekaClient2-sayHello, request parameter[name={}]", name);
		return "Hello," + name + ",I am from port:" + port;
	}
}
package org.learning.spring.cloud.eureka.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Applicaiton {
	public static void main(String[] args) {
		SpringApplication.run(Applicaiton.class, args);
	}
}
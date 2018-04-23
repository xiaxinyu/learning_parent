package org.learning.swagger.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.learning.swagger")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}

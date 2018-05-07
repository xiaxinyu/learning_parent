package org.learning.spring.reactive.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.learning.spring.reactive")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}

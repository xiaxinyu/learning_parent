package com.learning.boot.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.learning.boot" })
@ServletComponentScan("com.learning.boot.core")
public class Application{
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}

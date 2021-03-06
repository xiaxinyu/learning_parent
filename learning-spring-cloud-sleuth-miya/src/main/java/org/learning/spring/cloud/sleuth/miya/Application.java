package org.learning.spring.cloud.sleuth.miya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Application {
	public static void main(String[] args) {
		 SpringApplication.run(Application.class, args);
	}
	
	@Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/call", method = RequestMethod.GET)
	public String call() {
		return restTemplate.getForObject("http://localhost:9412/myinfo", String.class);
	}

	@RequestMapping(value = "/myinfo", method = RequestMethod.GET)
	public String info() {
		return "Hi, I'm sleuth.miya-info!";
	}
}

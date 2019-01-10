package org.learning.spring.cloud.hystrix.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "Eureka-Client",fallback = SayHelloHystrixFallback.class)
public interface SayHelloHystrix {
	
	@RequestMapping(value = "sayHello", method = RequestMethod.GET)
	public String sayHello(@RequestParam(value = "name") String name);
}
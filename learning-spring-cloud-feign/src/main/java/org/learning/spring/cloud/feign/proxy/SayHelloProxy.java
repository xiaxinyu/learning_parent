package org.learning.spring.cloud.feign.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "Eureka-Client")
public interface SayHelloProxy {
	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	String sayHello(@RequestParam(value = "name") String name);
}
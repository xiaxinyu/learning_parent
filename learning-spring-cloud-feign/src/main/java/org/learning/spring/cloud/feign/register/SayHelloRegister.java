package org.learning.spring.cloud.feign.register;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "sayHello")
public interface SayHelloRegister {
	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	String sayHello(@RequestParam(value = "name") String name);
}

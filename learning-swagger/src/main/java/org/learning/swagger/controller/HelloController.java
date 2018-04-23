package org.learning.swagger.controller;

import org.learning.swagger.beans.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/swagger")
@Api(value = "Swagger UI test")
public class HelloController {
	@ApiOperation(value = "sayHello API", notes = "say hello to someone")
	@RequestMapping(method = RequestMethod.GET, value = "/hello/{name}")
	@ResponseBody
	public Response sayHello(@PathVariable(value = "name", required = true) String name) {
		return new Response("SUCCESS", "Hello," + name);
	}
}

package com.learning.boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.boot.core.AppVariable;

@Controller
public class HelloWorld {
	@Autowired
	private AppVariable resource;

	@RequestMapping("/")
	@ResponseBody
	String home(HttpServletRequest request) {
		return "Hello World, " + resource.getPomPropertiesPath() + "!";
	}
}
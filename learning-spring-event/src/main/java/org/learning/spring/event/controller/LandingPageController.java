package org.learning.spring.event.controller;

import org.learning.spring.event.AccessedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandingPageController {
	@Autowired
	private ApplicationContext applicationContext;

	@RequestMapping(value = { "/", "index", "index.html" })
	public String index(Model model) {
		applicationContext.publishEvent(new AccessedEvent("I am from index."));
		return "landingpage/index";
	}
}

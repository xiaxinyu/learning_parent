package com.learning.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandingPageController {
	@RequestMapping(value = "/h5")
	public String index(Model model) {
		return "landingpage/index";
	}
}

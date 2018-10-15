package com.spring.resolver.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.resolver.exception.HelloException;
import com.spring.resolver.exception.WorldException;
import com.spring.resolver.service.HomeService;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private HomeService homeService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Locale locale, Model model) throws HelloException {
		logger.info("Welcome home! The client locale is {}.", locale);
		homeService.sayHello();
		return "home";
	}

	@RequestMapping(value = "/world", method = RequestMethod.GET)
	public String world(Locale locale, Model model) throws WorldException {
		logger.info("Welcome home! The client locale is {}.", locale);
		homeService.sayWorld();
		return "home";
	}
}

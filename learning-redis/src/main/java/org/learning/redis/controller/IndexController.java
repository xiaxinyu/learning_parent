package org.learning.redis.controller;

import javax.servlet.http.HttpServletRequest;

import org.learning.redis.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class IndexController {
	private final Gson gson = new GsonBuilder().setDateFormat("yyyyMMddHHmmss").create();

	@RequestMapping(value = "/login/{username}", method = RequestMethod.GET)
	public String login(HttpServletRequest request, @PathVariable("username") String username) {
		request.getSession().setAttribute("user", gson.toJson(new User(username, "123456")));
		return "login";
	}

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, Model model) {
		User user = gson.fromJson(request.getSession().getAttribute("user").toString(), User.class);
		if (user != null) {
			model.addAttribute("user", user);
			return "index";
		} else {
			return "error";
		}
	}
}
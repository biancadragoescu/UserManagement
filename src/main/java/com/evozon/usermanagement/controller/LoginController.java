package com.evozon.usermanagement.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.evozon.usermanagement.data.User;
import com.evozon.usermanagement.service.ILoginService;

@Controller
public class LoginController {	
	@Autowired
	ILoginService loginService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginSubmit(@ModelAttribute User user){
		if (loginService.authenticateUser(user.getUserName(), user.getPassword()))
			return "success";
		return "failure";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String example(@RequestParam String str, Model model) {
		model.addAttribute("str", str);
		return "test";
	}
	
	@RequestMapping(value = "/test/{str}", method = RequestMethod.GET)
	public String example2(@PathVariable String str, Model model) {
		model.addAttribute("str", str);
		return "test";
	}
	
	
	
}

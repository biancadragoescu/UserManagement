package com.evozon.usermanagement.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.evozon.usermanagement.data.User;
import com.evozon.usermanagement.service.ILoginService;

@Controller
public class LoginController {		
	
	@Autowired
	ILoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		User user = new User();
		
		model.addAttribute("user", user);
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginSubmit(@ModelAttribute User user, Model model){
		String userName = user.getUserName();
		String password = user.getPassword();
		
		model.addAttribute("userName", userName);
		if (loginService.authenticateUser(userName, password)){
			return "success";
		}
		return "failure";
	}	
	
}

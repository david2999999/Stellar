package com.stellar.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stellar.spring.service.UserService;

@Controller
public class IndexController {
	
	UserService UserService;
	
	@Autowired
	public IndexController(UserService userService) {
		UserService = userService;
	}


	@RequestMapping({"", "/", "/index"})
	public String getIndexPage(Model model) {
		
		model.addAttribute("user", UserService.getUsers());
		
		return "index";
	}

}

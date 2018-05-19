package com.stellar.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.stellar.spring.domain.User;

@Controller
public class UserController {

	@GetMapping("/user/{id}/update")
	public String editUserForm() {
		return "/forms/EditUserForm";
	}
	
	@GetMapping("/user/new")
	public String createUserForm(Model model) {
		model.addAttribute("user", new User());
		
		return "/forms/CreateUserForm";
	}
	
	
}

package com.stellar.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/user/{id}/update")
	public String editUserForm() {
		return "/forms/EditUserForm";
	}
	
	@GetMapping("/user/new")
	public String createUserForm() {
		return "/forms/CreateUserForm";
	}
}

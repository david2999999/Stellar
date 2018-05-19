package com.stellar.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.stellar.spring.domain.User;
import com.stellar.spring.service.TaskService;

@Controller
public class UserController {
	
	@Autowired
	private TaskService taskService;

	@GetMapping("/user/{id}/update")
	public String editUserForm(Model model) {
		
		model.addAttribute("tasks", taskService.getTasks());
		
		return "/forms/EditUserForm";
	}
	
	@GetMapping("/user/new")
	public String createUserForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("tasks", taskService.getTasks());
		return "/forms/CreateUserForm";
	}
	
	
}

package com.stellar.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

	@GetMapping("/task/{id}/update")
	public String editUserForm() {
		return "/forms/EditTaskForm";
	}
	
	@GetMapping("/task/new")
	public String createTaskForm() {
		return "/forms/CreateTaskForm";
	}
}

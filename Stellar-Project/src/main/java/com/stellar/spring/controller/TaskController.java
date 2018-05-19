package com.stellar.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.stellar.spring.domain.Task;

@Controller
public class TaskController {

	@GetMapping("/task/{id}/update")
	public String editUserForm() {
		return "/forms/EditTaskForm";
	}
	
	@GetMapping("/task/new")
	public String createTaskForm(Model model) {
		model.addAttribute("task", new Task());
		
		return "/forms/CreateTaskForm";
	}
}

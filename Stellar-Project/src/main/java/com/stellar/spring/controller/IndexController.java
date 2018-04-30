package com.stellar.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stellar.spring.service.TaskService;
import com.stellar.spring.service.UserService;

@Controller
public class IndexController {
	
	private UserService userService;
	private TaskService taskService;
	
	public IndexController(UserService userService, TaskService taskService) {
		this.userService = userService;
		this.taskService = taskService;
	}

	@RequestMapping({"", "/"})
	public String getIndexPage(Model model) {
		
		model.addAttribute("users", userService.getUsers());
		model.addAttribute("tasks", taskService.getTasks());
		
		return "index";
	}

}

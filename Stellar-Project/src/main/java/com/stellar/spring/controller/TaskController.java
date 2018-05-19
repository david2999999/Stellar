package com.stellar.spring.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stellar.spring.domain.Task;
import com.stellar.spring.service.ImageService;
import com.stellar.spring.service.TaskService;

@Controller
public class TaskController {

	private final TaskService taskService;
	
	private final ImageService imageService;
	
	@Autowired
	public TaskController(TaskService taskService, ImageService imageService) {
		this.taskService = taskService;
		this.imageService = imageService;
	}

	@GetMapping("/task/{id}/update")
	public String editUserForm() {
		return "/forms/EditTaskForm";
	}
	
	@GetMapping("/task/new")
	public String createTaskForm(Model model) {
		model.addAttribute("task", new Task());
		
		return "/forms/CreateTaskForm";
	}
	
	@PostMapping("create-task")
	public String createTask(@Valid @ModelAttribute("task") Task task) {
		task.setImage(imageService.randomImage());
		this.taskService.saveTask(task);
		
		return "redirect:/";
	}
}

package com.stellar.spring.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stellar.spring.domain.Task;
import com.stellar.spring.exceptions.NotFoundException;
import com.stellar.spring.repositories.TaskRepository;


@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Set<Task> getTasks() {
		Set<Task> tasks = new HashSet<>();
		
		taskRepository.findAll().iterator().forEachRemaining(tasks::add);
		
		return tasks;
	}

	@Override
	public Task findById(Long id) {
		Optional<Task> taskOptional = taskRepository.findById(id);
		
		if(!taskOptional.isPresent()) {
			throw new NotFoundException("Task Not Found With Id: " + id);
		}
		return taskOptional.get();
	}

	@Override
	public Task saveTask(Task task) {
		Task savedTask = taskRepository.save(task);
		
		return savedTask;
	}

}

package com.stellar.spring.service;

import java.util.Set;

import com.stellar.spring.domain.Task;

public interface TaskService {

	Set<Task> getTasks();
	
	Task findById(Long id);
	
	Task saveTask(Task task);
}

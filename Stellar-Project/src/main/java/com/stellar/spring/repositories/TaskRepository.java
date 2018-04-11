package com.stellar.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.stellar.spring.domain.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{
	
//	Optional<Task> findByDescription(String description);

}

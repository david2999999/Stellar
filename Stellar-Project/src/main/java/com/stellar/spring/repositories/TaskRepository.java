package com.stellar.spring.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.stellar.spring.domain.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{
	
	Optional<Task> findByDescription(String description);

}

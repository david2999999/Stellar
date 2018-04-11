package com.stellar.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.stellar.spring.domain.Email;

public interface EmailRepository extends CrudRepository<Email, Long>{

}

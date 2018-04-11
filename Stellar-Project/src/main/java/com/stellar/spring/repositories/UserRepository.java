package com.stellar.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.stellar.spring.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}

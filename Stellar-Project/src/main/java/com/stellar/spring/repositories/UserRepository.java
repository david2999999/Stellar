package com.stellar.spring.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.stellar.spring.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}

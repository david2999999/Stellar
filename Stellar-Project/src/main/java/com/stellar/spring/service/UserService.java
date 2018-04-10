package com.stellar.spring.service;

import java.util.Set;

import com.stellar.spring.domain.User;

public interface UserService {
	
	Set<User> getUsers();
	
	User findById(Long id);
	
	User saveUser(User user);
}

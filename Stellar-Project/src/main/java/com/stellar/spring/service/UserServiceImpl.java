package com.stellar.spring.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stellar.spring.domain.User;
import com.stellar.spring.exceptions.NotFoundException;
import com.stellar.spring.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Set<User> getUsers() {
		Set<User> users = new HashSet<>();
		
		userRepository.findAll().iterator().forEachRemaining(users::add);
		
		return users;
	}

	@Override
	public User findById(Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new NotFoundException("User Not Found with Id: " + id);
		}
		
		return userOptional.get();
	}

	@Override
	public User saveUser(User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}

}

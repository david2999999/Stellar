package com.stellar.spring.bootstrap;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.stellar.spring.domain.Email;
import com.stellar.spring.domain.Image;
import com.stellar.spring.domain.Role;
import com.stellar.spring.domain.Task;
import com.stellar.spring.domain.User;
import com.stellar.spring.repositories.ImageRepository;
import com.stellar.spring.repositories.TaskRepository;
import com.stellar.spring.repositories.UserRepository;

@Component
public class AppBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private final UserRepository userRepository;
	private final TaskRepository taskRepository;
	private final ImageRepository imageRepository;
	
	public AppBootstrap(UserRepository userRepository, TaskRepository taskRepository, ImageRepository imageRepository) {
		this.userRepository = userRepository;
		this.taskRepository = taskRepository;
		this.imageRepository = imageRepository;
	}

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		userRepository.saveAll(getUsers());
	}
	
	public List<User> getUsers() {
		List<User> users = new ArrayList<>(2);
		
		// get images from database
		Optional<Image> fontUnderlineOptional = imageRepository.findByUrl("icon-software-font-underline");
		
		if(!fontUnderlineOptional.isPresent()) {
			throw new RuntimeException("Expected Image not found");
		}
		
		Optional<Image> horizontalAlignCenterOptional = imageRepository.findByUrl("icon-software-horizontal-align-center");
		
		if(!horizontalAlignCenterOptional.isPresent()) {
			throw new RuntimeException("Expected Image not found");
		}
		
		Optional<Image> layer2Optional = imageRepository.findByUrl("icon-software-layers2");
		
		if(!layer2Optional.isPresent()) {
			throw new RuntimeException("Expected Image not found");
		}
		
		Optional<Image> horiontalAlignLeftOptional = imageRepository.findByUrl("icon-software-horizontal-align-left");
		
		if(!horiontalAlignLeftOptional.isPresent()) {
			throw new RuntimeException("Expected Image not found");
		}
		
		Optional<Image> indentLeftOptional = imageRepository.findByUrl("icon-software-indent-left");
		
		if(!indentLeftOptional.isPresent()) {
			throw new RuntimeException("Expected Image not found");
		}
		
		Optional<Image> verticalAlignBottomOptional = imageRepository.findByUrl("icon-software-vertical-align-bottom");
		
		if(!verticalAlignBottomOptional.isPresent()) {
			throw new RuntimeException("Expected Image not found");
		}
		
		Optional<Image> header4BoxesOptional = imageRepository.findByUrl("icon-software-layout-header-4boxes");
		
		if(!header4BoxesOptional.isPresent()) {
			throw new RuntimeException("Expected Image not found");
		}
		
		Optional<Image> verticalDistributeBottomOptional = imageRepository.findByUrl("icon-software-vertical-distribute-bottom");
		
		if(!verticalDistributeBottomOptional.isPresent()) {
			throw new RuntimeException("Expected Image not found");
		}
		
		Optional<Image> penOptional = imageRepository.findByUrl("icon-software-pen");
		
		if(!penOptional.isPresent()) {
			throw new RuntimeException("Expected Image not found");
		}
		
		Image fontUnderline = fontUnderlineOptional.get();
		Image horizontalAlignCenter = horizontalAlignCenterOptional.get();
		Image layer2 = layer2Optional.get();
		Image horizontalAlignLeft = horiontalAlignLeftOptional.get();
		Image indentLeft = indentLeftOptional.get();
		Image verticalAlignBottom = verticalAlignBottomOptional.get();
		Image header4Boxes = header4BoxesOptional.get();
		Image softwarePen = penOptional.get();
		
		// CREATING USERS 
		Task task = new Task();
		task.setTitle("HTML/CSS");
		task.setDetail("Create Front page of Website, deciding on User interfaces such as color theme and layout");
		task.setCreatedDate("January 11 2018");
		task.setDueDate("February 21 2018");
		task.setImage(fontUnderline);
		
		Email email = new Email();
		email.setUrl("tchris@gmail.com");
		
		Role role = new Role();
		role.setDescription("FRONT-END DEVELOPER");
		
		User user = new User();
		user.setFirstName("Christopher");
		user.setLastName("T.");
		user.setEmail(email);
		user.setRole(role);
		user.setTask(task);
		user.setImage(softwarePen);
		
		users.add(user);
		
		// CREATING USERS 
		Task task1 = new Task();
		task1.setTitle("BACKBONEJS");
		task1.setDetail("Using the models, create a view using the template and then inject the views with attributes of the models.");
		task1.setCreatedDate("April 11 2018");
		task1.setDueDate("May 21 2018");
		task1.setImage(horizontalAlignCenter);
		
		Email email1 = new Email();
		email1.setUrl("jsmith@yahoo.com");
		
		Role role1 = new Role();
		role1.setDescription("FULL STACK DEVELOPER");
		
		User user1 = new User();
		user1.setFirstName("JOHN");
		user1.setLastName("SMITH");
		user1.setEmail(email1);
		user1.setRole(role1);
		user1.setTask(task1);
		user1.setImage(softwarePen);
		
		users.add(user1);
		
		// CREATING USERS 
		Task task2 = new Task();
		task2.setTitle("JAVA");
		task2.setDetail("Connect the website to the database, which will be used to persist data of models and users");
		task2.setCreatedDate("April 11 2018");
		task2.setDueDate("April 21 2018");
		task2.setImage(layer2);
		
		Email email2 = new Email();
		email2.setUrl("schristy@gmail.com");
		
		User user2 = new User();
		user2.setFirstName("Christy");
		user2.setLastName("Su");
		user2.setEmail(email2);
		user2.setRole(role);
		user2.setTask(task);
		user2.setImage(softwarePen);
		
		users.add(user2);
		

		

		
		return users;
	}

	
}












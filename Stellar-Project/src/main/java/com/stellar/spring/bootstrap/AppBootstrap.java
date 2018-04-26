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
		user.setTaskAssigned("February 10 2018");
		
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
		user1.setTaskAssigned("April 22 2018");
		
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
		user2.setTaskAssigned("April 18 2018");
		
		users.add(user2);
		
		// creating user 
		Task task3 = new Task();
		task3.setTitle("JAVASCRIPT");
		task3.setDetail("Create, Read, Update, Delete users and tasks");
		task3.setCreatedDate("August 26 2018");
		task3.setDueDate("September 30 2018");
		task3.setImage(horizontalAlignLeft);
		
		Role role2 = new Role();
		role2.setDescription("BACK-END DEVELOPER");
		
		Email email3 = new Email();
		email3.setUrl("msamual@google.com");
		
		User user3 = new User();
		user3.setFirstName("Samuel");
		user3.setLastName("Ma");
		user3.setEmail(email3);
		user3.setRole(role2);
		user3.setTask(task3);
		user3.setImage(softwarePen);
		user3.setTaskAssigned("September 1 2018");
		
		users.add(user3);
		
		// creating user
		Task task4 = new Task();
		task4.setTitle("NODEJS");
		task4.setDetail("Responsible for writing server-side web application logic in JavaScript and/or variants of it, such as CoffeeScript, IcedCoffeeScript.");
		task4.setCreatedDate("May 26 2018");
		task4.setDueDate("June 30 2018");
		task4.setImage(indentLeft);
		
		Email email4 = new Email();
		email4.setUrl("jlouis@google.com");
		
		User user4 = new User();
		user4.setFirstName("Louis");
		user4.setLastName("Jeffer");
		user4.setEmail(email4);
		user4.setRole(role);
		user4.setTask(task4);
		user4.setImage(softwarePen);
		user4.setTaskAssigned("June 21 2018");
		
		users.add(user4);
		
		
		// creating user
		Task task5 = new Task();
		task5.setTitle("MONGODB");
		task5.setDetail("MongoDB developers who use the program regularly should have an idea of how to do specific commands. There are some of more common ones that they should be able to talk about, including collection commands.");
		task5.setCreatedDate("May 22 2018");
		task5.setDueDate("July 30 2018");
		task5.setImage(verticalAlignBottom);
		
		Email email5 = new Email();
		email5.setUrl("slia@google.com");
		
		User user5 = new User();
		user5.setFirstName("Lia");
		user5.setLastName("Smith");
		user5.setEmail(email5);
		user5.setRole(role1);
		user5.setTask(task5);
		user5.setImage(softwarePen);
		user5.setTaskAssigned("July 20 2018");
		
		users.add(user5);
		

		
		return users;
	}

	
}












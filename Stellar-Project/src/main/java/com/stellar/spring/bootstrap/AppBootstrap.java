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
		user.setImage(fontUnderline);
		
		users.add(user);
		
		return users;
	}

	
}












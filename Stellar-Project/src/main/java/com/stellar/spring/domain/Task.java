package com.stellar.spring.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String description;
	
	private String detail;
	
	private Date createdDate;
	
	private Date dueDate;
	
	@OneToOne
	private Image image;
	
	@OneToMany(mappedBy="task")
	private List<User> users;

}










package com.stellar.spring.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="detail")
	private String detail;
	
	@Column(name="createdDate")
	private Date createdDate;
	
	@Column(name="dueDate")
	private Date dueDate;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@OneToMany(mappedBy="task")
	private List<User> users;

}










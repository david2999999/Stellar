package com.stellar.spring.domain;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String firstName;

	private String lastName;

	private String email;

	@OneToOne
	private Role role;

	@ManyToOne
	private Task task;

	@OneToOne
	private Image imageUrl;
	
	
	
}

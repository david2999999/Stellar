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

	@OneToOne(cascade=CascadeType.ALL)
	private Email email;

	@OneToOne(cascade=CascadeType.ALL)
	private Role role;

	@ManyToOne(cascade=CascadeType.ALL)
	private Task task;

	@OneToOne(cascade=CascadeType.ALL)
	private Image image;
	
}

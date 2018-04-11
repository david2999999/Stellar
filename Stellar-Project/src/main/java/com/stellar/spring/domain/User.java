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

	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private Email email;

	@OneToOne(cascade=CascadeType.PERSIST)
	private Role role;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Task task;

	@OneToOne(cascade=CascadeType.PERSIST)
	private Image image;
	
}

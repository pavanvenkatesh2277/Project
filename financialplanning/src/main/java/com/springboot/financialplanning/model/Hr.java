package com.springboot.financialplanning.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Entity
public class Hr {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty(message = "Name is mandatory")
	private String name;
	@NotEmpty(message = "Email is mandatory")
	private String email;
	@Size(min=10, max=10)
	private String phoneNumber;
	
	@OneToOne
	private User user;

	public Hr() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hr(int id, @NotEmpty(message = "Name is mandatory") String name,
			@NotEmpty(message = "Email is mandatory") String email, @Size(min = 10, max = 10) String phoneNumber,
			User user) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Hr [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", user="
				+ user + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}

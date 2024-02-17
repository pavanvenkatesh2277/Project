package com.springboot.financialplanning.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Name is mandatory")
	private String name; 
	@NotBlank(message = "Email is mandatory")
	private String email;
	private String fundtype;
	private String address;
	@Size(min=10, max=10)
	private String contact;

	@OneToOne
	private User user;

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(int id, @NotBlank(message = "Name is mandatory") String name,
			@NotBlank(message = "Email is mandatory") String email, String fundtype, String address,
			@Size(min = 10, max = 10) String contact, User user) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.fundtype = fundtype;
		this.address = address;
		this.contact = contact;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", email=" + email + ", fundtype=" + fundtype + ", address="
				+ address + ", contact=" + contact + ", user=" + user + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
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

	public String getFundtype() {
		return fundtype;
	}

	public void setFundtype(String fundtype) {
		this.fundtype = fundtype;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	

}
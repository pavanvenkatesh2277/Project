package com.springboot.financialplanning.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
public class Investor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty(message = "firstname is mandatory")
	private String firstname;
	@NotEmpty(message = "lastname is mandatory")
	private String lastname;
	@NotEmpty(message = "email is mandatory")
	private String email;
	private String city;
	private LocalDate dob;
	@NotEmpty(message = "pancardNumber is mandatory")
	private String pancardNumber;
	@NotEmpty(message = "gender is mandatory")
	private String gender;
	@NotEmpty(message = "contactNumber is mandatory")
	@Size(min=10, max=10)
	private String contactNumber;
	@NotEmpty(message = "accountNumber is mandatory")
	@Size(min=10, max=14)
	private String accountNumber;
	@NotEmpty(message = "ifscCode is mandatory")
	@Size(min=9, max=11)
	private String ifscCode;
	@OneToOne
	private User user;
	public Investor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Investor(int id, @NotEmpty(message = "firstname is mandatory") String firstname,
			@NotEmpty(message = "lastname is mandatory") String lastname,
			@NotEmpty(message = "email is mandatory") String email, String city, @NotEmpty(message = "pancardNumber is mandatory") String pancardNumber,
			@NotEmpty(message = "gender is mandatory") String gender,
			@NotEmpty(message = "contactNumber is mandatory") @Size(min = 10, max = 10) String contactNumber,
			@NotEmpty(message = "accountNumber is mandatory") @Size(min = 10, max = 14) String accountNumber) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.city = city;
		this.dob = dob;
		this.pancardNumber = pancardNumber;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Investor [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", city=" + city + ", dob=" + dob + ", pancardNumber=" + pancardNumber + ", gender=" + gender
				+ ", contactNumber=" + contactNumber + ", accountNumber=" + accountNumber + ", ifscCode=" + ifscCode
				+ ", user=" + user + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getPancardNumber() {
		return pancardNumber;
	}
	public void setPancardNumber(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}

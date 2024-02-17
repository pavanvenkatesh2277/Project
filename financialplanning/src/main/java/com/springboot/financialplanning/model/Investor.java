package com.springboot.financialplanning.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Investor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String city;
	private LocalDate dob;
	private String pancardNumber;
	private String gender;
	private String contactNumber;
	private String accountNumber;
	private String ifscCode;
	@OneToOne
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Investor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Investor(int id, String firstname, String lastname, String email, String city, String pancardNumber, String gender, String contactNumber, String accountNumber) {
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
	}
	@Override
	public String toString() {
		return "Investor [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", city=" + city + ", dob=" + dob + ", pancardNumber=" + pancardNumber + ", gender=" + gender
				+ ", contactNumber=" + contactNumber + ", accountNumber=" + accountNumber + ", ifscCode=" + ifscCode
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
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
	
	


}

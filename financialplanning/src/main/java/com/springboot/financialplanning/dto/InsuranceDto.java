package com.springboot.financialplanning.dto;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class InsuranceDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String category;
	private LocalDate startdate;
	private LocalDate enddate;
	private double premimum;
	private int policytenure;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public LocalDate getStartdate() {
		return startdate;
	}
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	public LocalDate getEnddate() {
		return enddate;
	}
	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}
	public double getPremimum() {
		return premimum;
	}
	public void setPremimum(double premimum) {
		this.premimum = premimum;
	}
	public int getPolicytenure() {
		return policytenure;
	}
	public void setPolicytenure(int policytenure) {
		this.policytenure = policytenure;
	}
	
	
}

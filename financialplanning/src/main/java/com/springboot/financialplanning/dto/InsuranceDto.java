package com.springboot.financialplanning.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.enums.Category;

public class InsuranceDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String policyName;
	@Enumerated(EnumType.STRING)
	private Category category;
	private double premium;
	private int policyTenure;
	private String claimSettlement;
	private String description;
	private String ageCreteria;
	private double coverage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public int getPolicyTenure() {
		return policyTenure;
	}
	public void setPolicyTenure(int policyTenure) {
		this.policyTenure = policyTenure;
	}
	public String getClaimSettlement() {
		return claimSettlement;
	}
	public void setClaimSettlement(String claimSettlement) {
		this.claimSettlement = claimSettlement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAgeCreteria() {
		return ageCreteria;
	}
	public void setAgeCreteria(String ageCreteria) {
		this.ageCreteria = ageCreteria;
	}
	public double getCoverage() {
		return coverage;
	}
	public void setCoverage(double coverage) {
		this.coverage = coverage;
	}
	
}

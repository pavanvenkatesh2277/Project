package com.springboot.financialplanning.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.enums.Category;
import com.enums.RickFactor;
@Entity
public class ThematicFund {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty(message = "FundName is mandatory")
	private String fundName;
	@Enumerated(EnumType.STRING)
	private Category category;
	private double fundSize;
	@Enumerated(EnumType.STRING)
	private RickFactor riskFactor;
	@NotEmpty(message = "returnFactor is mandatory")
	private String returnFactor;
	@NotEmpty(message = "expectedReturns is mandatory")
	private String expectedReturns;
	@NotEmpty(message = "lockingPeriod is mandatory")
	private String lockingPeriod;
	private double minInvenstmentAmount;
	private double navPrice;
	
	@ManyToOne
	private Company company;

	public ThematicFund() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThematicFund(int id, @NotEmpty(message = "FundName is mandatory") String fundName, Category category,
			double fundSize, RickFactor riskFactor,
			@NotEmpty(message = "returnFactor is mandatory") String returnFactor,
			@NotEmpty(message = "expectedReturns is mandatory") String expectedReturns,
			@NotEmpty(message = "lockingPeriod is mandatory") String lockingPeriod, double minInvenstmentAmount,
			double navPrice, Company company) {
		super();
		this.id = id;
		this.fundName = fundName;
		this.category = category;
		this.fundSize = fundSize;
		this.riskFactor = riskFactor;
		this.returnFactor = returnFactor;
		this.expectedReturns = expectedReturns;
		this.lockingPeriod = lockingPeriod;
		this.minInvenstmentAmount = minInvenstmentAmount;
		this.navPrice = navPrice;
		this.company = company;
	}

	@Override
	public String toString() {
		return "ThematicFund [id=" + id + ", fundName=" + fundName + ", category=" + category + ", fundSize=" + fundSize
				+ ", riskFactor=" + riskFactor + ", returnFactor=" + returnFactor + ", expectedReturns="
				+ expectedReturns + ", lockingPeriod=" + lockingPeriod + ", minInvenstmentAmount="
				+ minInvenstmentAmount + ", navPrice=" + navPrice + ", company=" + company + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getFundSize() {
		return fundSize;
	}

	public void setFundSize(double fundSize) {
		this.fundSize = fundSize;
	}

	public RickFactor getRiskFactor() {
		return riskFactor;
	}

	public void setRiskFactor(RickFactor riskFactor) {
		this.riskFactor = riskFactor;
	}

	public String getReturnFactor() {
		return returnFactor;
	}

	public void setReturnFactor(String returnFactor) {
		this.returnFactor = returnFactor;
	}

	public String getExpectedReturns() {
		return expectedReturns;
	}

	public void setExpectedReturns(String expectedReturns) {
		this.expectedReturns = expectedReturns;
	}

	public String getLockingPeriod() {
		return lockingPeriod;
	}

	public void setLockingPeriod(String lockingPeriod) {
		this.lockingPeriod = lockingPeriod;
	}

	public double getMinInvenstmentAmount() {
		return minInvenstmentAmount;
	}

	public void setMinInvenstmentAmount(double minInvenstmentAmount) {
		this.minInvenstmentAmount = minInvenstmentAmount;
	}

	public double getNavPrice() {
		return navPrice;
	}

	public void setNavPrice(double navPrice) {
		this.navPrice = navPrice;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	
}

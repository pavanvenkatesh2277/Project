package com.springboot.financialplanning.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.enums.RickFactor;

public class MutualFundDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String category;
	private double fundBalance;
	private RickFactor riskFactor;
	private String returnFactor;
	private String expectedReturns;
	private String lockingPeriod;
	private double minInvenstmentAmount;
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
	public double getFundBalance() {
		return fundBalance;
	}
	public void setFundBalance(double fundBalance) {
		this.fundBalance = fundBalance;
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
}

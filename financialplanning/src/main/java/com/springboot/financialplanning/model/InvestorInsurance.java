package com.springboot.financialplanning.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.enums.InvestmentType;



@Entity
public class InvestorInsurance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private LocalDate investmentDate;
	private Double yearlyAmount;
	private Double monthlyAmount;
	private LocalDate monthlyInvestmentDate;
	

	@Enumerated(EnumType.STRING)
	private InvestmentType investmentType;
	
	
	@ManyToOne
	private Investor investor;
	
	@ManyToOne
	private Insurance insurance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Investor getInvestor() {
		return investor;
	}

	public void setInvestor(Investor investor) {
		this.investor = investor;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public LocalDate getInvestmentDate() {
		return investmentDate;
	}

	public void setInvestmentDate(LocalDate investmentDate) {
		this.investmentDate = investmentDate;
	}

	public Double getYearlyAmount() {
		return yearlyAmount;
	}

	public void setYearlyAmount(Double yearlyAmount) {
		this.yearlyAmount = yearlyAmount;
	}

	public Double getMonthlyAmount() {
		return monthlyAmount;
	}

	public void setMonthlyAmount(Double monthlyAmount) {
		this.monthlyAmount = monthlyAmount;
	}

	public LocalDate getMonthlyInvestmentDate() {
		return monthlyInvestmentDate;
	}

	public void setMonthlyInvestmentDate(LocalDate monthlyInvestmentDate) {
		this.monthlyInvestmentDate = monthlyInvestmentDate;
	}

	public InvestmentType getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(InvestmentType investmentType) {
		this.investmentType = investmentType;
	}
	
	
}


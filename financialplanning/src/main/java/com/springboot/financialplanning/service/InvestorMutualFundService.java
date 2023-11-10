package com.springboot.financialplanning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.financialplanning.model.InvestorMutualFund;
import com.springboot.financialplanning.repository.InvestorMutualFundRepository;



@Service
public class InvestorMutualFundService {

	@Autowired
	InvestorMutualFundRepository investorMutualFundRepository;
	
	public InvestorMutualFund insert(InvestorMutualFund investorMutualFund) {
		return investorMutualFundRepository.save(investorMutualFund);
	}

}
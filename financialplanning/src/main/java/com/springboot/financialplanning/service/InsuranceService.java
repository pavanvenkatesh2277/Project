package com.springboot.financialplanning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.financialplanning.model.Insurance;
import com.springboot.financialplanning.repository.InsuranceRepository;



@Service
public class InsuranceService {

	@Autowired
	private InsuranceRepository insuranceRepository;

	public Insurance insert(Insurance insurance) {
		return insuranceRepository.save(insurance);
	}
}


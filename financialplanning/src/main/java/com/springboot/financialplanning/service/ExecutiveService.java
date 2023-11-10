package com.springboot.financialplanning.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.financialplanning.exception.InvalidIdException;
import com.springboot.financialplanning.model.Executive;
import com.springboot.financialplanning.repository.ExecutiveRepository;


@Service
public class ExecutiveService {
	@Autowired
	ExecutiveRepository executiveRepository;
	
	public Executive insert(Executive executive) {
		return executiveRepository.save(executive);
	}
	public Executive saveExecutive(Executive executive) {
		return executiveRepository.save(executive);
	}

	public Executive getById(int uid) throws InvalidIdException {
		Optional<Executive> optional=executiveRepository.findById(uid);
		if(!optional.isPresent())
			throw new InvalidIdException("Userid Invalid");
		return optional.get();
	}

}
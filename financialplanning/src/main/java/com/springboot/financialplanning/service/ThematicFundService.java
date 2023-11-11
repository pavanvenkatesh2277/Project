package com.springboot.financialplanning.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.financialplanning.exception.InvalidIdException;
import com.springboot.financialplanning.model.MutualFund;
import com.springboot.financialplanning.model.ThematicFund;
import com.springboot.financialplanning.repository.ThematicFundRepository;



@Service
public class ThematicFundService {

	@Autowired
	private ThematicFundRepository thematicFundRepository;
	
	public ThematicFund insert(ThematicFund thematicFund) {
		return thematicFundRepository.save(thematicFund);
	}

	public ThematicFund getByid(int tid) throws InvalidIdException {
		Optional<ThematicFund> optional = thematicFundRepository.findById(tid);
		if (!optional.isPresent())
			throw new InvalidIdException("ThematicFund id Invalid");
		return optional.get();
	}

}
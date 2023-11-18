package com.springboot.financialplanning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enums.Category;
import com.springboot.financialplanning.dto.SearchResultDto;
import com.springboot.financialplanning.model.Insurance;
import com.springboot.financialplanning.model.MutualFund;
import com.springboot.financialplanning.model.ThematicFund;
import com.springboot.financialplanning.repository.InsuranceRepository;
import com.springboot.financialplanning.repository.MutualFundRepository;
import com.springboot.financialplanning.repository.ThematicFundRepository;

@Service
public class SearchService {
	  @Autowired
	    private MutualFundRepository mutualFundRepository;

	    @Autowired
	    private ThematicFundRepository thematicFundRepository;

	    @Autowired
	    private InsuranceRepository insuranceRepository;

	    public SearchResultDto searchByCompanyName(String Name) {
	        List<MutualFund> mutualFunds = mutualFundRepository.findByCompany(Name);
	        List<ThematicFund> thematicFunds = thematicFundRepository.findByCompany(Name);
	        List<Insurance> insurances = insuranceRepository.findByCompany(Name);

	        return new SearchResultDto(mutualFunds, thematicFunds, insurances);
	    }
//
//	    public SearchResultDto searchByFundType(String fundType) {
//	        List<MutualFund> mutualFunds = mutualFundRepository.findByFundType(fundType);
//	        List<ThematicFund> thematicFunds = thematicFundRepository.findByFundType(fundType);
//	        List<Insurance> insurances = insuranceRepository.findByFundType(fundType);
//
//	        return new SearchResultDto(mutualFunds, thematicFunds, insurances);
//	    }

	    public SearchResultDto searchByCategory(Category category) {
	        List<MutualFund> mutualFunds = mutualFundRepository.findByCategory(category);
	        List<ThematicFund> thematicFunds = thematicFundRepository.findByCategory(category);
	        List<Insurance> insurances = insuranceRepository.findByCategory(category);

	        return new SearchResultDto(mutualFunds, thematicFunds, insurances);
	    }

}

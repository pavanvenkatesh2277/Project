package com.springboot.financialplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.financialplanning.exception.InvalidIdException;
import com.springboot.financialplanning.model.Company;
import com.springboot.financialplanning.model.MutualFund;
import com.springboot.financialplanning.service.CompanyService;
import com.springboot.financialplanning.service.MutualFundService;



@RestController
@RequestMapping("/mutualfund")
public class MutualFundController {
	
	@Autowired
	private MutualFundService mutualFundService;
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/add/{cid}")
	public ResponseEntity<?> insertMutualFund(@PathVariable ("cid") int cid,@RequestBody MutualFund mutualFund) {
			try {
				
				Company company = companyService.getCompanyById(cid);
				mutualFund.setCompany(company);
				MutualFund savedMutualFund = mutualFundService.insert(mutualFund);
				return ResponseEntity.ok().body(savedMutualFund);
			}
			catch(InvalidIdException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
	}
}


package com.springboot.financialplanning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.financialplanning.exception.InvalidIdException;
import com.springboot.financialplanning.model.Company;
import com.springboot.financialplanning.model.ThematicFund;
import com.springboot.financialplanning.service.CompanyService;
import com.springboot.financialplanning.service.ThematicFundService;



@RestController
@RequestMapping("/thematic")
public class ThematicFundController {

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private ThematicFundService thematicFundService;
	 
	@PostMapping("/add/{cid}")
	public ResponseEntity<?> insertThematicFund(@PathVariable ("cid") int cid,@RequestBody ThematicFund thematicFund) {
			try {
				
				Company company = companyService.getCompanyById(cid);
				thematicFund.setCompany(company);
				ThematicFund savedThematicFund = thematicFundService.insert(thematicFund);
				return ResponseEntity.ok().body(savedThematicFund);
			}
			catch(InvalidIdException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
	}
	
	@GetMapping("/all")
	public List<ThematicFund>getAllThematicFunds(){
		List<ThematicFund> list = thematicFundService.getAllThematicFunds();
		return list;
	}
	
	@GetMapping("/one/{cid}")
	public ResponseEntity<?> getThematicFundById(@PathVariable("cid") int cid) {
		try {
			ThematicFund thematicFund = thematicFundService.getThematicFundById(cid);
			return ResponseEntity.ok().body(thematicFund);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{cid}")
	public ResponseEntity<?> deleteThematicFund(@PathVariable("cid") int cid) {
		try {
			ThematicFund thematicFund =thematicFundService.getThematicFundById(cid);
			thematicFundService.deleteThematicFund(thematicFund.getId());
			return ResponseEntity.ok().body("ThematicFund Record deleted");
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@PutMapping("/update/{cid}")
	public ResponseEntity<?> updateThematicFund(@PathVariable("cid") int cid, 
			@RequestBody ThematicFund newthematicFund) {
		try {
			ThematicFund thematicFund = thematicFundService.getThematicFundById(cid);
			if(newthematicFund.getName() != null)
				thematicFund.setName(newthematicFund.getName());
			if(newthematicFund.getCategory() != null)
				thematicFund.setCategory(newthematicFund.getCategory());
			if(newthematicFund.getFundBalance() != 0)
				thematicFund.setFundBalance(newthematicFund.getFundBalance());
			if(newthematicFund.getReturnFactor() != null)
				thematicFund.setReturnFactor(newthematicFund.getReturnFactor());
			
			thematicFund = thematicFundService.insert(thematicFund);
			return ResponseEntity.ok().body(thematicFund);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

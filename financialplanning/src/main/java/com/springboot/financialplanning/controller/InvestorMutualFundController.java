package com.springboot.financialplanning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.financialplanning.dto.InvestorMutualFundDto;
import com.springboot.financialplanning.exception.InvalidIdException;
import com.springboot.financialplanning.model.Investor;
import com.springboot.financialplanning.model.InvestorMutualFund;
import com.springboot.financialplanning.model.MutualFund;
import com.springboot.financialplanning.service.InvestorMutualFundService;
import com.springboot.financialplanning.service.InvestorService;
import com.springboot.financialplanning.service.MutualFundService;



@RestController
public class InvestorMutualFundController {
	@Autowired
	private InvestorService investorService;

	@Autowired
	private MutualFundService mutualFundService;

	@Autowired
	private InvestorMutualFundService investorMutualFundService;
	
	
	/* Insert InvestorMutualFund Details By InvestorId and MutualFundId */
	@PostMapping("/mutualfund/add/{iid}/{mfid}")
	public ResponseEntity<?> mutualfund(@PathVariable("iid") int iid, @PathVariable("mfid") int mfid,
			@RequestBody InvestorMutualFund investorMutualFund) {
		try {
			Investor investor = investorService.getByInvestorId(iid);
			MutualFund mutualFund = mutualFundService.getByid(mfid);
			investorMutualFund.setInvestor(investor);
			investorMutualFund.setMutualFund(mutualFund);
			investorMutualFund = investorMutualFundService.insert(investorMutualFund);
			return ResponseEntity.ok().body(investorMutualFund);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	/* Get All MutualFundDetails Done by Investor*/
	@GetMapping("/mdall")
	public List<InvestorMutualFund> getAllMutualFund(
			@RequestParam(value="page",required = false,defaultValue = "0") Integer page,
			@RequestParam(value="size",required = false,defaultValue = "1000000") Integer size) {
		
		Pageable pageable =  PageRequest.of(page, size);
		return investorMutualFundService.getAllMutualFund(pageable);
	}
	
	/* Get All InvestorMutualFund Details By Id */
	@GetMapping("/mutualfunddetails/{iid}/{mfid}")
	public ResponseEntity<?> getInsuranceDetails(@PathVariable("iid") int iid,
			@PathVariable("mfid")int mfid) {
		
		try {
			/* Fetch Investor object using given iid */
			Investor investor = investorService.getByInvestorId(iid);
			/* Fetch MutualFund object using given mfid */
			MutualFund mutualFund=mutualFundService.getByid(mfid);
			List<InvestorMutualFund> list= investorMutualFundService.getMutualFundDetailsByIds(iid,mfid);
			return ResponseEntity.ok().body(list);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
	}
	

	/* Delete InvestorMutualFund By Id */
	@DeleteMapping("/delete/{mdid}")
	public ResponseEntity<?> deleteMutualFundDetails(@PathVariable("mdid") int mdid) {
		
		try {
			//validate id
			InvestorMutualFund investorMutualFund=investorMutualFundService.getByInvestorMutualFundId(mdid);
			//delete
			investorMutualFundService.deleteMutualFundDetails(investorMutualFund);
			return ResponseEntity.ok().body("MutualFundDetails deleted successfully");

		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	/* Update InvestorMutualFund By Id */
	@PutMapping("/updatemutualfund/{mdid}")  //:update: which record to update?   give me new value for update
	public ResponseEntity<?> updateInvestorMutualFund(@PathVariable("mdid") int mdid,
							@RequestBody InvestorMutualFundDto newInvestorMutualFund) {
		try {
			//validate id
			InvestorMutualFund oldInvestorMutualFund = investorMutualFundService.getByInvestorMutualFundId(mdid);
			if(newInvestorMutualFund.getAmountInvested() != null)
				oldInvestorMutualFund.setAmountInvested (newInvestorMutualFund.getAmountInvested());

			 
			oldInvestorMutualFund = investorMutualFundService.insert(oldInvestorMutualFund); 
			return ResponseEntity.ok().body(oldInvestorMutualFund);

		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
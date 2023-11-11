//package com.springboot.financialplanning.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.springboot.financialplanning.exception.InvalidIdException;
//import com.springboot.financialplanning.model.Investor;
//import com.springboot.financialplanning.model.InvestorMutualFund;
//import com.springboot.financialplanning.model.MutualFund;
//import com.springboot.financialplanning.service.InvestorMutualFundService;
//import com.springboot.financialplanning.service.InvestorService;
//import com.springboot.financialplanning.service.MutualFundService;
//
//
//
//@RestController
//public class InvestorMutualFundController {
//	@Autowired
//	InvestorService investorService;
//
//	@Autowired
//	MutualFundService mutualFundService;
//
//	@Autowired
//	InvestorMutualFundService investorMutualFundService;
//	
//	@PostMapping("/mutualfund/add/{iid}/{mfid}")
//	public ResponseEntity<?> mutualfund(@PathVariable("iid") int iid, @PathVariable("mfid") int mfid,
//			@RequestBody InvestorMutualFund investorMutualFund) {
//		try {
//			Investor investor = investorService.getByInvestorId(iid);
//			MutualFund mutualFund = mutualFundService.getByid(mfid);
//			investorMutualFund.setInvestor(investor);
//			investorMutualFund.setMutualFund(mutualFund);
//			investorMutualFund = investorMutualFundService.insert(investorMutualFund);
//			return ResponseEntity.ok().body(investorMutualFund);
//		} catch (InvalidIdException e) {
//			return ResponseEntity.badRequest().body(e.getMessage());
//		}
//	}
//
//}
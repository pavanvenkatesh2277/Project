package com.springboot.financialplanning.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.enums.InvestmentType;
import com.springboot.financialplanning.model.Insurance;
import com.springboot.financialplanning.model.Investor;
import com.springboot.financialplanning.model.InvestorInsurance;
import com.springboot.financialplanning.model.InvestorMutualFund;
import com.springboot.financialplanning.model.MutualFund;

@SpringBootTest
public class InvestorMutualFundTest {
	@Autowired
	InvestorMutualFundRepository investorMutualFundRepository;
	@Autowired
	InvestorRepository investorRepository;
	@Autowired
	MutualFundRepository mutualFundRepository;
	public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Disabled
	@Test
	void UpdateTest() {
		int id=45;
		Optional<InvestorMutualFund> existingInvestorMutualFund=investorMutualFundRepository.findById(id);
		if(existingInvestorMutualFund.isPresent()) {
		InvestorMutualFund obj=existingInvestorMutualFund.get();
		LOGGER.log(Level.INFO, "existingInvestorMutualFund :" +obj);
		
		//update the object
		obj.setSipAmount((double) 50000);
		
		
		InvestorMutualFund updatedInvestorMutualFund=investorMutualFundRepository.save(obj);
		LOGGER.log(Level.INFO, "updatedInvestorMutualFund :" +updatedInvestorMutualFund);
		}
		else {
			LOGGER.log(Level.INFO, "InvestorMutualFund not present..");
		}
	}
	@Disabled
	@Test
	void getAllInvestorMutualFundTest() {
		List<InvestorMutualFund> InvestorMutualFundList = investorMutualFundRepository.findAll();
		InvestorMutualFundList.forEach((p) -> {
			LOGGER.log(Level.INFO, "List of InvestorMutualFund" + p);
		});
	}
	@Disabled
	@Test
	void getAllMutualFundByInvestorIdAndMutualFundIDTest() {
		int investorId = 33; // Investor ID for which you want to retrieve insurance
		int mutualFundId = 21;

		Optional<Investor> existingInvestor = investorRepository.findById(investorId);
		if (existingInvestor.isPresent()) {
			Optional<MutualFund> existingMutualFund = mutualFundRepository.findById(mutualFundId);
			if (existingMutualFund.isPresent()) {
				List<InvestorMutualFund> investorMutualFundList = investorMutualFundRepository
						.findByInvestorIdAndMutualFundId(investorId, mutualFundId);
				if (!investorMutualFundList.isEmpty()) {
					LOGGER.log(Level.INFO, "List of Investor MutualFund for Investor ID " + investorId
							+ " and MutualFund ID " +mutualFundId);
					investorMutualFundList.forEach((p) -> LOGGER.log(Level.INFO, p.toString()));
				} else {
					LOGGER.log(Level.INFO, "No Investor MutualFund found for Investor ID " + investorId
							+ " and MutualFund ID " + mutualFundId);
				}
			} else {
				LOGGER.log(Level.INFO, "MutualFund ID " + mutualFundId + " is invalid");
			}
		} else {
			LOGGER.log(Level.INFO, "Investor ID " + investorId + " is invalid");
		}
	}
	@Disabled
	@Test
	void deleteInvestorMutualFundByIdMethodTest() {
		int id=18;
		Optional<InvestorMutualFund> opt=investorMutualFundRepository.findById(18);
		if(!opt.isPresent())
		{
			LOGGER.log(Level.INFO, "InvestorMutualFund not present..");
		}
		else {
			investorMutualFundRepository.deleteById(id);
		}
		}
	

}

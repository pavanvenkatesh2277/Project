package com.springboot.financialplanning.repository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.enums.Category;
import com.enums.RickFactor;
import com.springboot.financialplanning.model.Company;
import com.springboot.financialplanning.model.MutualFund;

@SpringBootTest
public class MutualFundTest {
	@Autowired
	MutualFundRepository mutualFundRepository;
	public final static Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Disabled
	@Test
	void saveMethodTest() {
		
		MutualFund c=new MutualFund(1,"ICICI SMALL CAP fund",Category.LOW_CAP,(double)185000000,RickFactor.LOW,"35%", "40%","2Y",(double)500,(double)100.16, null);
		
		MutualFund savedMutualFund=mutualFundRepository.save(c);
		LOGGER.log(Level.INFO, "savedMutualFund :" +savedMutualFund);
		
	}
	@Disabled
	@Test
	void UpdateTest() {
		int id=21;
		Optional<MutualFund> existingMutualFund=mutualFundRepository.findById(id);
		if(existingMutualFund.isPresent()) {
			MutualFund obj=existingMutualFund.get();
		LOGGER.log(Level.INFO, "existingMutualFund :" +obj);
		
		//update the object
		obj.setFundName("tata mutualfunds");
		
		
		MutualFund updatedMutualFund=mutualFundRepository.save(obj);
		LOGGER.log(Level.INFO, "updatedMutualFund :" +updatedMutualFund);
		}
		else {
			LOGGER.log(Level.INFO, "MutualFund not present..");
		}
	}
	@Disabled
	@Test
	void getAllMutualFundTest() {
		List<MutualFund> mutualFundList=mutualFundRepository.findAll();
		mutualFundList.forEach((p)->{
			LOGGER.log(Level.INFO, "List of MutualFunds"+p);
		});
}
	@Disabled
	@Test
	void getMutualFundByIdTest() {
		int id=21;
		Optional<MutualFund> opt=mutualFundRepository.findById(id);
		MutualFund c=opt.get();
		LOGGER.log(Level.INFO, "MutualFund :"+ c);

}
	@Disabled
	@Test
	void deleteMutualFundByIdMethodTest() {
		Optional<MutualFund> opt=mutualFundRepository.findById(6);
		if(!opt.isPresent())
		{
			LOGGER.log(Level.INFO, "MutualFund not present..");
		}
		else {
			mutualFundRepository.deleteById(6);
		}
		}
}

package com.springboot.financialplanning.repository;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.financialplanning.model.SalesVp;

@SpringBootTest
public class SalesVpTest {
	@Autowired
	SalesVpRepository salesVpRepository;
	public final static Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@Test
	void saveMethodTest() {
		
		SalesVp salesVp =new SalesVp (2,"raj","raj@gmail.com","9776543210", null);
		
		SalesVp savedSalesVp=salesVpRepository.save(salesVp);
		LOGGER.log(Level.INFO, "savedHr :" +savedSalesVp);
		
	}
	@Disabled
	@Test
	void getSalesVpByIdTest() {
		Optional<SalesVp> opt=salesVpRepository.findById(6);
		SalesVp c=opt.get();
		LOGGER.log(Level.INFO, "SalesVp :"+ c);

}
	@Disabled
	@Test
	void deleteSalesVPByIdMethodTest() {
		Optional<SalesVp> opt=salesVpRepository.findById(6);
		salesVpRepository.deleteById(6);
		if(!opt.isPresent())
		{
			LOGGER.log(Level.INFO, "SalesVp not present..");
		}
		}
	@Disabled
	@Test
	void UpdateTest() {
		
		Optional<SalesVp> existingSalesVp=salesVpRepository.findById(6);
		if(existingSalesVp.isPresent()) {
			SalesVp obj=existingSalesVp.get();
		LOGGER.log(Level.INFO, "existingSalesVp :" +obj);
		
		//update the object
		obj.setName("Nithin");
		
		//productRepo.save(existingProduct);
		SalesVp updatedSalesVp=salesVpRepository.save(obj);
		LOGGER.log(Level.INFO, "updatedSalesVp :" +updatedSalesVp);
		}
		else {
			LOGGER.log(Level.INFO, "SalesVp not present..");
		}
	}	

}

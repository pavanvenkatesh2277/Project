package com.springboot.financialplanning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.financialplanning.model.Insurance;



public interface InsuranceRepository extends JpaRepository<Insurance, Integer>{
	
	

}
package com.springboot.financialplanning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.financialplanning.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	


}

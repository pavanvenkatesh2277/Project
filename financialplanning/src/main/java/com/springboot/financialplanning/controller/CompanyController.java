package com.springboot.financialplanning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enums.Role;
import com.springboot.financialplanning.exception.InvalidIdException;
import com.springboot.financialplanning.model.Company;
import com.springboot.financialplanning.model.User;
import com.springboot.financialplanning.service.CompanyService;
import com.springboot.financialplanning.service.UserService;


@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/add")
	public Company insertCompany(@RequestBody Company company) {
		
		/*save user info in database*/
		User user=company.getUser();
		String passwordPlain=user.getPassword();
		String encodedPassword=passwordEncoder.encode(passwordPlain);
		user.setPassword(encodedPassword);
		
		user.setRole(Role.COMPANY);
		user=userService.insert(user);
		
		company.setUser(user);
		
		return companyService.insert(company);
	}
	
	
	@GetMapping("/all")
	public List<Company>getAllCompanies(){
		List<Company> list = companyService.getAllCompanies();
		return list;
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<?> getCompanyById(@PathVariable("id") int id) {
		try {
			Company company = companyService.getCompanyById(id);
			return ResponseEntity.ok().body(company);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCompany(@PathVariable("id") int id) {
		try {
			Company company = companyService.getCompanyById(id);
			companyService.deleteCompany(company.getId());
			return ResponseEntity.ok().body("Company Record deleted");
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCompany(@PathVariable("id") int id, 
			@RequestBody Company newcompany) {
		try {
			Company company = companyService.getCompanyById(id);
			if(newcompany.getName() != null)
				company.setName(newcompany.getName());
			if(newcompany.getEmail() != null)
				company.setEmail(newcompany.getEmail());
			if(newcompany.getFundtype() != null)
				company.setFundtype(newcompany.getFundtype());
			
				company = companyService.insert(company);
			return ResponseEntity.ok().body(company);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}
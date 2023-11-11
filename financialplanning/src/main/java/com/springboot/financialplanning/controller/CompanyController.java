package com.springboot.financialplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enums.Role;
import com.springboot.financialplanning.model.Company;
import com.springboot.financialplanning.model.User;
import com.springboot.financialplanning.service.CompanyService;
import com.springboot.financialplanning.service.UserService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	CompanyService companyService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/add")
	public Company insertCompany(@RequestBody Company company) {
		/*save user info in db*/
		User user=company.getUser();
		String passwordPlain=user.getPassword();
		String encodedPassword=passwordEncoder.encode(passwordPlain);
		user.setPassword(encodedPassword);
		
		user.setRole(Role.COMPANY);
		user=userService.insert(user);
		
		company.setUser(user);
		
		return companyService.insert(company);
	}
}
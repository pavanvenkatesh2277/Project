package com.springboot.financialplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enums.Role;
import com.springboot.financialplanning.exception.InvalidIdException;
import com.springboot.financialplanning.model.Investor;
import com.springboot.financialplanning.model.User;
import com.springboot.financialplanning.service.InvestorService;
import com.springboot.financialplanning.service.UserService;


@RestController
@RequestMapping("/investor")
public class InvestorController {

	@Autowired
	private InvestorService investorService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/add")
	public Investor insertInvestor(@RequestBody Investor investor) {
		/*save user info in db*/
		User user=investor.getUser();
		String passwordPlain=user.getPassword();
		String encodedPassword=passwordEncoder.encode(passwordPlain);
		user.setPassword(encodedPassword);
		
		user.setRole(Role.INVESTOR);
		user=userService.insert(user);
		
		investor.setUser(user);
		
		return investorService.insert(investor);
	}
	
	@GetMapping("/getone/{iid}")
	public ResponseEntity<?> getOne(@PathVariable("iid")int iid) {
		
		try {
			Investor investor = investorService.getByInvestorId(iid);
			return ResponseEntity.ok().body(investor);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}  
	
}

package com.greatlearning.rest.employeemanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.rest.employeemanagement.entity.User;
import com.greatlearning.rest.employeemanagement.repository.UserRepo;

@Service
public class UserService {
	
	
	@Autowired
	public UserRepo userRepo;
	
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	
	
	public void save (User user) {
		
		userRepo.save(user);
	}
	

}

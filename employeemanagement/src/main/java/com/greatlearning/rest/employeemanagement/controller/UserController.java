package com.greatlearning.rest.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.rest.employeemanagement.entity.Employee;
import com.greatlearning.rest.employeemanagement.entity.Role;
import com.greatlearning.rest.employeemanagement.entity.User;
import com.greatlearning.rest.employeemanagement.repository.RoleRepository;
import com.greatlearning.rest.employeemanagement.repository.UserRepo;
import com.greatlearning.rest.employeemanagement.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	public RoleRepository roleRepository;
	@Autowired
	public UserRepo userRepo;
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/adduser")
	public  void adduser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.save(user);
	}
	
	@PostMapping("/assignrole/{userid}/{roleid}")
	public User assignUserRole(@PathVariable int userid,@PathVariable int roleid ) {
		User user = userRepo.findById(userid).orElse(null);
		Role role = roleRepository.findById(roleid).orElse(null);
		
		List<Role> userRoles = user.getRoles();
		userRoles.add(role);
		user.setRoles(userRoles);
		userRepo.save(user);
		return user;
	}
	
	@GetMapping("/getuser/{id}")
	public User getUserbyid(@PathVariable int id ) {
	User user = userRepo.findById(id).orElse(null);
	return user;
	}
}

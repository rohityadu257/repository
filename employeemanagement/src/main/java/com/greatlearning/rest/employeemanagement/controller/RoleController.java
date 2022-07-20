package com.greatlearning.rest.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.rest.employeemanagement.entity.Role;
import com.greatlearning.rest.employeemanagement.repository.RoleRepository;
import com.greatlearning.rest.employeemanagement.services.RoleService;

@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	public RoleService roleservice;

	@Autowired
	public RoleRepository roleRepository;

	@PostMapping("/addrole")
	public void save(@RequestBody Role role) {
		roleservice.save(role);

	}

	@GetMapping("/getrole/{id}")
	public Role getrolebyid(@PathVariable int id) {
		Role role = roleRepository.findById(id).orElse(null);
		return role;
	}

}

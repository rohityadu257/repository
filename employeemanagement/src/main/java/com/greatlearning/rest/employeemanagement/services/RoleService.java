package com.greatlearning.rest.employeemanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.rest.employeemanagement.entity.Role;
import com.greatlearning.rest.employeemanagement.entity.User;
import com.greatlearning.rest.employeemanagement.repository.RoleRepository;
import com.greatlearning.rest.employeemanagement.repository.UserRepo;

@Service
public class RoleService {
	
	@Autowired
	public RoleRepository roleRepository;
	@Autowired
	public UserRepo userRepo;
	
	public void save (Role role) {
		roleRepository.save(role);
	}
	
	public void assignUserRole(Integer Userid,Integer rolesid) {
		User user = userRepo.findById(Userid).orElse(null);
		Role role =roleRepository.findById(rolesid).orElse(null);
		
		
		List<Role> userRoles = user.getRoles();
		userRoles.add(role);
		user.setRoles(userRoles);
		userRepo.save(user);
	}

}

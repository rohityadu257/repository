package com.greatlearning.rest.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.rest.employeemanagement.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	User findByUsername(String Username);
	
	
}

package com.greatlearning.rohit.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.rohit.student.management.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
}

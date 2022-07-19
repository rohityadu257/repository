package com.greatlearning.rest.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.rest.employeemanagement.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}

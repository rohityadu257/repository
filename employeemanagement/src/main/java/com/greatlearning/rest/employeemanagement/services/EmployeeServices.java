package com.greatlearning.rest.employeemanagement.services;

import java.util.List;


import com.greatlearning.rest.employeemanagement.entity.Employee;

public interface EmployeeServices {

	public Employee findById(int id);

	public void save(Employee employee);

	public void deleteById(int id);

	void addEmployee(Employee employee);

	void updateEmployee(Employee emp, int id);

	public List<Employee> getAllEmployee();

	public List<Employee> findAllempASC(String field);
	
	public List<Employee> findAllempDesc(String field);
	

	public List<Employee> findByFirstname(String firstName);
	
	
	
	

}

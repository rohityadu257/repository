package com.greatlearning.rest.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.rest.employeemanagement.entity.Employee;
import com.greatlearning.rest.employeemanagement.services.EmployeeServices;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	public EmployeeServices employeeServices;

	// Displaying List of All Employee
	@GetMapping("/allemployee")
	public List<Employee> getAllEmployee() {
		return employeeServices.getAllEmployee();

	}

	@GetMapping("/sortedby/{field}")
	public List<Employee> getAllEmployee(@PathVariable String field) {

		return employeeServices.findAll(field);

	}

	@GetMapping("/allemployee/{id}")
	public Employee findById(@PathVariable int id) {
		return employeeServices.findById(id);
	}

	@DeleteMapping("/deleteemployee/{id}")

	public @ResponseBody String deleteEmployee(@PathVariable int id) {
		employeeServices.deleteById(id);
		return "Deleted Employee with id " + id;
	}

	@PostMapping("/addnewemployee")
	public void addemployee(@RequestBody Employee emp) {
		employeeServices.save(emp);

	}

	@PutMapping("/updateemployee/{id}")
	public @ResponseBody Employee updateEmployee(@RequestBody Employee emp, @PathVariable int id) {
		employeeServices.save(emp);
		return emp;
	}

	@GetMapping("/getemployeebyfirstname/{firstname}")
	public List<Employee> findByFirstname(@PathVariable String firstname) {
		return employeeServices.findByFirstname(firstname);
	}

	@RequestMapping("/403")
	public String showerrorpage() {
		return "403- Access Denied";

	}
}

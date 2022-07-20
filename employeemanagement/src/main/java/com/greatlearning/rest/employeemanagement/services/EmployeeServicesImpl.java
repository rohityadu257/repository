package com.greatlearning.rest.employeemanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greatlearning.rest.employeemanagement.entity.Employee;
import com.greatlearning.rest.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);

	}

	@Override
	public void updateEmployee(Employee emp, int id) {
		if (id == emp.getId()) {
			employeeRepository.save(emp);
		}

	}

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public List<Employee> findAll(String field) {
		// TODO Auto-generated method stub
		return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	@Override
	public List<Employee> findByFirstname(String firstname) {
		List<Employee> employee = employeeRepository.findAll(firstname);
		return employee;
	}
}

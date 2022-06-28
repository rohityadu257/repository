package com.greatlearning.service;


import java.util.List;

import com.greatlearning.model.Student;


public interface StudentService {
		
	public List<Student> findAll();
	public Student findById(long Id);
	public void  save(Student student);
	public void delete(long Id);
}

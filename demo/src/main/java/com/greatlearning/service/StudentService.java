package com.greatlearning.service;


import java.util.List;

import com.greatlearning.model.Student;


public interface StudentService {
		
	public List<Student> findAll();
	public Student findByID(long id);
	public void  save(Student student);
	public void deleteByID(long id);
}

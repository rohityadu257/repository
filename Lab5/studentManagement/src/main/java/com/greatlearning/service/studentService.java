package com.greatlearning.service;


import java.util.List;

import com.greatlearning.model.student;


public interface studentService {
		
	public List<student> findAll();
	public student findByID(long id);
	public void  Save(student student);
	public void deleteByID(long id);
}

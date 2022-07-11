package com.greatlearning.rohit.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.rohit.student.management.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
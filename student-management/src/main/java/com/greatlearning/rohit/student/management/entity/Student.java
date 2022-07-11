package com.greatlearning.rohit.student.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Student_Details")
@Data
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id ;
	@Column(name = "FirstName")
	private String firstname;
	@Column(name = "LastName")
	private String lastname;
	@Column(name = "Course")
	private String course;
	@Column(name = "Country")
	private String country;

	public Student(String firstname, String lastname, String course, String country) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.course = course;
		this.country = country;
	}

	
	

}

package com.greatlearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table (name = "Student_detail")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long Id;
	
	@Column (name = "f_name")
	private String fname;
	
	@Column (name = "l_name")
	private String lname;
	
	@Column (name= "courses")
	private String course;
	
	@Column (name = "country")
	private String country;
	

	public Student() {
	}
	
	public Student(String fname, String lname, String course, String country) {
		
		this.fname = fname;
		this.lname = lname;
		this.course = course;
		this.country = country;
	}
	
	
	
	public long getid() {
		return Id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "student [id=" + Id + ", fname=" + fname + ", lname=" + lname + ", course=" + course + ", country="
				+ country + "]";
	}
	
	

}

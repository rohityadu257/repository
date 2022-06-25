package com.greatlearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table (name = "Student_detail")
public class student {
	

	public student() {
	}
	
	public student(String f_name, String l_name, String course, String country) {
		
		this.f_name = f_name;
		this.l_name = l_name;
		this.course = course;
		this.country = country;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column (name = "f_name")
	private String f_name;
	
	@Column (name = "l_name")
	private String l_name;
	
	@Column (name= "courses")
	private String course;
	
	@Column (name = "country")
	private String country;
	
	
	public long getid() {
		return id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
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
		return "student [id=" + id + ", f_name=" + f_name + ", l_name=" + l_name + ", course=" + course + ", country="
				+ country + "]";
	}
	
	

}

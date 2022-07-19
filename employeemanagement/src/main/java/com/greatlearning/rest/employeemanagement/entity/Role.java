package com.greatlearning.rest.employeemanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Data
@Table(name = "roles")
public class Role {
	

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int Id;
	@Column
	private String name;


}

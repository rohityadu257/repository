package com.greatlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.model.Student;
import com.greatlearning.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
	public String ListStudents(Model model) {
		List<Student> thestudents = studentService.findAll();
		model.addAttribute("students" , thestudents);
		return "list-students";
		
	}
	@RequestMapping("/ShowFormForAdd")
	public String showFormforAdd(Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		model.addAttribute("mode","Add");
		return "student-form";
		
	}
	
	@RequestMapping("/ShowFormForupdate")
	public String showFormforupdate(@RequestParam("Id")long Id,Model model) {
		Student student = studentService.findById(Id);
		model.addAttribute("student",student);
		model.addAttribute("mode","Update");
		return "student-form";
		
	}
	@PostMapping("/save")
	public String saveStudent(@RequestParam("Id") long Id,
			@RequestParam("fname") String fname,
			@RequestParam("lname") String lname,
			@RequestParam("course") String course,
			@RequestParam("country") String country)
		
			 {
		Student student = null;
		if(Id == 0) {
			
			student = new Student(fname,lname,course,country);
		}else {
			student = studentService.findById(Id);
			student.setFname(fname);
			student.setLname(lname);
			student.setCourse(course);
			student.setCountry(country);
			
		}
		studentService.save(student);
		return "redirect:list";
	}
	  
	
		@RequestMapping("/delete")
	    public String deleteStudent(@RequestParam("Id") long Id){
	        studentService.delete(Id);
	        return "redirect:list";
	    }
	
		
}

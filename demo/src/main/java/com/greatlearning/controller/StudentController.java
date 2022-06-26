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
		Student Student = new Student();
		model.addAttribute("student",Student);
		model.addAttribute("model","add");
		return "student-form";
		
	}
	
	@RequestMapping("/ShowFormForupdate")
	public String showFormforupdate(@RequestParam("id")long id,Model model) {
		Student Student = studentService.findByID(id);
		model.addAttribute("student",Student);
		model.addAttribute("model","update");
		return "student-form";
		
	}
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") long id,@RequestParam("f_name") String F_name, @RequestParam("l_name") String l_name, @RequestParam("course") String course,
			@RequestParam("country") String country) {
		Student Student = null;
		if(id == 0) {
			Student = new Student(F_name,l_name,course,country);
		}else {
			Student = studentService.findByID(id);
			Student.setF_name(F_name);
			Student.setL_name(l_name);
			Student.setCourse(course);
			Student.setCountry(country);
		
		}
		studentService.save(Student);
		return "redirect:list-students";
	}
	
	
		@RequestMapping("/delete")
	    public String deleteStudent(@RequestParam("id") long id){
	        studentService.deleteByID(id);
	        return "list-students";
	    }
	
		
}

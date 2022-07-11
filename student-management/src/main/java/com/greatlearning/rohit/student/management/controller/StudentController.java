package com.greatlearning.rohit.student.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.rohit.student.management.entity.Student;
import com.greatlearning.rohit.student.management.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String listStudents(Model model) {
		List<Student> student = studentService.findAll();
		model.addAttribute("students", student);
		return "student-list";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("mode", "Add");

		return "student-form";

	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		model.addAttribute("student", studentService.findById(id));
		model.addAttribute("mode", "Update");
		return "student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("course") String course,
			@RequestParam("country") String country) {
		Student student = null;
		//System.out.println(firstname);
		if (id == 0) {
			student = new Student(firstname, lastname, course, country);
		} else {
			student = studentService.findById(id);
			student.setFirstname(firstname);
			student.setLastname(lastname);
			student.setCourse(course);
			student.setCountry(country);
		}
		studentService.save(student);
		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		studentService.deleteById(id);
		return "redirect:/student/list";
	}

	@RequestMapping("/403")
	public String showerrorpage() {
		return "403";
	}
}

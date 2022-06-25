package com.greatlearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class welcomeController {
	
	@RequestMapping("/")
	public String showHome() {
	return "home";
	}
}

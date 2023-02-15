package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.service.MService;
import com.java.service.MServiceImpl;
import com.java.service.NewMServiceImpl;

@Controller
public class FController {

	@Autowired
	MService mservice;
	
	@GetMapping("index")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("login")
	public String login(Model model) {
		String id = mservice.memberSelectOne();
		
		
		return "login";
	}
	
	
}//class

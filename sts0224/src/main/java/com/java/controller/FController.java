package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("page")
	public String page() {
		return "page";
	}
	
	@GetMapping("pageView/{page}")
	public String pageView(@PathVariable String page, Model model) {
		model.addAttribute("pathPage",page);
		return "pageView";
	}
	
	@GetMapping("pageView2")
	public String pageView2(String page, Model model) {
		model.addAttribute("pathPage",page);
		return "pageView2";
	}
	
	@GetMapping("email")
	public String email() {
		return "email";
	}
}

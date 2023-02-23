package com.java.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FController {
	
	@Autowired
	HttpSession session;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("login")
	public String login() {
		return "login";
	}
}

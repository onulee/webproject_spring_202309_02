package com.java.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.service.MailService;

@Controller
public class MailController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	MailService mailService;
	
	@GetMapping("email")
	public String email() {
		return "email"; // WEB-INF/views + email + .jsp
	}
	
	@RequestMapping("sendEmail")
	@ResponseBody  //jsp페이지로 리턴하지 않고, data로 리턴
	public void sendEmail(String userEmail,String userName) {
		System.out.println("controller userEmail : "+userEmail);
		
		//mailService연결
		String pwCode = mailService.mailSend2(userEmail, userName);
		session.setAttribute("sessionPwCode", pwCode);
		
	}

}

package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.service.EmailService;

@Controller
public class EmailController {

	@Autowired
    private EmailService emailService;
	
	@RequestMapping("email")
	public String email() {
		return "email";
	}

	// 등록된 이메일로 임시비밀번호를 발송하고 발송된 임시비밀번호로 사용자의 pw를 변경하는 컨트롤러
	@PostMapping("sendEmail")
	@ResponseBody
	public void sendEmail(@RequestParam String userEmail, @RequestParam String userName) {
		// 임시비밀번호생성후 이메일전송
		emailService.mailSend3(userEmail, userName);

	}
}
